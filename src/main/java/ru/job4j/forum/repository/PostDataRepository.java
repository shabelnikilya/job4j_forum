package ru.job4j.forum.repository;

import org.springframework.data.repository.CrudRepository;
import ru.job4j.forum.model.Post;

public interface PostDataRepository extends CrudRepository<Post, Integer> {
}
