package com.freelife.divelog.config;

import lombok.Getter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

@Getter
@ToString
@ConfigurationProperties(prefix = "site")
public class SiteProperties {
    private final String authorName;
    private final String authorEmail;
    
    @ConstructorBinding
    public SiteProperties(String authorName, String authorEmail) {
        this.authorName = authorName;
        this.authorEmail = authorEmail;
    }
    
    
}
