package com.example.SpringJava.Service;


import com.example.SpringJava.Model.Role;
import com.example.SpringJava.Model.UserModel;

import java.util.List;


public interface UserService {
    UserModel userSave(UserModel userModel);
    Role saveRole(Role role);
    void addRoleToUser(String username , String roleName);

    UserModel getUser(String username);

    List<UserModel> getUsers();
}
