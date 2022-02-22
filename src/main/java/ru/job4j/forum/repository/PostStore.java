package ru.job4j.forum.repository;

import ru.job4j.forum.model.Post;

import java.util.Collection;

public interface PostStore {

    Collection<Post> findAllPosts();

    void addPost(Post post);

    Post findById(int id);
}
