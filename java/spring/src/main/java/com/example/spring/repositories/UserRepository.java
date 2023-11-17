package com.example.spring.repositories;

import com.example.spring.models.User;

public interface UserRepository extends SuperRepository<User> {
    User findByEmail(String email);
}
