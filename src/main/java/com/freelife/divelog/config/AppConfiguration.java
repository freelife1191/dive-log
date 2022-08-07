package com.freelife.divelog.config;

import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Kane on 2022/06/06.
 */
@Configuration
@ConfigurationPropertiesScan
@EnableConfigurationProperties({ MyServiceProperties.class, SiteProperties.class })
public class AppConfiguration {
}
