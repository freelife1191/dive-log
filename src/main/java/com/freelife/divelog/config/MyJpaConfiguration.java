package com.freelife.divelog.config;

import com.freelife.divelog.core.divelog.domain.DiveLog;
import com.freelife.divelog.core.diveresort.domain.DiveResort;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;

@EntityScan(basePackageClasses = {DiveResort.class, DiveLog.class})
@Configuration
public class MyJpaConfiguration {
}
