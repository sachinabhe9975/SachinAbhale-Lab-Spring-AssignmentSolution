package com.greatlearning.student_debate_management.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greatlearning.student_debate_management.entity.Student;
import com.greatlearning.student_debate_management.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	private StudentRepository studentrepo;
	public List<Student> findAll(){
		return studentrepo.findAll();
	}
	@Override
	public void save(Student s) {
		 studentrepo.save(s);
	}

	@Override
	public Student findById(Integer id) {
		// TODO Auto-generated method stub
		return studentrepo.getOne(id);
	}

	@Override
	public void delete(Student b) {
		// TODO Auto-generated method stub
		
		studentrepo.delete(b);
	}

	@Override
	public List<Student> findByfirstname_lastname_course_country_(String firstname, String lastname, String course, String country) {
		return studentrepo.findByFirstnameContainsAndLastnameContainsAndCourseContainsAndCountryContains(firstname, lastname, course, country);
	}

}
