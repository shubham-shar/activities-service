package com.activities.bits.config;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "movie-service")
public class MovieConfig {
    private String url;
    private String moviesPath;
    private String movieByIdPath;
}
