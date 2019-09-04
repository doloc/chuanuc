package com.hkl.chuanuc.service;

import java.util.List;

import com.hkl.chuanuc.entity.Employee;

public interface EmployeeService {

	public List<Employee> getEmployees();
	
	public void saveOrUpdateEmployee(Employee theEmployee);

	public Employee getEmployee(int theId);

	public void deleteEmployee(int theId);

}
