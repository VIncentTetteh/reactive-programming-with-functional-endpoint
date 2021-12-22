package com.chrisbone.reactiveprogrammingfunctionalendpoint.controller;


import com.chrisbone.reactiveprogrammingfunctionalendpoint.dto.Student;
import com.chrisbone.reactiveprogrammingfunctionalendpoint.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;


@RestController
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping(value = "/studentstream",produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Student> studentStream(){
        return studentService.studentsStream();
    }
}
