package com.jbk.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jbk.hibernate.Employee;

@Repository
public class SpringDao {

	@Autowired
	SessionFactory sessionfactory;
	
	public List<Employee> getAllemployee() {
		// TODO Auto-generated method stub
		//dao
		Session session=sessionfactory.openSession();
		session.beginTransaction();
		Criteria criteria=session.createCriteria(Employee.class);
		List<Employee> emp_list=(List<Employee>)criteria.list();
		
		return emp_list;
	}

	public List<Employee> getemployeebyid(int emp_id) {
		// TODO Auto-generated method stub
		
		Session session=sessionfactory.openSession();
		session.beginTransaction();
		
		
		//sessionfactory.getCurrentSession().load(Employee.class, emp_id);
		Criteria criteria=session.createCriteria(Employee.class);
		criteria.add(Restrictions.eq("id", emp_id));
		
		List<Employee> list_emp=criteria.list();
		
		return list_emp;
	}

	public List<Employee> getemployeebyname(String name) {
		// TODO Auto-generated method stub
		
		Session session=sessionfactory.openSession();
		session.beginTransaction();
		
		
		//sessionfactory.getCurrentSession().load(Employee.class, emp_id);
		Criteria criteria=session.createCriteria(Employee.class);
		criteria.add(Restrictions.eq("name", name));
		
		List<Employee> list_emp=criteria.list();
		
		return list_emp;
		
		
		
	}

	public List<Employee> getemployeebystatus(String status) {
		// TODO Auto-generated method stub
		Session session=sessionfactory.openSession();
		session.beginTransaction();
		
		
		//sessionfactory.getCurrentSession().load(Employee.class, emp_id);
		Criteria criteria=session.createCriteria(Employee.class);
		criteria.add(Restrictions.eq("status", status));
		
		List<Employee> list_emp=criteria.list();
		
		return list_emp;
	}

	public List<Employee> getemployeebytype() {
		
		Session session=sessionfactory.openSession();
		session.beginTransaction();
	
		
		
		return null;
	}

}
