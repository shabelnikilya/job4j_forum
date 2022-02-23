package ru.job4j.forum.repository;

import org.springframework.stereotype.Repository;
import ru.job4j.forum.model.User;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class UserRepository implements UserStore {
    private final AtomicInteger usersId = new AtomicInteger(2);
    private final Map<Integer, User> users = new ConcurrentHashMap<>();

    public UserRepository() {
        users.put(1, new User(1, "one user", "1234"));
    }

    @Override
    public Collection<User> findAllUser() {
        return users.values();
    }

    @Override
    public void addUser(User user) {
        if (user.getId() == 0) {
            user.setId(usersId.getAndIncrement());
        }
        users.put(user.getId(), user);
    }

    @Override
    public boolean containsUser(User user) {
        return users.containsKey(user.getId());
    }
}
