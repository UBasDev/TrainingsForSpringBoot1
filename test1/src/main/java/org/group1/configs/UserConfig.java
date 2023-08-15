package org.group1.configs;

import org.group1.entities.User;
import org.group1.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;

@Configuration
public class UserConfig {
    @Bean
    CommandLineRunner commandLineRunner(UserRepository userRepository) {
        return args -> {
            var newStudentsSeed = new ArrayList<User>();
            newStudentsSeed.add(User.buildStart().setName("ahmet1").setBirthday(LocalDate.of(1996, Month.AUGUST, 3)).buildEnd());
            newStudentsSeed.add(User.buildStart().setName("ahmet2").setBirthday(LocalDate.of(1997, Month.AUGUST, 3)).buildEnd());
            newStudentsSeed.add(User.buildStart().setName("ahmet3").setBirthday(LocalDate.of(1998, Month.AUGUST, 3)).buildEnd());
            newStudentsSeed.add(User.buildStart().setName("ahmet4").setBirthday(LocalDate.of(1999, Month.AUGUST, 3)).buildEnd());
            newStudentsSeed.add(User.buildStart().setName("ahmet5").setBirthday(LocalDate.of(2000, Month.AUGUST, 3)).buildEnd());
            userRepository.saveAll(newStudentsSeed);
        };
    }
}
