package org.donate.service.user;

import org.donate.dao.RoleRepo;
import org.donate.dao.UserRepo;
import org.donate.entity.Role;
import org.donate.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service @Transactional
public class UserServiceImpl implements  UserService, UserDetailsService {

    @Autowired
    private UserRepo userRepo;
    @Autowired
    private RoleRepo roleRepo;
    @Autowired
    private  PasswordEncoder passwordEncoder;



    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user=userRepo.findByUsername(username);

        Collection<SimpleGrantedAuthority> authorities=new ArrayList<>();

        user.getRoles().forEach(role -> {
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        });

        return new org.springframework.security.core.userdetails.User(user.getUsername(),user.getPassword(),authorities);

    }
    @Override
    public User saveUser(User user) {
       // log.info("Saving new user {} to the database",user.getName());
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepo.save(user);
    }

    @Override
    public Role saveRole(Role role) {
       // log.info("Saving new role {} to the database",role.getName());
        return roleRepo.save(role);
    }

    @Override
    public void addRoleToUser(String userName, String roleName) {
      //  log.info("Adding role {} to user {}",roleName,userName);
        User user=userRepo.findByUsername(userName);
        Role role=roleRepo.findByName(roleName);
        user.getRoles().add(role);

    }

    @Override
    public User getUser(String userName) {
      //  log.info("Fetching user {}",userName);
        return userRepo.findByUsername(userName);
    }

    @Override
    public List<User> getUsers() {
        //log.info("Fetching all users");
        return userRepo.findAll();
    }

}
