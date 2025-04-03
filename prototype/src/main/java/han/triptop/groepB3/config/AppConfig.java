package han.triptop.groepB3.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import han.triptop.groepB3.factory.ActivityFactory;

@Configuration
public class AppConfig {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
    
    @Bean
    public ActivityFactory activityFactory() {
        return new ActivityFactory();
    }
} 