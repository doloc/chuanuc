package com.hkl.chuanuc.service;

import java.util.List;

import com.hkl.chuanuc.entity.Customer;

public interface CustomerService {
	public List<Customer> getCustomers();
	
	public void saveOrUpdateCustomer(Customer theCustomer);
	
	public Customer getCustomer(int theId);
	
	public void deleteCustomer(int theId);
}
