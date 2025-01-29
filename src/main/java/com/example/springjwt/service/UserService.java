package com.example.springjwt.service;
<<<<<<< HEAD

import com.example.springjwt.domain.Role;
import com.example.springjwt.domain.User;

import java.util.List;
=======
>>>>>>> 70eddb99d489a91d9f0fbb52be4cc3f7554fbe46

public interface UserService {
    User saveUser(User user);
    Role saveRole(Role role);
    void addRoleToUser(String username, String roleName);
    User getUser(String username);
    List<User> getUsers();
}
