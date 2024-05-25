package com.example;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class StudentController {
    private final StudentRepository repo;
//    @Autowired
//    public StudentController(StudentRepository repo) {
//        this.repo = repo;
//    }
    @GetMapping("/student/{id}")
    public Student getStudentById(@PathVariable Long id){
        return repo.getById(id);
    }
    @GetMapping("/students")
    public List<Student> getAll(){
        return repo.getAll();
    }
    @GetMapping("/search")
    public Student getStudentByName(@RequestParam String name){
        return repo.getByName(name);
    }
    @GetMapping("/student/group/{groupName}")
    public List<Student> getStudentByGroup(@PathVariable String groupName){
        return repo.getByGroup(groupName);
    }
    @PostMapping("/student")
    public Student addStudent(@RequestBody Student student){
        repo.addStudent(student);
        return student;
    }
    @DeleteMapping("/student/{id}")
    public void removeStudent(@PathVariable int id){
        repo.removeStudent(id);
    }
}
