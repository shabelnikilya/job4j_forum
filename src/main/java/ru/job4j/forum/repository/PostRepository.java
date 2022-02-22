package ru.job4j.forum.repository;

import org.springframework.stereotype.Repository;
import ru.job4j.forum.model.Post;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class PostRepository implements PostStore {
    private final AtomicInteger postId = new AtomicInteger(2);
    private final Map<Integer, Post> posts = new ConcurrentHashMap<>();

    public PostRepository() {
        posts.put(1, new Post(1,
                        "Продажа",
                        "Продаю холодильник",
                List.of("За сколько продаешь?", "Готов завтра купить!")));
    }

    @Override
    public Collection<Post> findAllPosts() {
        return posts.values();
    }

    @Override
    public void addPost(Post post) {
        if (post.getId() == 0) {
            post.setId(postId.getAndIncrement());
        }
        posts.put(post.getId(), post);
    }

    @Override
    public Post findById(int id) {
        return posts.get(id);
    }
}
