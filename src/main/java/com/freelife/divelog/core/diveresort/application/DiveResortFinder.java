package com.freelife.divelog.core.diveresort.application;

import com.freelife.divelog.core.diveresort.application.dto.DiveResortDto;

import java.util.List;
import java.util.Optional;

public interface DiveResortFinder {
    /**
     * 등록된 모든 다이브리조트 목록을 반환한다.
     * 
     * @return List<DiveResortDto> 개체
     */
    List<DiveResortDto> findAll();

    /**
     * 요청받은 다이브포인트를 반환한다.
     * 
     * @param diveResortId
     * @return Optional<DiveResortDto>
     */
    Optional<DiveResortDto> findByDiveResortId(Long diveResortId);
}
