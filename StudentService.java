package com.ankita.erp.Service;

import java.io.InvalidObjectException;

import com.ankita.erp.Repository.StudentRepository;
import com.ankita.erp.Validator.StudentValidate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.ankita.erp.Modal.Entity.Student;
import com.ankita.erp.Validator.StudentValidate;
import com.ankita.erp.Modal.DTO.*;

public class StudentService {

    /**@studentRepository is my single ton object**/
    StudentRepository studentRepository;
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }



    public void validateAndSaveStudent(StudentDTO studentDTO) throws InvalidObjectException{
        /**@Step1 : validate dto**/
        if(StudentValidate.isNullOrEmpty(studentDTO.getName())) {
            throw new InvalidObjectException("Name is mandatory");
        }

        /**@Step 2: convert dto to entity **/
        Student student = new Student();
        student.setName(studentDTO.getName());
        student.setId(studentDTO.getId());
        student.setRollno(studentDTO.getRollno());

        /**@Step 3 :  save to repository**/
        studentRepository.Save(student);

    }


    public List<StudentDTO> getAll() {
        /**student dto list to return**/
        List<StudentDTO> studentDtoList =new ArrayList();

        /** fetching data from repository **/
        List<Student> studentList = studentRepository.findAll();

        /**itrating and converting entity to dto*/
        studentList.forEach(entity->{

            StudentDTO dto = new StudentDTO();
            dto.setId(entity.getId());
            dto.setRollno(entity.getRollno());
            dto.setName(entity.getName());

            /**adding data into @studentDtoList **/
            studentDtoList.add(dto);
        });
        return studentDtoList;
    }

    public  StudentDTO getStudentid(StudentDTO studentDTO) throws Exception{
        if(studentDTO.getId()==0){

        }
        Student student = studentRepository.findByID(studentDTO.getId());
        if(student==null){
            throw new InvalidObjectException("Student not found");
        }
        studentDTO.setName(student.getName());
        studentDTO.setRollno(student.getRollno());
        studentDTO.setId(student.getId());
        return  studentDTO;
    }

    public  StudentDTO getStudentrollno(StudentDTO studentDTO) throws Exception{
        if(studentDTO.getRollno()==0){

        }
        Student student = studentRepository.findByRollno(studentDTO.getRollno());
        if(student==null){
            throw new InvalidObjectException("Student not found");
        }
        studentDTO.setName(student.getName());
        studentDTO.setRollno(student.getRollno());
        studentDTO.setId(student.getId());
        return  studentDTO;
    }

    public  StudentDTO update(StudentDTO studentDTO) throws InvalidObjectException {
        if(studentDTO.getRollno()==0){

        }
         Student student = studentRepository.updateByRollNo(studentDTO.getRollno());
        if(student==null){
            throw new InvalidObjectException("Student not found");
        }

//        studentDTO.setName(student.getName());
//        studentDTO.setRollno(student.getRollno());
//        studentDTO.setId(student.getId());
        return  studentDTO;

    }

    public  StudentDTO delete(StudentDTO studentDTO) throws InvalidObjectException{
        if(studentDTO.getRollno()==0){

        }
        Student student= studentRepository.deleteByRollNo(studentDTO.getRollno());
        if(student==null){
            throw new InvalidObjectException("Student not found");
        }

        studentDTO.setName(student.getName());
            studentDTO.setRollno(student.getRollno());
            studentDTO.setId(student.getId());
            return  studentDTO;
    }

}
