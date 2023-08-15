package org.group1.controllers;

import org.group1.dto.CreateSingleUserDto;
import org.group1.entities.User;
import org.group1.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;

@RestController()
@RequestMapping(path = "users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(path = "get-all-users")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping(path = "get-single-user-by-id")
    public Optional<User> getSingleUserById(@RequestParam("userId") Long userId) {
        return userService.getSingleUserById(userId);
    }

    @PostMapping(path = "create-single-user")
    public boolean createSingleUser(@RequestBody CreateSingleUserDto requestBody) {
        return userService.createSingleUser(requestBody);
    }

    @GetMapping(path = "get-single-user-by-name")
    public User getSingleUserByName(@RequestParam String userName) {
        return userService.getSingleUserByName(userName);
    }

    @GetMapping(path = "test1")
    public ResponseEntity test1() {
        var x = LocalDateTime.now();
        var x1 = x.get(ChronoField.DAY_OF_MONTH);
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }
}
