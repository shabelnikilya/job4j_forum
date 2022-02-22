package ru.job4j.forum.service;

import ru.job4j.forum.model.Post;
import ru.job4j.forum.model.User;

import java.util.Collection;

public interface Service {

    Collection<User> findAllUser();

    void addUser(User user);

    Collection<Post> findAllPosts();

    void addPost(Post post);

    boolean containsUser(User user);

    Post findPostById(int id);
}
