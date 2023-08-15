package org.group1.relational1.Core.Domain.Entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "screens")

public class Screen extends BaseEntity {
    private String name;
    private String value;
    private Integer orderValue;
    @ManyToMany(cascade = CascadeType.ALL, targetEntity = User.class, fetch = FetchType.LAZY)
    @JoinTable(
            name = "user_screen",
            joinColumns = @JoinColumn(name = "screen_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    @JsonIgnoreProperties(value = "screensOfUser", ignoreUnknown = false)

    private Set<User> usersOfScreen = new HashSet<>();

    public Screen() {
    }

    public Screen(String name, String value, Integer orderValue, Set<User> usersOfScreen) {
        this.name = name;
        this.value = value;
        this.orderValue = orderValue;
        this.usersOfScreen.addAll(usersOfScreen);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Integer getOrderValue() {
        return orderValue;
    }

    public void setOrderValue(Integer orderValue) {
        this.orderValue = orderValue;
    }

    public Set<User> getUsersOfScreen() {
        return usersOfScreen;
    }

    public void setUsersOfScreen(Set<User> usersOfScreen) {
        this.usersOfScreen = usersOfScreen;
    }

    public void addUserOfScreen(User userOfScreen) {
        this.usersOfScreen.add(userOfScreen);
    }

    public void removeUserOfScreen(User userOfScreen) {
        this.usersOfScreen.remove(userOfScreen);
    }

    public static ScreenBuilder buildStart() {
        return new ScreenBuilder();
    }

    public static class ScreenBuilder {
        private String name;
        private String value;
        private Integer orderValue;

        private Set<User> usersOfScreen = new HashSet<>();

        public ScreenBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public ScreenBuilder setValue(String value) {
            this.value = value;
            return this;
        }

        public ScreenBuilder setOrderValue(Integer orderValue) {
            this.orderValue = orderValue;
            return this;
        }

        public ScreenBuilder setUsersOfScreen(Set<User> users) {
            this.usersOfScreen.addAll(users);
            return this;
        }

        public Screen buildEnd() {
            return new Screen(this.name, this.value, this.orderValue, this.usersOfScreen);
        }
    }
}
