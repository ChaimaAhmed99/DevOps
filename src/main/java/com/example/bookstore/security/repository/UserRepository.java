package com.example.bookstore.security.repository;

import com.example.bookstore.security.entities.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<AppUser,String> {

    public  AppUser findAppUserByUsername(String userName);
}
