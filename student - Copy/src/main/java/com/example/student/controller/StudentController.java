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
    studentsarr.set(index,student);
    return new ApiResponse("updated succfully");

    }
    @DeleteMapping("/deletestudent/{index}")
    public ApiResponse deletestudent(@PathVariable int index){
    studentsarr.remove(index);
    return new ApiResponse("deleted succfully");
    }



@GetMapping("/honorsstudent/{index}")
    public ApiResponse honorsStudent(@PathVariable int index ){

    if(studentsarr.get(index).getGpa() > 4.75){
        return new ApiResponse("first honners");
    }
    else if(studentsarr.get(index).getGpa() > 4.25){
        return new ApiResponse("second honners");
    }
    else {
        return new ApiResponse("not eligable for first or second honners");
    }


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










