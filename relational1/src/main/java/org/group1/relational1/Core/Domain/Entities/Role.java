package org.group1.relational1.Core.Domain.Entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "roles")

public class Role extends BaseEntity {
    private String name;
    private String value;
    private Integer code;
    @OneToMany(mappedBy = "userRole", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JsonIgnoreProperties(value = "userRole")
    private Set<User> users = new HashSet<>();

    public Role() {
    }

    public Role(String name, String value, Integer code) {
        this.name = name;
        this.value = value;
        this.code = code;
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

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void addUser(User user) {
        this.users.add(user);
    }

    public static RoleBuilder buildStart() {
        return new RoleBuilder();
    }

    public static class RoleBuilder {
        private String name;
        private String value;
        private Integer code;

        public RoleBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public RoleBuilder setValue(String value) {
            this.value = value;
            return this;
        }

        public RoleBuilder setCode(Integer code) {
            this.code = code;
            return this;
        }

        public Role buildEnd() {
            return new Role(this.name, this.value, this.code);
        }
    }
}
