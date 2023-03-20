package com.estockCompany.estockCompanyservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableJpaRepositories
public class EstockCompanyServiceApplication {

   @Bean
   public RestTemplate getRestTemplate() {
      return new RestTemplate();
   }

   public static void main(String[] args) {
      SpringApplication.run(EstockCompanyServiceApplication.class, args);
   }
}
