package com.user.services.interfaces;

import com.user.model.User;

import java.util.List;

public interface IUserService {
    User createUser(User user);
    User updateUser(Long userId, User user);
    User getUserById(Long userId);

    List<User> getAll();
}
