package com.chrisbone.reactiveprogrammingfunctionalendpoint.dao;

import com.chrisbone.reactiveprogrammingfunctionalendpoint.dto.Student;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

import java.time.Duration;

@Repository
public class StudentDao {

    public Flux<Student> allStudentsStream(){
        return Flux.range(1, 50)
                .delayElements(Duration.ofSeconds(1))
                .doOnNext(i -> System.out.println("Processing count in stream:" + i))
                .map(i -> new Student(i, "student" + i));
    }
    public Flux<Student> allStudents(){
        return Flux.range(1, 50)
                .doOnNext(i -> System.out.println("Processing count in stream:" + i))
                .map(i -> new Student(i, "student" + i));
    }
}
