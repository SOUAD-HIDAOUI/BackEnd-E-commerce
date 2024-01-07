package com.example.springboot1.Repository;

import com.example.springboot1.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository

public interface AdminRepository extends JpaRepository<Admin, Long> {
    Optional<Admin> findByUsernameAndPassword(String username,String password);
    boolean findAdminByUsernameAndPassword(String username,String password);
    Admin findAdminByUsername(String username);

}
