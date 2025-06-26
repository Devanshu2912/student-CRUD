package com.service;

import java.util.ArrayList;
import java.util.List;

import com.model.student;

public class studentServiceImpl implements studentService{ // if we implement stdservice so autimatically defines crud methods...
	private List<student> studentList = new ArrayList<>();
	
	@Override
	public void addStudent(student std) {
		studentList.add(std);
		System.out.println("Student added Sucessfully");
	}

	@Override
	public student getStudentById(int id) {
		for(student std : studentList) {
			if(std.getId() == id)
				return std;
		}
		return null;
	}

	@Override
	public void updateStudent(int id, student updatedStudent) {
		for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).getId() == id) {
                studentList.set(i, updatedStudent);
                System.out.println("Student updated successfully!");
                return;
            }
        }
        System.out.println("Student with ID " + id + " not found.");
	}

	@Override
	public void deleteStudent(int id) {
		  student toDelete = getStudentById(id);
	        if (toDelete != null) {
	            studentList.remove(toDelete);
	            System.out.println("Student deleted successfully!");
	        } else {
	            System.out.println("Student not found.");
	        }
		
	}

	@Override
	public List<student> getAllStudents() {
		return studentList;
	}
}
