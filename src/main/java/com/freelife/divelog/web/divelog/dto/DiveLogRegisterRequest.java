package com.freelife.divelog.web.divelog.dto;

import com.freelife.divelog.core.divelog.application.dto.DiveLogRegisterCommand;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
public class DiveLogRegisterRequest {
    @NotNull
    private Long divePointId;
    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate diveDate;
    @NotNull
    @DateTimeFormat(pattern = "hh:mm:ss")
    private LocalTime entryTime;
    @NotNull
    @DateTimeFormat(pattern = "hh:mm:ss")
    private LocalTime exitTime;
    @NotEmpty
    private String weather;
    @NotEmpty
    private String buddyName;
    @NotEmpty
    private String comment;
    
    public DiveLogRegisterCommand convertToRegisterCommand() {
        return DiveLogRegisterCommand.create(divePointId, diveDate, entryTime, exitTime, weather, buddyName, comment);
    }
}
