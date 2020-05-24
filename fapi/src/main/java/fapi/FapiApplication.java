package fapi;

import fapi.utils.AuthorizationBean;
import fapi.utils.Base64Bean;
import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class FapiApplication {


    @Bean
    public Base64Bean base64Bean() {
        return new Base64Bean();
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT)
                .setFieldMatchingEnabled(true)
                .setSkipNullEnabled(true)
                .setFieldAccessLevel(Configuration.AccessLevel.PRIVATE);
        return modelMapper;
    }

    @Bean
    public AuthorizationBean authorizationBean() {
        AuthorizationBean authorizationBean = new AuthorizationBean();
        return authorizationBean;
    }

    public static void main(String[] args) {
        SpringApplication.run(FapiApplication.class, args);
    }
}
