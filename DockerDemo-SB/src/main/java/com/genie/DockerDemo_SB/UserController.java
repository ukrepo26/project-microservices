package com.genie.DockerDemo_SB;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
private UserRepo userRepo;

    @PostMapping
public User addUser(@RequestBody User user)
{
    return userRepo.save(user);
}

@GetMapping
public List<User> getAllUser()
{
    return userRepo.findAll();
}
}
