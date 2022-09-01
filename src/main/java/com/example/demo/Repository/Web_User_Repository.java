package com.example.demo.Repository;

import com.example.demo.Model.Web_User;

import javax.validation.constraints.NotNull;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Web_User_Repository extends JpaRepository<Web_User, Long> {
<<<<<<< HEAD
    Web_User findByEmail(String email);
=======

    boolean existsByEmail(@NotNull String email);

    Web_User findByEmail(@NotNull String email);
>>>>>>> ba9cec44773fbe2e560dac14d6324deabaf54aa4
}
