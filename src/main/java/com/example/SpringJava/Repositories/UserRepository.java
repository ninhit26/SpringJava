package com.example.SpringJava.Repositories;

import com.example.SpringJava.Model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<UserModel,Long> {

    UserModel findByUsername(String username);

}
