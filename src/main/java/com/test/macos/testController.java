package com.test.macos;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.List;


@RestController
@CrossOrigin("http://127.0.0.1:5500/") // you need to chege about that in the production
public class testController {

    /*
    {
    "source": "Internal DB",
    "type": "internal",
    "lastSync": "2025-06-12T12:10:00Z",
    "status": "warning",
    "recordsFetched": 350,
    "failures": 15,
    "logs": [
      "350 records fetched",
      "15 failed due to schema mismatch"
    ]
  }
     */

    private List<Test> test_object ;

    @Autowired
    private ApiService  service;

    @GetMapping("/test")
    public Test getMethodName() {
        Test  test =  new Test();
        test.setSource("Internal DB");
        test.setType("Internal DB");
        test.setLast_sync(LocalDateTime.now());
        test.setStatus("warning");
        test.setFailures(15);
        test.setFailures(15);
        test.setLogs(List.of("350 records fetched",
                "15 failed due to schema mismatch"));

        System.out.println("The  Time  hey  are  Pinted  here  "+LocalDateTime.now() + "  "  + test.toString());
        return  test;

    }

    @GetMapping("/health/{serviceName}")
    public Test getHealthStatus(@PathVariable String serviceName) {
       return service.init(serviceName);
    }



}
