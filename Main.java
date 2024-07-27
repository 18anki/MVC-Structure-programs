package com.ankita.erp;

import com.ankita.erp.Controller.StudentController;
import com.ankita.erp.Modal.DTO.StudentDTO;
import com.ankita.erp.Modal.Entity.Student;
import com.ankita.erp.Repository.StudentRepository;
import com.ankita.erp.Service.StudentService;

import java.util.Scanner;


public class Main {
    public static void main(String args[]) {
        StudentRepository repository = new StudentRepository();
        StudentService service = new StudentService(repository);

        StudentController studentController = new StudentController(service);





        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 20; i++) {
            System.out.println("Choose any of the operation to perform");
            System.out.println("1.Create Records");
            System.out.println("2.Fetch operation by ID");
            System.out.println("3.Fetch operation by RollNo");
            System.out.println("4.Update Data by RollNo");
            System.out.println("5.Fetch all Data");
            System.out.println("6.Delete Data by RollNo");

            int num = sc.nextInt();
            switch (num) {
                case 1:
                    studentController.Create();
                    /**this service() gets the data**/
                    service.getAll();
                    break;
                case 2:
                    StudentDTO studentDTO = studentController.getStudentByID();
                    if(studentDTO!=null)
                    System.out.println(studentDTO.toString());

                    break;

                case 3:
                    StudentDTO studentDT = studentController.getStudentByRollno();
                    if(studentDT!=null)
                        System.out.println(studentDT.toString());
                    break;

                case 4:
                    StudentDTO studentByrollno=studentController.getupdate();
                    if(studentByrollno!=null)
                        System.out.println(studentByrollno.toString());
                    break;

                case 5:
                    service.getAll();
                    break;

                case 6:
                    StudentDTO deleteByrolln=studentController.getdelete();
                    if(deleteByrolln!=null) {
                        System.out.println(deleteByrolln.toString());
                        break;
                    }
                    break;



            }
        }
    }
}