package com.dyPham.examSpringboot.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigBase {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
