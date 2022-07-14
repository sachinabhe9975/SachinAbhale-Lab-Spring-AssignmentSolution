package com.greatlearning.student_debate_management.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.greatlearning.student_debate_management.entity.Student;
import com.greatlearning.student_debate_management.service.StudentService;

@Controller
@RequestMapping("/student")
public class StudentController {
	 @Autowired
	    private StudentService studentService;
	    
	 @RequestMapping({ "/home" })
	    public String goHome() {
	        return "home";
	    }
	 
	 
	    @RequestMapping("/list")
	    public String findAll( Model model) {
	        List<Student> StudentList = studentService.findAll();
	        model.addAttribute("Student", StudentList);
	        return "student";
	    }
	    
	    @RequestMapping("/addStudent")
	    public String ShowFormToAdd( Model model) {
	       
	            Student newstud = new Student();
	           
	            model.addAttribute("Student", newstud);
	        
	        return "studentform";
	    }
	    
	    @RequestMapping("/updateStudent")
		public String showFormForUpdate(@RequestParam("id") Integer theId,
				Model theModel) {

			// get the Book from the service
			Student theStudent = studentService.findById(theId);


			// set Book as a model attribute to pre-populate the form
			theModel.addAttribute("Student", theStudent);

			// send over to our form
			return "studentform";			
		}
	    
	    @PostMapping("/save")
	    public String save(@RequestParam("id")  Integer id, @RequestParam("firstname") String firstname, @RequestParam("lastname")  String lastname, @RequestParam("course")  String course, @RequestParam("country")  String country) {
	        System.out.println("id is" + id+ "first name is" + firstname);
	        Student s ;
	        if (id != 0) {
	            s = studentService.findById(id);
	            s.setFirstname(firstname);
	            s.setLastname(lastname);
	            s.setCourse(course);
	            s.setCountry(country);
	        }
	        else {
	            s = new Student(firstname, lastname, course,country);
	        }
	        studentService.save(s);
	        return "redirect:list";
	    }
	    
	    @RequestMapping("/deleteStudent")
	    public String deleteStudent(@RequestParam("id") Integer theid) {

			if(theid!=0)
			{
				Student theStudent = studentService.findById(theid);
				studentService.delete(theStudent);
			}
			
			// redirect to /Books/list
			return "redirect:/student/list";
	    }
	    
	    
	    
	    @RequestMapping("/403")
		public ModelAndView accessDenied(Principal user)
		{
			ModelAndView mv=new ModelAndView();
			
			if(user!=null)
			{
				mv.addObject("msg", "Hi "+user.getName()+", you are not allowed to access this page");			
			}
			else
			{
				mv.addObject("msg", "Hi, you are not allowed to access this page");	
			}
			mv.setViewName("403");
			return mv;
		}
}
