package com.Genie.RedisDemo.Service;

import com.Genie.RedisDemo.Entity.User;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserService  {

    private final Map<Long, User> fakedb=new HashMap<>();


    public UserService(){
        User user1=new User(1L,"Akash","akash@gmail.com");
        User user2=new User(2L,"Raj","raj@gmail.com");
        User user3=new User(3L,"Aman","aman@gmail.com");
      fakedb.put(user1.getId(),user1);
      fakedb.put(user2.getId(),user2);
      fakedb.put(user3.getId(),user3);

    }

    @CachePut(value = "users",key = "#user.id")
    public User save(User user)
    {
        System.out.println("User saved in FakeDB...");
        System.out.println("user id "+user.getId());

        fakedb.put(user.getId(),user);
        return user;
    }

    @Cacheable(value = "users",key = "#id")
    public User getUser(Long id) {
        System.out.println("Getting data from fakeDB..");
        System.out.println("user id"+id);
        return fakedb.get(id);
    }

    public List<User>  getAllUser(){
        return new ArrayList<>(fakedb.values());
    }
}

