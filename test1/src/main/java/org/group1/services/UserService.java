package org.group1.services;

import org.group1.dto.CreateSingleUserDto;
import org.group1.entities.User;

import org.group1.exceptions.CustomUserException;
import org.group1.interfaces.IUserService;
import org.group1.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return this.userRepository.findAll();
    }

    public Optional<User> getSingleUserById(Long userId) {
        return this.userRepository.findById(userId);
    }

    public boolean createSingleUser(CreateSingleUserDto requestBody) {
        var createdUser = this.userRepository.save(User.buildStart().setName(requestBody.getName()).setBirthday(requestBody.getBirthday()).buildEnd());
        return createdUser != null;
    }

    public User getSingleUserByName(String userName) {
        try {

            var userFound = this.userRepository.findFirstByNameContaining(userName);
            if (userFound != null) return userFound;
            throw new CustomUserException("Could not find user with this name: " + userName, HttpStatus.BAD_REQUEST);
        } catch (CustomUserException ex) {
            throw ex;
        } catch (Exception ex) {
            throw new CustomUserException(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
