package com.jbk.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jbk.dao.SpringDao;
import com.jbk.hibernate.Employee;

@Service
public class SpringService {

	@Autowired
	SpringDao springdao;
	
	public List<Employee> getAllemployee() {
		
		List<Employee> emplist=springdao.getAllemployee();
		return emplist;
	}

	public List<Employee> getemployeebyid(int id) {
		// TODO Auto-generated method stub
		List<Employee> emplist=springdao.getemployeebyid(id);
		
		return  emplist;
	}

	public List<Employee> getemployeebyname(String name) {
		// TODO Auto-generated method stub
		List<Employee> emplist=springdao.getemployeebyname(name);
		
		return  emplist;
		
	}

	public List<Employee> getemployeebystatus(String status) {
		// TODO Auto-generated method stub
		List<Employee> emplist=springdao.getemployeebystatus(status);
		
		return  emplist;
	}

	public List<Employee> getemployeebytype(String type) {
		// TODO Auto-generated method stub
		List<Employee>emplist=null;
		if(type.equals("retired"))
		{
			emplist=springdao.getemployeebytype();
		}
		
		return emplist;
	}

	
}
