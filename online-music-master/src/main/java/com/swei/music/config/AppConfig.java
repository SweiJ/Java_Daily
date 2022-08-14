package com.swei.music.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiPC
 * Date: 2022-08-11
 * Time: 20:56
 */
@Configuration
public class AppConfig {

    @Bean
    public BCryptPasswordEncoder getBCyptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
