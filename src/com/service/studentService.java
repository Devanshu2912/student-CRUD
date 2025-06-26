package com.service;

import java.util.List;
import com.model.student;

public interface studentService {
	void addStudent (student student);
	//add student 
	student getStudentById(int id);
	// by id get student details..
	void updateStudent(int id, student updatedStudent);
	//update student
	void deleteStudent(int id);
	//delete student
	List<student> getAllStudents(); // get all student details
}