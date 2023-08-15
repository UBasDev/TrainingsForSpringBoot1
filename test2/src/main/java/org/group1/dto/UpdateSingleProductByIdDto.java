package org.group1.dto;

public class UpdateSingleProductByIdDto {
    private String name;
    private Integer price;

    public UpdateSingleProductByIdDto() {
    }

    public UpdateSingleProductByIdDto(String name, Integer price) {
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
}
