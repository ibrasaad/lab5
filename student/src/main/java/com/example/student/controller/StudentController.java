package com.example.student.controller;

import com.example.student.apiresponse.ApiResponse;
import com.example.student.moudle.Student;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/students")
public class StudentController {
    ArrayList<Student> studentsarr = new ArrayList<>();

@GetMapping("/getstudents")
    public ArrayList<Student> getstudents(){
        return studentsarr;
    }
    @PostMapping("/addstudent")
    public ApiResponse addStudent(@RequestBody Student student){
            studentsarr.add(student);
        return new ApiResponse("add student succfully");
}


    @PutMapping("/updatestudent/{index}")
    public ApiResponse updatestudent( @PathVariable int index , @RequestBody Student student ){
    for(Student s : studentsarr){
        if (index == s.getId()){
            studentsarr.remove(s);
            studentsarr.add(student);
            return new ApiResponse("udated succfully");
        }
    }
        return new ApiResponse("null");
    }
    @DeleteMapping("/deletestudent/{index}")
    public ApiResponse deletestudent(@PathVariable int index){
    for(Student s : studentsarr){
        if(index == s.getId()){
            studentsarr.remove(s);
            return new ApiResponse("deleted succfully");
        }
    }
        return new ApiResponse("null");
    }

@GetMapping("/honorsstudent/{index}")
    public ApiResponse honorsStudent(@PathVariable int index){
    ArrayList<Student> firsthonner = new ArrayList<>();
    ArrayList<Student> secondthonner = new ArrayList<>();
    for (Student s : studentsarr){
        if(index == s.getId() && s.getGpa() > 4.75){
            firsthonner.add(s);
            return new ApiResponse("First honner ");
        }
         else if (index == s.getId()  && s.getGpa() >= 4.25 && s.getGpa() <4.75) {
              secondthonner.add(s);
            return new ApiResponse("Second honner ");
          }
        }
    return new ApiResponse(" the student not eligable for honners ");

    }
@GetMapping("/aboveavarge")
    public ArrayList<Student> studentsaboveavarge(){
    ArrayList<Student> aboveavarge = new ArrayList<>();
    double number_of_student =studentsarr.size();
    double sum = 0;

    for(Student s : studentsarr){
       sum=sum+ s.getGpa();
    }
    double avarge = sum/number_of_student;
    for (Student c : studentsarr){
        if(c.getGpa() > avarge){
            aboveavarge.add(c);
        }
    }
     return aboveavarge;
    }

    }










