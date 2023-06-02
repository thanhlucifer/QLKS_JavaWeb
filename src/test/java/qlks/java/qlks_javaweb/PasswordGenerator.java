package qlks.java.qlks_javaweb;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordGenerator {

    public static void main(String[] args) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String plainPassword = "admin";
        String encodedPassword = passwordEncoder.encode(plainPassword);

        System.out.println(encodedPassword);
    }

}