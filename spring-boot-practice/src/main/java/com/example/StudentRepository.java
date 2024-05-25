package com.example;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class StudentRepository {
    private final List<Student> studentList;

    public StudentRepository() {
        this.studentList = new ArrayList<>();
        studentList.add(new Student("Andrey", "A"));
        studentList.add(new Student("Stas", "B"));
        studentList.add(new Student("Rey", "A"));
        studentList.add(new Student("Cris", "B"));
        studentList.add(new Student("Sten", "C"));
    }
    public Student getById(Long id){
        return studentList.stream()
                .filter(student -> Objects.equals(student.getId(), id))
                .findFirst()
                .orElse(null);
    }
    public List<Student> getAll(){
        return List.copyOf(studentList);
    }
    public Student getByName(String name){
        return studentList.stream()
                .filter(student -> Objects.equals(student.getName(), name))
                .findFirst()
                .orElse(null);
    }

    public List<Student> getByGroup(String groupName){
        return studentList.stream()
                .filter(student -> Objects.equals(student.getGroupName(), groupName))
                .collect(Collectors.toList());
    }

    public void addStudent(Student student){
        studentList.add(student);
    }
    public void removeStudent(int id){
        studentList.remove(id-1);
    }
}
