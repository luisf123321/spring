package com.example.obspringsecuritycrifrado;

import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class EncriptionTest {

    @Test
    void bcryptTest(){

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String result = passwordEncoder.encode("admin");
        System.out.println(result);
        Boolean flag = passwordEncoder.matches("admin",result);
        System.out.println(flag);

    }
}
