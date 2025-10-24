package com.example.projetmpisi2.repository;

import com.example.projetmpisi2.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
