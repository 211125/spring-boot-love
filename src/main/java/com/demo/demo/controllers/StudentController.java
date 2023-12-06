package com.demo.demo.controllers;

import com.demo.demo.dto.request.CreateStudentRequest;
import com.demo.demo.dto.request.UpdateStudentRequest;
import com.demo.demo.dto.response.StudentResponse;
import com.demo.demo.services.interfaces.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Student")
public class StudentController {

    @Autowired
    private IStudentService service;

    @GetMapping("{id}")
    public StudentResponse get(@PathVariable Long id) {
        return service.getStudent(id);
    }

    @GetMapping("listStudent")
    public List<StudentResponse> list() {
        return service.list();
    }


    @PostMapping
    public void create(@RequestBody CreateStudentRequest request) {
        service.create(request);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    @PutMapping("{id}")
    public StudentResponse update(@PathVariable Long id,
                                  @RequestBody UpdateStudentRequest request) {
        return service.update(request, id);
    }
}
