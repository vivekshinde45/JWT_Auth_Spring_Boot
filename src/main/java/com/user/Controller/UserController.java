package com.user.Controller;

import com.user.model.User;
import com.user.services.implementation.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserService _userService;

    @PostMapping
    public ResponseEntity<User> register(@RequestBody User user){
        User savedUser = _userService.createUser(user);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<User> getById(@PathVariable Long userId){
        User user = _userService.getUserById(userId);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<User>> getAll(){
        List<User> users = _userService.getAll();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }
}
