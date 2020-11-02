package com.springboot.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.demo.dao.StudentDAO;
import com.springboot.demo.model.Student;

@RestController
@CrossOrigin(origins = "http://localhost:4200" , methods = {RequestMethod.GET ,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class StudentController {

	@Autowired
	StudentDAO sdao;
	
	@GetMapping("/allStudents")
	public ResponseEntity<List<Student>> allStudents(){
		List<Student> allStu;
		allStu = sdao.fetchAllStudent();
		return new ResponseEntity<List<Student>>(allStu, HttpStatus.OK);
				
	}
	
//	@PutMapping(value = "/addStudent")
	@RequestMapping(value = "/addStudent", method= RequestMethod.POST)
	public ResponseEntity<Student> saveStudent(@RequestBody Student stu){
		
		sdao.createStudent(stu);
		return new ResponseEntity<Student>(stu, HttpStatus.CREATED);
		
	}
	
	@RequestMapping(value = "/updateStudent" ,method = RequestMethod.PUT)
	public ResponseEntity<Student> updateStudent(@RequestBody Student stu){
		if(stu != null) {
			sdao.updateStudent(stu);
			return new ResponseEntity<Student>(HttpStatus.OK);
		}
		else
			return new ResponseEntity<Student>(HttpStatus.NO_CONTENT);
	}
	
	@RequestMapping("/getStudentById/{id}")
	public ResponseEntity<Student> getStudentById(@PathVariable int id){
		
		Student stu = sdao.getStudentById(id);
		if (stu != null) {
			return new ResponseEntity<Student>(stu, HttpStatus.OK);
		}
		else
			return new ResponseEntity<Student>(HttpStatus.NO_CONTENT);
	}
	
	@RequestMapping(value = "/deleteStudent/{id}" ,method = RequestMethod.DELETE )
	public ResponseEntity<Student> deleteStudent(@PathVariable int id){
		
		sdao.deleteStudent(id);
			return new ResponseEntity<Student>( HttpStatus.OK);
	}
	
}	
	

