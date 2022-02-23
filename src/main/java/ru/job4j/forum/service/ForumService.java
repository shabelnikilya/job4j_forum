package ru.job4j.forum.service;

import ru.job4j.forum.model.Authority;
import ru.job4j.forum.model.Post;
import ru.job4j.forum.model.User;
import ru.job4j.forum.repository.*;

import java.util.Collection;

@org.springframework.stereotype.Service
public class ForumService implements Service {
    private final PostDataRepository postStore;
    private final UserDataRepository userStore;
    private final AuthorityRepository authorityRepository;

    public ForumService(PostDataRepository postStore, UserDataRepository userStore,
                        AuthorityRepository authorityRepository) {
        this.postStore = postStore;
        this.userStore = userStore;
        this.authorityRepository = authorityRepository;
    }

    @Override
    public Collection<User> findAllUser() {
        return (Collection<User>) userStore.findAll();
    }

    @Override
    public void addUser(User user) {
        userStore.save(user);
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
        return findByUsername(user.getUsername()) != null;
    }

    @Override
    public Post findPostById(int id) {
        return postStore.findById(id).orElse(null);
    }

    @Override
    public Authority findByAuthority(String authority) {
        return authorityRepository.findByAuthority(authority);
    }

    @Override
    public User findByUsername(String username) {
        return userStore.findByUsername(username);
    }
}
