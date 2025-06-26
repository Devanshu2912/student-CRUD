package com.student;

import java.util.Scanner;

import com.model.student;
import com.service.studentService;
import com.service.studentServiceImpl;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// first scanner object create for check system value....
		studentService service = new studentServiceImpl();
		// outher object for std service impl method...
		
		int choice;
		
		do {
			System.out.println("\n==== Student Management System ====");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Search Student by ID");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline
            // according uper cases we defines their operation using switch case.....
        switch (choice) { // switch case helps us in CRUD .....
			case 1: // declare all values which we use in CURD....
				System.out.print("Enter ID: ");
                int id = sc.nextInt();
                sc.nextLine();
                System.out.print("Enter Name: ");
                String name = sc.nextLine();
                System.out.print("Enter Marks: ");
                Double marks = sc.nextDouble();
                service.addStudent(new student(id, name, marks));
                break;
                
			case 2:
                for (student s : service.getAllStudents()) {
                    System.out.println(s);
                }
                break;
                
            case 3:
            	System.out.print("Enter ID to search: ");
                int sid = sc.nextInt();
                student found = service.getStudentById(sid);
                if (found != null)
                    System.out.println(found);
                else
                    System.out.println("Student not found.");
                break;
                
            case 4:
                System.out.print("Enter ID to update: ");
                int uid = sc.nextInt();
                sc.nextLine();
                System.out.print("Enter New Name: ");
                String newName = sc.nextLine();
                System.out.print("Enter New Marks: ");
                Double newMarks= sc.nextDouble();
                sc.nextLine();
                service.updateStudent(uid, new student(uid, newName, newMarks));
                break;

            case 5:
                System.out.print("Enter ID to delete: ");
                int did = sc.nextInt();
                service.deleteStudent(did);
                break;

            case 0:
                System.out.println("Exiting system.\n"
                		+ "Invalid choice. Try again.");
                break;   
                
			default:
				break;
			}
            
		} while (choice != 0);
		sc.close();
	}
}
