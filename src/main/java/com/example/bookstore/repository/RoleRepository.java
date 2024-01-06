package com.example.bookstore.repository;


import com.example.bookstore.security.entities.AppRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<AppRole,String > {
}
