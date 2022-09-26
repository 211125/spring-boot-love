package com.demo.demo.services.interfaces;

import com.demo.demo.dto.request.CreateStudentRequest;
import com.demo.demo.dto.request.UpdateStudentRequest;
import com.demo.demo.dto.response.StudentResponse;

import java.util.List;

public interface IStudentService {

    StudentResponse getStudent(Long id);

    void create(CreateStudentRequest request);

    List<StudentResponse> list();

    void delete(Long id);

    StudentResponse update(UpdateStudentRequest request, Long id);
}
