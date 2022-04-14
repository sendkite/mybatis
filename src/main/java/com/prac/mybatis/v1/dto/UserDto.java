package com.prac.mybatis.v1.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@Getter
@NoArgsConstructor
public class UserDto {

    private Long userId;

    private String name;

    private int age;

}