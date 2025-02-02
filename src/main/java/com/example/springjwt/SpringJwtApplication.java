package com.example.springjwt;

import com.example.springjwt.domain.Role;
import com.example.springjwt.domain.User;
import com.example.springjwt.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


import java.util.ArrayList;

@SpringBootApplication
public class SpringJwtApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringJwtApplication.class, args);
    }

    @Bean
    BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    CommandLineRunner run(UserService userService) {
        return args -> {
            userService.saveRole(new Role(null,"ROLE_USER"));
            userService.saveRole(new Role(null,"ROLE_MANAGER"));
            userService.saveRole(new Role(null,"ROLE_ADMIN"));
            userService.saveRole(new Role(null,"ROLE_SUPER_ADMIN"));
            userService.saveUser(new User(null,"Alex","alex","1234",new ArrayList<>()));
            userService.saveUser(new User(null,"Baroni","baroni","1234",new ArrayList<>()));
            userService.saveUser(new User(null,"Dzeko","dzeko","1234",new ArrayList<>()));
            userService.saveUser(new User(null,"Sow","sow","1234",new ArrayList<>()));
            userService.addRoleToUser("alex","ROLE_USER");
            userService.addRoleToUser("alex","ROLE_MANAGER");
            userService.addRoleToUser("baroni","ROLE_MANAGER");
            userService.addRoleToUser("dzeko","ROLE_ADMIN");
            userService.addRoleToUser("sow","ROLE_SUPER_ADMIN");
            userService.addRoleToUser("sow","ROLE_ADMIN");
            userService.addRoleToUser("sow","ROLE_USER");

        };
    }
}
