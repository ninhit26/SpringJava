package com.example.SpringJava.Service;

import com.example.SpringJava.Model.Role;
import com.example.SpringJava.Model.UserModel;
import com.example.SpringJava.Repositories.RoleRepository;
import com.example.SpringJava.Repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository ;
    private final RoleRepository roleRepository ;

//    @Override
//    public UserModel loadUserByUsername(String username) throws UsernameNotFoundException {
//        UserModel userModel = userRepository.findByUsername(username);
//        if (userModel == null){
//            log.error("User not four the in database");
//            throw new UsernameNotFoundException("User not four the in database");
//        }else {
//            log.info("User found in the database {}" + username );
//        }
//        return userModel ;
//    }

    @Override
    public UserModel userSave(UserModel userModel) {
        log.info("Save to db ");
        return userRepository.save(userModel);
    }

    @Override
    public Role saveRole(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
        UserModel userModel = userRepository.findByUsername(username);
        Role role = roleRepository.findByName(roleName);
        userModel.getRoles().add(role);
    }

    @Override
    public UserModel getUser(String username) {
        log.info("Find user db ");
        return userRepository.findByUsername(username);
    }

    @Override
    public List<UserModel> getUsers() {
        log.info("Find all db ");
        return userRepository.findAll();
    }
}
