package org.group1.relational1.Core.Application.DTO.Profile;

import org.group1.relational1.Core.Domain.Entities.User;

public class CreateSingleProfileDto {
    private Integer level;
    private String imagePath;
    private String adress;
    private Integer age;
    private User userProfile;

    public CreateSingleProfileDto() {

    }

    public CreateSingleProfileDto(Integer level, String imagePath, String adress, Integer age) {
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
}
