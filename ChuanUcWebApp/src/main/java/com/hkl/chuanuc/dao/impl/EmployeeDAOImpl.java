package com.hkl.chuanuc.dao.impl;

import org.springframework.stereotype.Repository;

import com.hkl.chuanuc.dao.EmployeeDAO;
import com.hkl.chuanuc.entity.Employee;

@Repository
public class EmployeeDAOImpl extends BaseDAOImpl<Employee, Integer> implements EmployeeDAO{

}
