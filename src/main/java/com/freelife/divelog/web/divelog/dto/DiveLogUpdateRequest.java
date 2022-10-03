package com.freelife.divelog.web.divelog.dto;

import com.freelife.divelog.core.divelog.application.dto.DiveLogUpdateCommand;
import lombok.Getter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalTime;

@Getter
public class DiveLogUpdateRequest {
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
    
    public DiveLogUpdateCommand convertToUpdateCommand() {
        return DiveLogUpdateCommand.create(diveDate, entryTime, exitTime, weather, buddyName, comment);
    }
}
