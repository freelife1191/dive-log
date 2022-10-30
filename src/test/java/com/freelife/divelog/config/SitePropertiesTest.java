package com.freelife.divelog.config;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class SitePropertiesTest {

    @Test
    void test(@Autowired SiteProperties siteProperties) {
        assertThat(siteProperties.getAuthorName()).isEqualTo("Freelife-local");
        assertThat(siteProperties.getAuthorEmail()).isEqualTo("freelife1191.local@gmail.com");
    }

}
