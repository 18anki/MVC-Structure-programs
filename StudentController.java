package com.ankita.erp.Controller;
import java.io.InvalidObjectException;
import java.util.Scanner;

import com.ankita.erp.Modal.DTO.StudentDTO;
import com.ankita.erp.Modal.Entity.Student;

import com.ankita.erp.Service.StudentService;

public class StudentController {
    private StudentService studentService;
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    public void Create()  {
        StudentDTO studentDTO =  new StudentDTO();
        Scanner sc=new Scanner(System.in);
        System.out.println("Name :");
        String name=sc.nextLine();
        System.out.println("ID :");
        int id=sc.nextInt();
        System.out.println("Rollno :");
        int rollno=sc.nextInt();
        studentDTO.setName(name);
        studentDTO.setId(id);
        studentDTO.setRollno(rollno);
        try {
            studentService.validateAndSaveStudent(studentDTO);
        } catch (InvalidObjectException e) {
            e.printStackTrace();
        }


    }

    public StudentDTO getStudentByID() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter ID to fetch data :");
        int id = sc.nextInt();
        StudentDTO studentDTO =  new StudentDTO();
        studentDTO.setId(id);
        try {
            studentDTO=  studentService.getStudentid(studentDTO);
        }catch (Exception e){
            e.getMessage();
        }
        return studentDTO;
    }


    public StudentDTO getStudentByRollno() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Rollno to fetch data :");
        int rollno = sc.nextInt();
        StudentDTO studentDTO =  new StudentDTO();
        studentDTO.setRollno(rollno);
        try {
            studentDTO=  studentService.getStudentrollno(studentDTO);
        }catch (Exception e){
            e.getMessage();
        }
        return studentDTO;
    }


    public StudentDTO getupdate() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter rollno to update data :");
        int rollNumber = sc.nextInt();
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setRollno(rollNumber);

            Scanner scan = new Scanner(System.in);
            System.out.println("Enter New NAME : ");
            String name = scan.nextLine();
            studentDTO.setName(name);

        try {
             studentDTO=  studentService.update(studentDTO);
        }catch (Exception e){
            e.getMessage();
        }
        return studentDTO;

    }

    public StudentDTO getdelete(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter rollno to delete data :");
        int rollNumber = sc.nextInt();
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setRollno(rollNumber);
        try{
            studentDTO= studentService.delete(studentDTO);
        }catch (Exception e){
            e.getMessage();
        }
        return studentDTO;
    }

    public void update(){

    }



}
