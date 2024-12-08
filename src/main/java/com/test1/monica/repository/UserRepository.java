package com.test1.monica.repository;

import com.test1.monica.bean.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository
        extends JpaRepository<User, Long> {
}
