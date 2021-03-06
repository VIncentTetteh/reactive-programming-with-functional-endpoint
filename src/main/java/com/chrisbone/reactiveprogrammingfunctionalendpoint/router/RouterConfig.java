package com.chrisbone.reactiveprogrammingfunctionalendpoint.router;

import com.chrisbone.reactiveprogrammingfunctionalendpoint.handle.StudentHandle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class RouterConfig {
    @Autowired
    private StudentHandle studentHandle;

    @Bean
    public RouterFunction<ServerResponse> routerFunction(){
        return RouterFunctions.route()
                .GET("/router/students",studentHandle::loadStudents)
                .build();
    }
}
