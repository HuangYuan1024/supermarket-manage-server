package com.huangyuan.information.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(String.class, java.sql.Timestamp.class,
                source -> (source == null || source.trim().isEmpty()) ? null
                        : java.sql.Timestamp.valueOf(source));
    }
}
