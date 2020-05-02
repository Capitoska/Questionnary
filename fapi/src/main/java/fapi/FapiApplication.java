package fapi;

import fapi.utils.AuthorizationBean;
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

    @Bean
    public AuthorizationBean authorizationBean(){
        AuthorizationBean authorizationBean = new AuthorizationBean();
        return authorizationBean;
    }

    public static void main(String[] args) {
        SpringApplication.run(FapiApplication.class, args);
    }
}
