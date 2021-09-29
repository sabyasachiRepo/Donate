package org.donate.service.user;

import org.donate.entity.Role;
import org.donate.entity.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);
    Role saveRole(Role role);
    void addRoleToUser(String userName,String roleName);
    User getUser(String userName);
    List<User> getUsers();

}

