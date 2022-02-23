package ru.job4j.forum.model;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String username;
    private String password;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "authority_id")
    private Authority authority;

    private boolean enabled;

    public User() {
    }

    public User(String userName, String password) {
        this.username = userName;
        this.password = password;
    }

    public User(int id, String userName, String password) {
        this.id = id;
        this.username = userName;
        this.password = password;
    }

    public User(String userName, String password, Authority authority, boolean enabled) {
        this.username = userName;
        this.password = password;
        this.authority = authority;
        this.enabled = enabled;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Authority getAuthority() {
        return authority;
    }

    public void setAuthority(Authority authority) {
        this.authority = authority;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
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
