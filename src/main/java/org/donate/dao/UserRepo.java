package org.donate.dao;

import org.donate.entity.ItemCategory;
import org.donate.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Long> {
    User findByUsername(String username);

}
