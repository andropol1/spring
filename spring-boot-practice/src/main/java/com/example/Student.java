package com.example;

import lombok.Data;

@Data
public class Student {
    private static Long idCounter = 1L;
    private final Long id;
    private final String name;
    private String groupName;
    public Student(String name, String groupName) {
        this.id = idCounter++;
        this.name = name;
        this.groupName = groupName;
    }
}
