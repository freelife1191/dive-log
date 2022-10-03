package com.freelife.divelog.core.diveresort.infrastructure;

import com.freelife.divelog.core.diveresort.domain.DiveResort;
import com.freelife.divelog.core.diveresort.domain.DiveResortRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiveResortJpaRepository extends DiveResortRepository, JpaRepository<DiveResort, Long> {

}
