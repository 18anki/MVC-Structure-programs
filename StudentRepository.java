package com.ankita.erp.Repository;

import com.ankita.erp.Modal.DTO.StudentDTO;
import com.ankita.erp.Modal.Entity.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentRepository {

    List<Student> studentlist = new ArrayList();

    public void Save(Student entity) {
        studentlist.add(entity);

    }

    public List<Student> findAll() {
        System.out.println(studentlist);
        return this.studentlist;
        // System.out.println(studentlist);

    }

    public Student findByID(int id) {

        for (Student student : studentlist) {
            if (student.getId() == id) {
                return student;
            }
        }
        return null;

    }


    public Student findByRollno(int rollno) {

        for (Student student : studentlist) {
            if (student.getRollno() == rollno) {
                return student;
            }
        }
        return null;

    }


    public Student updateByRollNo(int rollno) {

        for (Student student : studentlist) {
            if (student.getRollno() == rollno) {
                // student.setName(name);
                return student;
            }

        }
        return null;
    }

//                for (Student student : studentlist) {
//                    if (student.getRollno() == rollno) {
//                        Scanner scan1 = new Scanner(System.in);
//                        System.out.println("Enter New ROLLNO : ");
//                        String rollno1 = scan1.nextLine();
//                        student.setName(rollno1);
//                    }
//                    break;
//                }
//


        public Student deleteByRollNo(int rollno){
            for (Student student : studentlist) {
                if (student.getRollno() != rollno) {
                    return null;
                }
                studentlist.remove(student);
                studentlist.remove(rollno);
                studentlist.remove(student.getId());
                studentlist.remove(student.getName());
                System.out.println("Delete sucessfull");
                return student;
                        }
                //return student;


            return null;

        }
    }

