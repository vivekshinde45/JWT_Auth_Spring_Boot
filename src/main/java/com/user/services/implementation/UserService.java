package com.user.services.implementation;

import com.user.model.User;
import com.user.reporsitory.UserRepository;
import com.user.services.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserService {
    @Autowired
    private UserRepository _userRepository;

    @Autowired
    private PasswordEncoder _passwordEncoder;

    @Override
    public User createUser(User user) {
        user.setPassword(_passwordEncoder.encode(user.getPassword()));
        User savedUser = _userRepository.save(user);
        return savedUser;
    }

    @Override
    public User updateUser(Long userId, User user) {
        return null;
    }

    @Override
    public User getUserById(Long userId) {
        Optional<User> optionalUser = _userRepository.findById(userId);
        return optionalUser.isEmpty() ? null : optionalUser.get();
    }

    @Override
    public List<User> getAll() {
        return _userRepository.findAll();
    }
}
