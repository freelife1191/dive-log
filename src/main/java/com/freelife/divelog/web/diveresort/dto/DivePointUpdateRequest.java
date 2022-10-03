package com.freelife.divelog.web.diveresort.dto;

import com.freelife.divelog.core.diveresort.application.dto.DivePointUpdateCommand;
import lombok.Getter;

import javax.validation.constraints.NotBlank;

/**
 * 다이브포인트 갱신요청
 * 
 * @author springrunner.kr@gmail.com
 *
 */
@Getter
public class DivePointUpdateRequest {
    @NotBlank
    private String name;
    @NotBlank
    private String depth;
    @NotBlank
    private String description;

    public DivePointUpdateCommand convertToUpdateCommand() {
        return DivePointUpdateCommand.create(getName(), getDepth(), getDescription());
    }
}
