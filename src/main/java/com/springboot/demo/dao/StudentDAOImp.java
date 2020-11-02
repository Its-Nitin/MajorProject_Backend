package com.springboot.demo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springboot.demo.model.Student;

@Repository
public class StudentDAOImp implements StudentDAO {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public List<Student> fetchAllStudent() {

		List<Student> data;
		Session sess = sessionFactory.openSession();
		data = (List) sess.createQuery("from Student").list();
		return data;

	}

	@Override
	public boolean createStudent(Student student) {
		try {
		

			Session sess = sessionFactory.openSession();
			sess.beginTransaction();
			sess.save(student);
			sess.getTransaction().commit();
			return true;
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	
	@Override
	public void updateStudent(Student student) {
		try {

			Session sess = sessionFactory.openSession();
			sess.beginTransaction();
			sess.update(student);
			sess.getTransaction().commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public Student getStudentById(int id) {
		Session sess = sessionFactory.openSession();
		Student stu = sess.get(Student.class, id);
		return stu;
	}

	
	@Override
	public void deleteStudent(int id) {
		Session sess = sessionFactory.openSession();
		try {

			Student stu = sess.get(Student.class, id);
			sess.beginTransaction();
			sess.delete(stu);
			sess.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
