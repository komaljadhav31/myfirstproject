package com.jbk.controller;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.jbk.hibernate.Employee;
import com.jbk.service.SpringService;

@RestController
@CrossOrigin
@ComponentScan("com.jbk")
public class SpringController {
	
	@Autowired
	SessionFactory sessionfactory;

	@Autowired
	SpringService springservice;
	
	
	@GetMapping("/getallemployee")
	public List<Employee> getAllemployee()
	{
		List<Employee> list=springservice.getAllemployee();
		return list;
	}
	@GetMapping("/getallemployeebyid/{id}")
	public List<Employee> getemployeebyid(@PathVariable int id)
	{
		List<Employee> list=springservice.getemployeebyid(id);
		return list;
	}
	
	@GetMapping("/getallemployeebyname/{name}")
	public List<Employee> getemployeebyname(@PathVariable String name)
	{
		List<Employee> list=springservice.getemployeebyname(name);
		return list;
	}
	
	@GetMapping("/getallemployeebystatus/{status}")
	public List<Employee> getemployeebystatus(@PathVariable String status)
	{
		List<Employee> list=springservice.getemployeebystatus(status);
		return list;
	}
	@GetMapping("/getallemployeebytype/{type}")
	public List<Employee> getemployeebytype(@PathVariable String type)
	{
		List<Employee> list=springservice.getemployeebytype(type);
		return list;
	}
	
	@PostMapping("addemployee")
	public String addEmployee(@RequestBody Employee employee) throws Exception {
		System.out.println(employee);// getdata
		
	
		Session session=sessionfactory.openSession();
		Transaction transaction=session.beginTransaction();
		
		Employee emp1=new Employee();
		emp1.setId(employee.getId());
		emp1.setName(employee.getName());
		emp1.setSname(employee.getSname());
		emp1.setStatus(employee.getStatus());
		
		session.save(emp1);
		transaction.commit();
		return "employee added";
	}

}

	

