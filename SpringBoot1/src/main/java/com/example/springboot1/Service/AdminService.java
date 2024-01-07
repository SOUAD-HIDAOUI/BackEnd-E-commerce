package com.example.springboot1.Service;

import com.example.springboot1.Repository.AdminRepository;
import com.example.springboot1.model.Admin;
import com.example.springboot1.model.Client;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Optional;

@Service

public class AdminService   {
    public AdminService() {
    }

    @Autowired
    private AdminRepository adminRepository;

    public Optional<Admin> findByUsernameAndpassword(String username, String password) {
        return adminRepository.findByUsernameAndPassword(username, password);
    }


    public Admin addAdmin(Admin admin) {
        return adminRepository.saveAndFlush(admin);

    }

}

