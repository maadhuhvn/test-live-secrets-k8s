package org.spring.cloud.example.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;

@Data
@RefreshScope
@Configuration
public class AtValueConfig {
    @Value("${message:default message}")
    private String message;
    @Value("${threshold:30}")
    private int threshold;
}
