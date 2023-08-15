package org.group1.entities;


import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.Period;

@Entity
@Table(name = "users")
public class User extends BaseEntity {
    @Id
    @SequenceGenerator(
            name = "user_id_sequence",
            sequenceName = "user_id_sequence",
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_id_sequence")
    private Long id;
    private String name = "";
    private LocalDate birthday;
    @Transient
    private Integer age;

    public User() {

    }

    public User(String name, LocalDate birthday, LocalDate createdDate) {
        this.name = name;
        this.birthday = birthday;
        this.createdDate = createdDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public Integer getAge() {
        return Period.between(this.birthday, LocalDate.now()).getYears();
    }

    public LocalDate getCreatedDate() {
        return this.createdDate;
    }

    public LocalDate getUpdatedDate() {
        return this.createdDate;
    }

    public LocalDate getDeletedDate() {
        return this.deletedDate;
    }

    public void setDeletedDate(LocalDate deletedDate) {
        this.deletedDate = deletedDate;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthday=" + birthday +
                ", age=" + age +
                ", createdDate=" + createdDate +
                ", updatedDate=" + updatedDate +
                ", deletedDate=" + deletedDate +
                '}';
    }

    public static UserBuilder buildStart() {
        return new UserBuilder();
    }

    public static class UserBuilder {
        private String name;
        private LocalDate birthday;
        private LocalDate createdDate;

        private UserBuilder() {

        }

        public UserBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public UserBuilder setBirthday(LocalDate birthday) {
            this.birthday = birthday;
            return this;
        }

        public UserBuilder setCreatedDate(LocalDate createdDate) {
            this.createdDate = createdDate;
            return this;
        }

        public User buildEnd() {
            return new User(name, birthday, createdDate);
        }
    }
}
