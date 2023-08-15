package org.group1.interfaces;

import org.group1.dto.CreateSingleUserDto;
import org.group1.entities.User;

import java.util.List;
import java.util.Optional;

public interface IUserService {
    public List<User> getAllUsers();

    public Optional<User> getSingleUserById(int userId);

    public boolean createSingleUser(CreateSingleUserDto requestBody);

    public User getSingleUserByName(String userName);
}
