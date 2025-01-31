package me.rudnikov.backend.controller;

import me.rudnikov.backend.dto.create.StudentCreateDto;
import me.rudnikov.backend.dto.read.StudentDto;
import me.rudnikov.backend.dto.update.StudentUpdateDto;
import me.rudnikov.backend.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import lombok.AllArgsConstructor;

import java.util.List;

@RestController
@RequestMapping(
        value = "/api/v1/students"
)
@AllArgsConstructor
public class StudentController {
    private final StudentService studentService;

    // Create student (HTTP::POST)
    @RequestMapping(
            value = "",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Long> createStudent(@RequestBody StudentCreateDto dto) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(studentService.createStudent(dto));
    }

    // Read student by id (HTTP::GET)
    @RequestMapping(
            value = "{id}",
            method = RequestMethod.GET,
            consumes = MediaType.ALL_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<StudentDto> readStudentById(@PathVariable("id") Long id) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(studentService.readStudentById(id));
    }

    // Read all students (HTTP::GET)
    @RequestMapping(
            value = "",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<List<StudentDto>> readAllStudents() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(studentService.readAllStudents());
    }

    // Read all students by fullName (HTTP::GET)
    @RequestMapping(
            value = "",
            method = RequestMethod.GET,
            consumes = MediaType.ALL_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<List<StudentDto>> readAllStudentsByFullName(@RequestParam("fullName") String fullName) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(studentService.readAllStudentsByFullName(fullName));
    }

    // Read all students by average performance (HTTP::GET)
    @RequestMapping(
            value = "/",
            method = RequestMethod.GET,
            consumes = MediaType.ALL_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<List<StudentDto>> readAllStudentsByAveragePerformance(@RequestParam("avgPerformance") Float avgPerformance) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(studentService.readAllStudentsByAvgPerformance(avgPerformance));
    }

    // Update student by id (HTTP::PUT)
    @RequestMapping(
            value = "{id}",
            method = RequestMethod.PUT,
            consumes = MediaType.ALL_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Boolean> updateStudentById(
            @PathVariable("id") Long id,
            @RequestBody StudentUpdateDto dto
    ) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(studentService.updateStudentById(id, dto));
    }

    // Delete student by id (HTTP::DELETE)
    @RequestMapping(
            value = "{id}",
            method = RequestMethod.DELETE,
            consumes = MediaType.ALL_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Boolean> deleteStudentById(@PathVariable("id") Long id) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(studentService.deleteStudentById(id));
    }
}