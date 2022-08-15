package com.banquemisr;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication

//@ComponentScan(basePackageClasses = CustomerController.class)
//@EntityScan(basePackages={"com.banquemisr.persistence.*"})
//@ComponentScan(basePackageClasses = "")
public class InternshipApplication {
    public static void main(String... args) {


//        System.out.println( api.getCustomer(1).toString());
        SpringApplication.run(InternshipApplication.class, args);
    }

    @Bean
    public ModelMapper modelMapper() {

        return new ModelMapper();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder()
    {
        return new BCryptPasswordEncoder();
    }

}