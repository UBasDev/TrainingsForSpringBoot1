package org.group1.relational1.Core.Domain.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "profiles")

public class Profile extends BaseEntity {
    private Integer level;
    private String imagePath;
    private String adress;
    private Integer age;
    @OneToOne
    @JoinColumn(name = "user_id", updatable = true, nullable = true, unique = true, insertable = true)
    @JsonIgnoreProperties(value = "profile")
    private User userProfile;

    public Profile() {
    }

    public Profile(Integer level, String imagePath, String adress, Integer age) {
        this.level = level;
        this.imagePath = imagePath;
        this.adress = adress;
        this.age = age;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public User getUserProfile() {
        return userProfile;
    }

    public void setUserProfile(User userProfile) {
        this.userProfile = userProfile;
    }

    public static ProfileBuilder ProfileBuilder() {
        return new ProfileBuilder();
    }

    public static class ProfileBuilder {
        private Integer level;
        private String imagePath;
        private String adress;
        private Integer age;

        public ProfileBuilder setLevel(Integer level) {
            this.level = level;
            return this;
        }

        public ProfileBuilder setImagePath(String imagePath) {
            this.imagePath = imagePath;
            return this;
        }

        public ProfileBuilder setAdress(String adress) {
            this.adress = adress;
            return this;
        }

        public ProfileBuilder setAge(Integer age) {
            this.age = age;
            return this;
        }

        public Profile buildEnd() {
            return new Profile(this.level, this.imagePath, this.adress, this.age);
        }
    }
}
