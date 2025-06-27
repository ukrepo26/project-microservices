package com.Genie.RedisDemo.Controller;

import com.Genie.RedisDemo.Entity.User;
import com.Genie.RedisDemo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
ResponseEntity<User>  save(@RequestBody User user)
{
    return ResponseEntity.ok(userService.save(user));
}

@GetMapping("/{id}")
public ResponseEntity<User>  get(@PathVariable Long id)
{
    User user=userService.getUser(id);
    return user!= null ? ResponseEntity.ok(user) : ResponseEntity.notFound().build();
}



@GetMapping
public List<User>  getAllUser()
{
    return userService.getAllUser();
}

}
