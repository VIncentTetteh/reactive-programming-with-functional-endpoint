package com.chrisbone.reactiveprogrammingfunctionalendpoint.handle;

import com.chrisbone.reactiveprogrammingfunctionalendpoint.dao.StudentDao;
import com.chrisbone.reactiveprogrammingfunctionalendpoint.dto.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.management.monitor.MonitorNotification;

@Service
public class StudentHandle {
    @Autowired
    private StudentDao dao;

    public Mono<ServerResponse> loadStudents(ServerRequest request){
       Flux<Student> studentFlux =  dao.allStudents();
       return ServerResponse.ok().body(studentFlux,Student.class);
    }
}
