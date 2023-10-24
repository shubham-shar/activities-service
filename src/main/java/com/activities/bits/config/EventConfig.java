package com.activities.bits.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "event-service")
public class EventConfig {
    private String url;
    private String eventsPath;
    private String eventByIdPath;
}
