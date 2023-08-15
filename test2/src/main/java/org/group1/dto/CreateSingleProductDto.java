package org.group1.dto;

import java.time.LocalDate;

public class CreateSingleProductDto {
    private String name = "";
    private Integer price;

    public CreateSingleProductDto() {

    }

    public CreateSingleProductDto(String name, Integer price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public static CreateSingleProductDtoBuilder buildStart() {
        return new CreateSingleProductDtoBuilder();
    }

    private static class CreateSingleProductDtoBuilder {
        private String name;
        private Integer price;

        public CreateSingleProductDtoBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public CreateSingleProductDtoBuilder setBirthday(Integer price) {
            this.price = price;
            return this;
        }

        public CreateSingleProductDto buildEnd() {
            return new CreateSingleProductDto(this.name, this.price);
        }
    }
}
