package com.hkl.chuanuc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.hkl.chuanuc.entity.Employee;
import com.hkl.chuanuc.service.EmployeeService;
import com.hkl.chuanuc.utils.JsonMapper;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	// URL:
	// http://localhost:8080/SomeContextPath/employees
	// http://localhost:8080/SomeContextPath/employees.xml
	// http://localhost:8080/SomeContextPath/employees.json
	@RequestMapping(value = "/employees", //
			method = RequestMethod.GET, //
			produces = { MediaType.APPLICATION_JSON_VALUE, //
					MediaType.APPLICATION_XML_VALUE })
	@ResponseBody
	public String getEmployees() {
		List<Employee> list = employeeService.getEmployees();
		Gson gson = new Gson();
		return gson.toJson(list);
	}

	// URL:
	// http://localhost:8080/SomeContextPath/employee/{empId}
	// http://localhost:8080/SomeContextPath/employee/{empId}.xml
	// http://localhost:8080/SomeContextPath/employee/{empId}.json
	@RequestMapping(value = "/employee/{id}", //
			method = RequestMethod.GET, //
			produces = { MediaType.APPLICATION_JSON_VALUE, //
					MediaType.APPLICATION_XML_VALUE })
	@ResponseBody
	public Employee getEmployee(@PathVariable("id") int empId) {
		return employeeService.getEmployee(empId);
	}
	
	@RequestMapping(value = "/employee", //
            method = RequestMethod.POST, //
            produces = { MediaType.APPLICATION_JSON_VALUE, //
                    MediaType.APPLICATION_XML_VALUE })
    @ResponseBody
    public void addEmployee(@RequestBody JsonObject obj) {
		Employee employee = JsonMapper.Instant.getObject(Employee.class, obj.toString());
        employeeService.saveOrUpdateEmployee(employee);
    }

	// URL:
	// http://localhost:8080/SomeContextPath/employee
	// http://localhost:8080/SomeContextPath/employee.xml
	// http://localhost:8080/SomeContextPath/employee.json
	@RequestMapping(value = "/employee", //
			method = RequestMethod.PUT, //
			produces = { MediaType.APPLICATION_JSON_VALUE, //
					MediaType.APPLICATION_XML_VALUE })
	@ResponseBody
	public void updateEmployee(@RequestBody JsonObject obj) {
		Employee employee = JsonMapper.Instant.getObject(Employee.class, obj.toString());
		employeeService.saveOrUpdateEmployee(employee);
	}

	// URL:
	// http://localhost:8080/SomeContextPath/employee/{empId}
	@RequestMapping(value = "/employee/{id}", //
			method = RequestMethod.DELETE, //
			produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	@ResponseBody
	public void deleteEmployee(@PathVariable("id") int theId) {
		employeeService.deleteEmployee(theId);
	}

}
