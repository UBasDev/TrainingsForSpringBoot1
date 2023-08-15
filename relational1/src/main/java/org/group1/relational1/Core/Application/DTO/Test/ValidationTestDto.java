package org.group1.relational1.Core.Application.DTO.Test;

import jakarta.validation.constraints.*;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ValidationTestDto {

    @Size(min = 1, max = 5, message = "Size invalid!")
    private String name;
    @Size(min = 1, max = 5, message = "Size invalid2!")
    private String lastname;

    private Integer age;

    private LocalDate birthDate;
    private double totalMoney;
    private boolean isActive;
    private BigDecimal weight;

    public ValidationTestDto() {

    }

    public ValidationTestDto(String name, Integer age, LocalDate birthDate, double totalMoney, boolean isActive, BigDecimal weight) {
        this.name = name;
        this.age = age;
        this.birthDate = birthDate;
        this.totalMoney = totalMoney;
        this.isActive = isActive;
        this.weight = weight;
    }

    public String getName() {
        return this.name;
    }

    public Integer getAge() {
        return this.age;
    }

    public LocalDate getBirthDate() {
        return this.birthDate;
    }

    public double getTotalMoney() {
        return this.totalMoney;
    }

    public boolean getIsActive() {
        return this.isActive;
    }

    public BigDecimal getWeight() {
        return this.weight;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public void setTotalMoney(double totalMoney) {
        this.totalMoney = totalMoney;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }
}
