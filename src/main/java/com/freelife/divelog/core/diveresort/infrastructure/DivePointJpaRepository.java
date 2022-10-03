package com.freelife.divelog.core.diveresort.infrastructure;

import com.freelife.divelog.core.diveresort.domain.DivePoint;
import com.freelife.divelog.core.diveresort.domain.DivePointRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DivePointJpaRepository  extends DivePointRepository, JpaRepository<DivePoint, Long> {

}
