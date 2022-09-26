package com.demo.demo.services.impl;

import com.demo.demo.entities.Student;
import com.demo.demo.dto.request.CreateStudentRequest;
import com.demo.demo.dto.request.UpdateStudentRequest;
import com.demo.demo.dto.response.StudentResponse;
import com.demo.demo.repositories.IStudentRepository;
import com.demo.demo.services.interfaces.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements IStudentService {

    @Autowired
    private IStudentRepository repository;

    @Override
    public StudentResponse getStudent(Long id) {
        Optional<Student> studentOptional = repository.findById(id);
        if (studentOptional.isPresent()) {
            Student student = studentOptional.get();
            StudentResponse from = this.from(student);
            return from;
        }
        throw new RuntimeException("not student");
    }

    @Override
    public void create(CreateStudentRequest request) {
        Student student = from(request);
        repository.save(student);
    }

    @Override
    public List<StudentResponse> list() {
        List<Student> students = repository.findAll();
        List<StudentResponse> studentRespons = from(students);
        return studentRespons;
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public StudentResponse update(UpdateStudentRequest request, Long id) {
        Optional<Student> optionalStudent = repository.findById(id);
        if (optionalStudent.isPresent()) {
            Student student = optionalStudent.get();
            Student updated = from(request, student);
            Student saved = repository.save(updated);
            StudentResponse response = from(saved);
            return response;
        }
        throw new RuntimeException("No esta carnal no se actualizó");
    }

    private Student from(UpdateStudentRequest request, Student student) {
        student.setName(request.getName());
        return student;
    }

    private List<StudentResponse> from(List<Student> users) {
        List<StudentResponse> studentRespons = new ArrayList<>();
        for (int i = 0; i < users.size(); i++) {
            Student user = users.get(i);
            StudentResponse response = from(user);
            studentRespons.add(response);
        }
        return studentRespons;
    }

    private Student from(CreateStudentRequest request) {
        Student student = new Student();
        student.setName(request.getName());
        return student;
    }

    private StudentResponse from(Student student) {
        StudentResponse response = new StudentResponse();
        response.setId(student.getId());
        response.setName(student.getName());
        return response;
    }
}
