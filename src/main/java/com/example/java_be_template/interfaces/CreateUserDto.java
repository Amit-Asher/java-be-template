package com.example.java_be_template.interfaces;

public class CreateUserDto {

    public String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CreateUserDto(String name) {
        this.name = name;
    }

    public CreateUserDto() {}
}
