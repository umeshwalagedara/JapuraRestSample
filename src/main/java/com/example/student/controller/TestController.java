package com.example.student.controller;

import com.example.student.controller.model.StudentDetails;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@CrossOrigin
@RequestMapping("/v1/api/test")
public class TestController {


  @GetMapping("/")
  public  StudentDetails getTestData(){
    String url = "http://localhost:8084/v1/api/student/1";
    RestTemplate restTemplate = new RestTemplate();

    ResponseEntity<StudentDetails> responseEntity = restTemplate.getForEntity(url, StudentDetails.class);

    StudentDetails studentDetails =  responseEntity.getBody();
    System.out.println(" ------------------ ");
    System.out.println(studentDetails.getId());
    System.out.println(studentDetails.getName());
    System.out.println(studentDetails.getPassportNo());

    return studentDetails;
  }

}
