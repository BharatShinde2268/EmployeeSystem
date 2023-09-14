package com.main.service.impl;

import java.util.List;

import org.apache.catalina.startup.ClassLoaderFactory.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.main.entity.Employee;
import com.main.repository.EmpRepository;
import com.main.service.EmpService;

import jakarta.servlet.http.HttpSession;
@Service
public class EmpServiceImpl implements EmpService {

	@Autowired
	private EmpRepository rep;
	
	
	@Override
	public Employee createEmp(Employee emp) {
		Employee save = rep.save(emp);
		
		return save;
	}

	@Override
	public List<Employee> getAllEmp() {
		
		return rep.findAll(); 
	}

	@Override
	public Employee getEmpById(int id) {
		
		return rep.findById(id).get();
	}

	@Override
	public boolean deleteEmp(int id) {
		Employee finds = rep.findById(id).get();
		if(finds != null)
		{
			rep.delete(finds);
			return true;
		}
		
		return false;
	}
	
	
	public void removeSessionMessage()
	{
		HttpSession session = ((ServletRequestAttributes)(RequestContextHolder.getRequestAttributes())).getRequest().getSession();
		session.removeAttribute("msg");
	}
	

}
