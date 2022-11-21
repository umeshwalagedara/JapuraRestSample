package com.example.student.controller;

import com.example.student.controller.model.StudentDetails;
import java.util.HashMap;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/v1/api/student")
public class StudentController {

  final static Map<Integer, StudentDetails> dataMap = new HashMap<>();

  static {
    StudentDetails studentDetails = new StudentDetails();
    studentDetails.setId(1);
    studentDetails.setName("DefaultUser");
    studentDetails.setPassportNo("Default Passport");
    dataMap.put(studentDetails.getId(), studentDetails);

  }

//  @GetMapping("/{id}")
//  public ResponseEntity<StudentDetails> getStudentDetails(@PathVariable int id){
//
//    System.out.println(" ------- hit end point --------");
//    StudentDetails studentDetails = dataMap.get(id);
//    System.out.println(dataMap.size());
//    System.out.println(studentDetails);
//    return ResponseEntity.status(HttpStatus.OK).body(studentDetails);
//  }

  @GetMapping("/{id}")
  public StudentDetails getStudentDetails(@PathVariable int id){

    System.out.println(" ------- hit end point --------");
    StudentDetails studentDetails = dataMap.get(id);
    System.out.println(dataMap.size());
    System.out.println(studentDetails);

    return studentDetails;
  }


  @PostMapping("/")
  public ResponseEntity<StudentDetails> addStudentDetails(@RequestBody StudentDetails studentDetails){
    dataMap.put(studentDetails.getId(), studentDetails);
    return ResponseEntity.status(HttpStatus.OK).body(studentDetails);
  }





}
