package com.greatlearning.student_debate_management.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.greatlearning.student_debate_management.entity.Student;
	
	public interface StudentRepository extends JpaRepository<Student, Integer> {
		
		public List<Student> findByFirstnameContainsAndLastnameContainsAndCourseContainsAndCountryContains(String firstname, String lastname, String course, String country);
		
			
		}
	

