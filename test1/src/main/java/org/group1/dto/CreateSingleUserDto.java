package org.group1.dto;

import java.time.LocalDate;

public class CreateSingleUserDto {
    private String name;
    private LocalDate birthday;

    public CreateSingleUserDto() {

    }

    public CreateSingleUserDto(String name, LocalDate birthday) {
        this.name = name;
        this.birthday = birthday;
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

    public static CreateSingleUserDtoBuilder buildStart() {
        return new CreateSingleUserDtoBuilder();
    }

    private static class CreateSingleUserDtoBuilder {
        private String name;
        private LocalDate birthday;

        public CreateSingleUserDtoBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public CreateSingleUserDtoBuilder setBirthday(LocalDate birthday) {
            this.birthday = birthday;
            return this;
        }

        public CreateSingleUserDto buildEnd() {
            return new CreateSingleUserDto(this.name, this.birthday);
        }
    }
}
