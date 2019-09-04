package com.hkl.chuanuc.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hkl.chuanuc.dao.impl.EmployeeDAOImpl;
import com.hkl.chuanuc.entity.Employee;
import com.hkl.chuanuc.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDAOImpl employeeDAOImpl;

	@Transactional
	public List<Employee> getEmployees() {
		return employeeDAOImpl.findAll();
	}

	@Transactional
	public Employee getEmployee(int theId) {
		return employeeDAOImpl.findById(theId);
	}

	@Transactional
	public void deleteEmployee(int theId) {
		Employee employee = getEmployee(theId);
		employeeDAOImpl.delete(employee);
	}

	@Transactional
	public void saveOrUpdateEmployee(Employee theEmployee) {
		employeeDAOImpl.saveOrUpdate(theEmployee);
	}
	
}
