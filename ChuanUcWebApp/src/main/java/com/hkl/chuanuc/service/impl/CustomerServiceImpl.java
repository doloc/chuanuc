package com.hkl.chuanuc.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hkl.chuanuc.dao.impl.CustomerDAOImpl;
import com.hkl.chuanuc.entity.Customer;
import com.hkl.chuanuc.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerDAOImpl customerDAOImpl;

	@Transactional
	public List<Customer> getCustomers() {
		return customerDAOImpl.findAll();
	}

	@Transactional
	public void saveOrUpdateCustomer(Customer theCustomer) {
		customerDAOImpl.saveOrUpdate(theCustomer);
	}

	@Transactional
	public Customer getCustomer(int theId) {
		return customerDAOImpl.findById(theId);
	}

	@Transactional
	public void deleteCustomer(int theId) {
		Customer customer = getCustomer(theId);
		customerDAOImpl.delete(customer);
	}

}
