package org.group1.relational1.Core.Application.Enums;

public enum FruitEnum {
    APPLE("red", 11),
    BANANA("yellow", 22),
    ORANGE("orange", 33);

    private String fruitColor;
    private Integer fruitPrice;

    FruitEnum(String color, Integer fruitPrice) {
        this.fruitColor = color;
        this.fruitPrice = fruitPrice;
    }

    public String getFruitColor() {
        return this.fruitColor;
    }

    public Integer getFruitPrice() {
        return this.fruitPrice;
    }
}
