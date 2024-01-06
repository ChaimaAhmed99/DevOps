package com.example.bookstore.security.service;

import com.example.bookstore.security.entities.AppUser;

public interface IAccountService {

    public void addRole(String role);
    public void addUser(String username,String password,String mail);
    public void addroleToUser(String usename,String role);
    public AppUser loadUserByUserName(String username);
}
