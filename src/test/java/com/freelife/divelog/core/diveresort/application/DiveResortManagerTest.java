package com.freelife.divelog.core.diveresort.application;

import com.freelife.divelog.core.diveresort.domain.DiveResortRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class DiveResortManagerTest {
    @Mock
    private DiveResortRepository diveResortRepository;
    private DiveResortManager diveResortManager;
    
    @BeforeEach
    void setUp() {
        diveResortManager = new DiveResortManager(diveResortRepository);
    }

    @Test
    void test() {
        diveResortManager.findAll();
    }

}
