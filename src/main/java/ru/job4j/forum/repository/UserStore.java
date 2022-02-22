package ru.job4j.forum.repository;

import ru.job4j.forum.model.User;

import java.util.Collection;

public interface UserStore {
    Collection<User> findAllUser();

    void addUser(User user);

    boolean containsUser(User user);
}
