package org.group1.relational1.Core.Application.DTO.Screen;

public class CreateSingleScreenDto {
    private String name;
    private String value;
    private Integer orderValue;

    public CreateSingleScreenDto() {

    }

    public CreateSingleScreenDto(String name, String value, Integer orderValue) {
        this.name = name;
        this.value = value;
        this.orderValue = orderValue;
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
}
