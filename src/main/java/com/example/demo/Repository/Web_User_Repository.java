package com.example.demo.Repository;

import com.example.demo.Model.Web_User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Web_User_Repository extends JpaRepository<Web_User, Long> {
    Web_User findByEmail(String email);
}
