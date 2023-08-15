package org.group1.relational1.Core.Domain.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")

public class User extends BaseEntity {
    private String firstname;
    private String lastname;
    private String email;
    private String phone;
    @ManyToMany(mappedBy = "usersOfScreen", cascade = CascadeType.ALL, targetEntity = Screen.class, fetch = FetchType.LAZY)
    @JsonIgnoreProperties(value = "usersOfScreen", ignoreUnknown = false)
    private Set<Screen> screensOfUser = new HashSet<>();
    @OneToOne(mappedBy = "userProfile", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JsonIgnoreProperties(value = "userProfile")
    private Profile profile;
    @ManyToOne
    @JoinColumn(name = "role_id")
    @JsonIgnoreProperties(value = "users")
    private Role userRole;

    public User() {

    }

    public User(Long id, String firstname, String lastname, String email, String phone) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.phone = phone;
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Set<Screen> getScreensOfUser() {
        return this.screensOfUser;
    }

    public void setScreensOfUser(Set<Screen> screensOfUser) {
        this.screensOfUser = screensOfUser;
        for (Screen currentScreen : screensOfUser) {
            currentScreen.addUserOfScreen(this);
        }
    }

    public void addScreenOfUser(Screen screenOfUser) {
        this.screensOfUser.add(screenOfUser);
        screenOfUser.addUserOfScreen(this);
    }

    public void setUserRole(Role role) {
        this.userRole = role;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public void removeScreenOfUser(Screen screenOfUser) {
        this.screensOfUser.remove(screenOfUser);
        screenOfUser.removeUserOfScreen(this);
    }

    public Profile getProfile() {
        return this.profile;
    }


    public Role getUserRole() {
        return this.userRole;
    }

    public void addUserRole(Role userRole) {
        this.userRole = userRole;
        userRole.addUser(this);
    }

    public static UserBuilder buildStart() {
        return new UserBuilder();
    }

    public static class UserBuilder {
        private Long id;
        private String firstname;
        private String lastname;
        private String email;
        private String phone;

        public UserBuilder setId(Long id) {
            this.id = id;
            return this;
        }

        public UserBuilder setFirstname(String firstname) {
            this.firstname = firstname;
            return this;
        }

        public UserBuilder setLastname(String lastname) {
            this.lastname = lastname;
            return this;
        }

        public UserBuilder setEmail(String email) {
            this.email = email;
            return this;
        }

        public UserBuilder setPhone(String phone) {
            this.phone = phone;
            return this;
        }


        public User buildEnd() {
            return new User(this.id, this.firstname, this.lastname, this.email, this.phone);
        }
    }
}
