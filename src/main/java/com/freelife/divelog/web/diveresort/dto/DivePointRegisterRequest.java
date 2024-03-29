package com.freelife.divelog.web.diveresort.dto;

import com.freelife.divelog.core.diveresort.application.dto.DivePointRegisterCommand;
import lombok.Getter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * 다이브포인트 등록요청
 * 
 * @author springrunner.kr@gmail.com
 *
 */
@Getter
public class DivePointRegisterRequest {
    @NotNull
    private Long diveResortId;
    @NotEmpty
    private String name;
    @NotEmpty
    private String depth;
    @NotEmpty
    private String description;
    
    public DivePointRegisterCommand convertToRegisterCommand() {
        return DivePointRegisterCommand.create(getDiveResortId(), getName(), getDepth(), getDescription());
    }

}
