package co.hrd.restapi.config;

import jakarta.servlet.annotation.WebServlet;
import org.modelmapper.ModelMapper;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeenConfig {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }


}
