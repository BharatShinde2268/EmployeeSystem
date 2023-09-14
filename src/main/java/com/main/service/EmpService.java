package com.main.service;

import java.util.List;

import com.main.entity.Employee;

public interface EmpService {
	
	
	public Employee createEmp(Employee emp);
	
	public List<Employee> getAllEmp();
	
	public Employee getEmpById(int id); 
	
	public boolean deleteEmp(int id); 
	
	

}
