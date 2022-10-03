package com.freelife.divelog.core.divelog.infrastructure;

import com.freelife.divelog.core.divelog.domain.DiveLog;
import com.freelife.divelog.core.divelog.domain.DiveLogRepository;
import com.freelife.divelog.core.diveresort.domain.DiveResort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DiveLogJpaRepository extends DiveLogRepository, JpaRepository<DiveLog, Long> {
    @Override
    @Query("SELECT diveLog FROM DiveLog diveLog "
            + "JOIN diveLog.divePoint divePoint "
            + "JOIN divePoint.diveResort "
            + "WHERE diveResort = :diveResort")
    List<DiveLog> findByDiveResort(DiveResort diveResort);
}
