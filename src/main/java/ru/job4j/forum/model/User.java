package ru.job4j.forum.model;

import java.util.List;
import java.util.Objects;

public class User {
    private int id;
    private String userName;
    private String password;
    private List<Post> posts;

    public User() {
    }

    public User(String userName, String password, List<Post> posts) {
        this.userName = userName;
        this.password = password;
        this.posts = posts;
    }

    public User(int id, String userName, String password, List<Post> posts) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.posts = posts;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return id == user.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
