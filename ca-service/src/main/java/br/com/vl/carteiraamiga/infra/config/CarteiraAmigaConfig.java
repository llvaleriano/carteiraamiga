package br.com.vl.carteiraamiga.infra.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class CarteiraAmigaConfig {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

}
