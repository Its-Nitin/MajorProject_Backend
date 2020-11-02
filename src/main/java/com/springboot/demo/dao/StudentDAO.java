package com.springboot.demo.dao;

import java.util.List;

import com.springboot.demo.model.Student;

public interface StudentDAO {

	public List<Student> fetchAllStudent ();
	public boolean createStudent(Student student);
	public Student getStudentById(int id);
	public void updateStudent(Student student);
	public void deleteStudent(int id);


}



