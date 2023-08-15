package org.group1.relational1.Core.Application.DTO.Role;

public class CreateSingleRoleDto {
    private String name;
    private String value;
    private Integer code;

    public CreateSingleRoleDto() {

    }

    public CreateSingleRoleDto(String name, String value, Integer code) {

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

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
