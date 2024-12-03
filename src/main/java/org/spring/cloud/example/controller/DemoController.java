package org.spring.cloud.example.controller;

import org.spring.cloud.example.config.AtValueConfig;
import org.spring.cloud.example.config.PropertyConfig;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;
import java.util.Map;

@RefreshScope
@RestController
@RequestMapping(value = "/v1")
public class DemoController {
    private final PropertyConfig propertyConfig;
    private final AtValueConfig atValueConfig;

    public DemoController(PropertyConfig propertyConfig, AtValueConfig atValueConfig) {
        this.propertyConfig = propertyConfig;
        this.atValueConfig = atValueConfig;
    }

    @GetMapping("/secret")
    public Map<String, Object> liveReload() {
        Map<String, Object> configInfo = new LinkedHashMap<>();
        configInfo.put("message", atValueConfig.getMessage());
        configInfo.put("threshold", atValueConfig.getThreshold());
        configInfo.put("testConfigmapProperty", propertyConfig.getTestConfigmapProperty());
        configInfo.put("testSecretProperty", propertyConfig.getTestSecretProperty());
        configInfo.put("testMountedSecretProperty", propertyConfig.getTestMountedSecretProperty());
        return configInfo;
    }
}
