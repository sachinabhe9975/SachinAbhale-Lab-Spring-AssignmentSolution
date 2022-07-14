package com.greatlearning.student_debate_management.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.greatlearning.student_debate_management.entity.Student;

@Service
public interface StudentService {
	
	public List<Student> findAll();
	public void save(Student b);
	public Student findById(Integer id);
	public void delete(Student b);
	public List<Student> findByfirstname_lastname_course_country_(String firstname, String lastname, String course, String country);
}
