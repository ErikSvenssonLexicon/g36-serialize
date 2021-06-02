package org.example.model;

import java.io.Serializable;
import java.util.Objects;

public class AppUser implements Serializable {
    private int id;
    private String username;
    private String password;
    private boolean active;
    private String role;

    public AppUser(int id, String username, String password, boolean active, String role) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.active = active;
        this.role = role;
    }

    //Serializable objects need to have a default constructor by contract
    public AppUser() {
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

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AppUser appUser = (AppUser) o;
        return getId() == appUser.getId() && isActive() == appUser.isActive() && Objects.equals(getUsername(), appUser.getUsername()) && Objects.equals(getRole(), appUser.getRole());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getUsername(), isActive(), getRole());
    }

    @Override
    public String toString() {
        return "AppUser{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", active=" + active +
                ", role='" + role + '\'' +
                '}';
    }
}
