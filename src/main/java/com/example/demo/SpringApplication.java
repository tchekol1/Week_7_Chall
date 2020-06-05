package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@SpringBootApplication
public class SpringApplication {

  public static void main(String[] args) {
    org.springframework.boot.SpringApplication.run(SpringApplication.class, args);
  }
  @Bean
  public CommandLineRunner run(UserRepository userRepository, RoleRepository roleRepository) throws Exception {
    return (String[] args) -> {

      roleRepository.save(new Role("USER"));
      roleRepository.save(new Role("ADMIN"));

      Role adminRole = roleRepository.findByRole("USER");
      Role userRole = roleRepository.findByRole("ADMIN");

      User user = new User("jim@jim.com", "password", "Jim", "Jimmerson", true,
              "jim");
      user.setRoles(Arrays.asList(userRole));
      userRepository.save(user);

      user = new User("admin@admin.com", "admin", "Admin", "User", true, "admin");
      user.setRoles(Arrays.asList(adminRole));
      userRepository.save(user);

    };
  }}