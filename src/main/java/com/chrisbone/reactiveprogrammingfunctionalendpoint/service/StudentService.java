package com.chrisbone.reactiveprogrammingfunctionalendpoint.service;

import com.chrisbone.reactiveprogrammingfunctionalendpoint.dao.StudentDao;
import com.chrisbone.reactiveprogrammingfunctionalendpoint.dto.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;


@Service
public class StudentService {
    @Autowired
    private StudentDao dao;

    public Flux<Student> studentsStream(){
        long startTime = System.currentTimeMillis();
        Flux<Student> student = dao.allStudentsStream();
        long endTime = System.currentTimeMillis();
        System.out.println("execution time is " + (endTime - startTime));
        return student;
    }


}
