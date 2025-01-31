package me.rudnikov.backend.service;

import me.rudnikov.backend.dto.create.StudentCreateDto;
import me.rudnikov.backend.dto.read.StudentDto;
import me.rudnikov.backend.dto.update.StudentUpdateDto;

import java.util.List;

public interface StudentService {
    Long createStudent(StudentCreateDto dto);
    StudentDto readStudentById(Long id);
    List<StudentDto> readAllStudents();
    List<StudentDto> readAllStudentsByFullName(String fullName);
    List<StudentDto> readAllStudentsByAvgPerformance(Float averagePerformance);
    Boolean updateStudentById(Long id, StudentUpdateDto dto);
    Boolean deleteStudentById(Long id);
}