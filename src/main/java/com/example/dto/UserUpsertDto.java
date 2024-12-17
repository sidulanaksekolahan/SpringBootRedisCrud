package com.example.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserUpsertDto {

    private String id;

    private String name;

    private int age;

    public UserUpsertDto(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
