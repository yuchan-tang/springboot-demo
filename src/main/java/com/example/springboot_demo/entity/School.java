package com.example.springboot_demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class School {
    private Integer id;
    private String name;
    private List<User> users;
}
