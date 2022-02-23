package ru.job4j.forum;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Key {
    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String pwd = encoder.encode("12345");
        System.out.println(pwd);
    }
}
