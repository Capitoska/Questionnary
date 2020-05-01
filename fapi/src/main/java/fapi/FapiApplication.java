package fapi;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class FapiApplication {

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    // @Bean
    // public String currentUser(){
    //     Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    //     return auth.getName();
    // }

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper;
    }

    public static void main(String[] args) {
        SpringApplication.run(FapiApplication.class, args);
    }
}
