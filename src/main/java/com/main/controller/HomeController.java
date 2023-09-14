package com.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.main.entity.Employee;
import com.main.service.EmpService;

import jakarta.servlet.http.HttpSession;

@Controller
public class HomeController {
  
	@Autowired
	private EmpService service;
	
	
	@GetMapping("/")      
	public String index(Model model)
	{  List<Employee> list = service.getAllEmp();
		model.addAttribute("empList",list);  
		return "index"; 
	}
	
	@GetMapping("/loadEmpSave")
	public String loadEmpSave() {
		
		return "emp-save";
	}
	
	
	
	@GetMapping("/editEmp/{id}") 
	public String editEmp(@PathVariable int id,Model model) {
		System.out.println(id);
		Employee emp = service.getEmpById(id);
		
		model.addAttribute("emp",emp);
		return "edit-emp";  
	}
	
	@PostMapping("/saveEmp")
	public String saveEmp(@ModelAttribute Employee emp, HttpSession session)
	{
		//System.out.println(emp);
		
		
		Employee createEmp = service.createEmp(emp);
		
		if(createEmp != null)
		{	System.out.println("save sussessfull");
			session.setAttribute("msg", "Registration Successfull");
		}
		else {
			System.out.println("something went to wrong on server");
			session.setAttribute("msg", "something went to wrong on server");
		}
		return "redirect:/loadEmpSave";
	}
	
	
	
}
