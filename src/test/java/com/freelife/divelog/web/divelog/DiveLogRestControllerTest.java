package com.freelife.divelog.web.divelog;

import com.freelife.divelog.IntegrationMockMvcTest;
import com.freelife.divelog.core.divelog.application.DiveLogManager;
import com.freelife.divelog.core.divelog.domain.DiveLogRepository;
import com.freelife.divelog.core.diveresort.domain.DivePoint;
import com.freelife.divelog.core.diveresort.domain.DivePointRepository;
import com.freelife.divelog.core.diveresort.domain.DiveResort;
import com.freelife.divelog.core.diveresort.domain.DiveResortRepository;
import com.freelife.divelog.web.divelog.dto.DiveLogRegisterRequest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@IntegrationMockMvcTest
public class DiveLogRestControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    DiveResortRepository diveResortRepository;
    @Autowired
    DivePointRepository divePointRepository;
    @Autowired
    DiveLogRepository diveLogRepository;
    @Autowired
    DiveLogManager diveLogManager;

    DiveResort diveResort;
    DivePoint divePoint;

    @BeforeEach
    void setUp() {
        diveResort = DiveResort.create("동해다이브", "허니몬", "033-0000-0000", "강원도 동해시", "아직 개업하지 않음");
        diveResortRepository.save(diveResort);

        divePoint = DivePoint.create(diveResort, "Point1: 동서남북", "15-18m", "자연암반지형으로 동쪽에는 정치망이 있으니 조심...");
        divePointRepository.save(divePoint);
    }

    @AfterEach
    void tearDown() {
        diveLogRepository.deleteAll();
        divePointRepository.deleteAll();
        diveResortRepository.deleteAll();
    }

    @Test
    void testRegister() throws JsonProcessingException, Exception {
        DiveLogRegisterRequest registerRequest = new DiveLogRegisterRequest();
        registerRequest.setDivePointId(divePoint.getId());
        registerRequest.setDiveDate(LocalDate.now());
        registerRequest.setEntryTime(LocalTime.now().minusMinutes(30));
        registerRequest.setExitTime(LocalTime.now());
        registerRequest.setWeather("맑음");
        registerRequest.setBuddyName("손섴구");
        registerRequest.setComment("물이 차가웠다. 입이 돌아갈 만큼...");

        this.mockMvc
                .perform(post("/dive-logs").contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsBytes(registerRequest)))
                .andDo(MockMvcResultHandlers.print()).andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(jsonPath("$.diveResortId", is(diveResort.getId().intValue())))
                .andExpect(jsonPath("$.diveResortName", is(diveResort.getName())))
                .andExpect(jsonPath("$.divePointId", is(divePoint.getId().intValue())))
                .andExpect(jsonPath("$.divePointName", is(divePoint.getName())))
                .andExpect(jsonPath("$.weather", is(registerRequest.getWeather())));
    }
}
