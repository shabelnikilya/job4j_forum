package ru.job4j.forum.service;

import ru.job4j.forum.model.Post;
import ru.job4j.forum.model.User;
import ru.job4j.forum.repository.*;

import java.util.Collection;

@org.springframework.stereotype.Service
public class ForumService implements Service {
    private final PostDataRepository postStore;
    private final UserStore userStore;

    public ForumService(PostDataRepository postStore, UserRepository userStore) {
        this.postStore = postStore;
        this.userStore = userStore;
    }

    @Override
    public Collection<User> findAllUser() {
        return userStore.findAllUser();
    }

    @Override
    public void addUser(User user) {
        userStore.addUser(user);
    }

    @Override
    public Collection<Post> findAllPosts() {
        return (Collection<Post>) postStore.findAll();
    }

    @Override
    public void addPost(Post post) {
        postStore.save(post);
    }

    @Override
    public boolean containsUser(User user) {
        return userStore.containsUser(user);
    }

    @Override
    public Post findPostById(int id) {
        return postStore.findById(id).orElse(null);
    }
}
