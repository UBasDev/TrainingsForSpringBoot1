package org.group1.relational1.Presentation.Controllers;

import jakarta.annotation.Resource;
import jakarta.persistence.EntityManagerFactory;
import org.group1.relational1.Core.Application.Abstractions.Configs.DataSource.IDataSourceConfig;
import org.group1.relational1.Core.Application.Abstractions.Repositories.ProfileRepository;
import org.group1.relational1.Core.Application.Abstractions.Repositories.RoleRepository;
import org.group1.relational1.Core.Application.Abstractions.Repositories.ScreenRepository;
import org.group1.relational1.Core.Application.Abstractions.Repositories.UserRepository;
import org.group1.relational1.Core.Application.Configs.TestConfig;
import org.group1.relational1.Core.Application.DTO.User.CreateSingleUserDto;
import org.group1.relational1.Core.Application.DTO.User.UpdateSingleUserDto;
import org.group1.relational1.Core.Domain.Entities.Role;
import org.group1.relational1.Core.Domain.Entities.Screen;
import org.group1.relational1.Core.Domain.Entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.*;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "users")
public class UserController {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final ScreenRepository screenRepository;
    private final ProfileRepository profileRepository;
    private final EntityManagerFactory emf;
    @Value("${application.environment}")
    private String environment1;
    @Autowired
    private Environment env;

    @Value("${spring.profiles.active:}")
    private String activeProfile;
    @Autowired
    private TestConfig testConfig;

    @Autowired
    public UserController(UserRepository userRepository, RoleRepository roleRepository, ScreenRepository screenRepository, EntityManagerFactory emf, ProfileRepository profileRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.screenRepository = screenRepository;
        this.profileRepository = profileRepository;
        this.emf = emf;

    }

    @GetMapping(path = "create-single-user")
    public void createSingleUser() {
        var createSingleUserDto = new CreateSingleUserDto("ugur5", "ugur5", "ugur5@gmail.com", "1234567");
        var em = this.emf.createEntityManager();
        var roleToAdd = this.roleRepository.findById((long) 1);
        var profileToAdd = this.profileRepository.findById((long) 2);
        var screensToAdd = this.screenRepository.findAll();
        if (roleToAdd.isEmpty()) throw new IllegalStateException("");
        var userToCreate = User.buildStart().setFirstname(createSingleUserDto.getFirstname()).setLastname(createSingleUserDto.getLastname()).setEmail(createSingleUserDto.getEmail()).setPhone(createSingleUserDto.getPhone()).buildEnd();
        userToCreate.addUserRole(roleToAdd.get());
        userToCreate.setProfile(profileToAdd.get());
        for (Screen currentScreen : screensToAdd) {
            userToCreate.addScreenOfUser(currentScreen);
        }
        this.userRepository.save(userToCreate);
        em.close();
    }

    @GetMapping(path = "update-single-user-by-id")
    public void updateSingleUserById() {
        var updateSingleUserDto = new UpdateSingleUserDto((long) 17, "ugur444444", "ugur44", "ugur4@gmail.com", "1234567");
        var roleToAssign = this.roleRepository.findById((long) 2);
        var foundUser = this.userRepository.findById(updateSingleUserDto.getId());
        if (foundUser.isEmpty()) throw new IllegalStateException("User not found");
        var getFoundUser = foundUser.get();
        getFoundUser.setFirstname(updateSingleUserDto.getFirstname());
        getFoundUser.setLastname(updateSingleUserDto.getLastname());
        getFoundUser.setPhone(updateSingleUserDto.getPhone());
        getFoundUser.setEmail(updateSingleUserDto.getEmail());
        getFoundUser.setProfile(getFoundUser.getProfile());
        getFoundUser.setUserRole(roleToAssign.get());
        var screensOfCurrentUser = getFoundUser.getScreensOfUser();
        for (Screen currentScreen : screensOfCurrentUser) {
            if (currentScreen.getId().equals((long) 3)) {
                getFoundUser.removeScreenOfUser(currentScreen);
                break;
            }
        }
        var screenToAssign = this.screenRepository.findById((long) 5);
        getFoundUser.addScreenOfUser(screenToAssign.get());
        this.userRepository.save(getFoundUser);
    }

    @GetMapping(path = "create-single-user2")
    public void createSingleUser2() {
        var createSingleUserDto = new CreateSingleUserDto("ugur5", "ugur5", "ugur5@gmail.com", "1234567");
        var em = this.emf.createEntityManager();
        var newTransaction = em.getTransaction();
        try {
            newTransaction.begin();
            var roleToAdd = this.roleRepository.findById((long) 1);
            var screensToAdd = this.screenRepository.findAll();
            if (roleToAdd.isEmpty()) throw new IllegalStateException("");
            var userToCreate = User.buildStart().setFirstname(createSingleUserDto.getFirstname()).setLastname(createSingleUserDto.getLastname()).setEmail(createSingleUserDto.getEmail()).setPhone(createSingleUserDto.getPhone()).buildEnd();
            userToCreate.addUserRole(roleToAdd.get());
            userToCreate.setScreensOfUser(new HashSet<>(screensToAdd));
            var mergedUserToCreate = em.merge(userToCreate);
            em.persist(mergedUserToCreate);
            newTransaction.commit();
        } catch (Exception ex) {
            newTransaction.rollback();
        } finally {
            em.close();
        }
    }

    @GetMapping("get-single-user-by-id")
    public User getSingleUserById(@RequestParam String userId) {
        return this.userRepository.findById(Long.parseLong(userId)).get();
    }

    public static class SortByUserId implements Comparator<User> {
        // Used for sorting in ascending order of
        // roll number
        public int compare(User a, User b) {
            return a.getId().intValue() - b.getId().intValue();
        }
    }

    public class Test1 {
        public String prop1;
        public String prop2;
    }

    @GetMapping(path = "test1")
    public ResponseEntity test1() {
        var response = new Test1();
        response.prop1 = this.env.getProperty("test1.environment1");
        var x1 = this.env.getActiveProfiles();
        var x2 = this.env.getDefaultProfiles();
        var x3 = this.activeProfile;

        response.prop2 = this.environment1;
        this.testConfig.serviceDevelopment1();
        this.testConfig.serviceProduction1();
        return ResponseEntity.status(200).body(response);
    }

    @GetMapping(path = "test2")
    public ResponseEntity test2() {

        return ResponseEntity.status(200).body(null);
    }
}
