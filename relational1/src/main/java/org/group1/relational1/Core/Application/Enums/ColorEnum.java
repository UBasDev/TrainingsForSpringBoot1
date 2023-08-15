package org.group1.relational1.Core.Application.Enums;

public enum ColorEnum {
    RED("#ff0000"),
    GREEN("#00ff00"),
    BLUE("#0000ff");
    private String hexCode;

    ColorEnum(String hexCode) {
        this.hexCode = hexCode;
    }

    public String getHexCode() {
        return hexCode;
    }
}
