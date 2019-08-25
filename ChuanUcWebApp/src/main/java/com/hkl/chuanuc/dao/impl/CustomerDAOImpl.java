package com.hkl.chuanuc.dao.impl;

import org.springframework.stereotype.Repository;

import com.hkl.chuanuc.dao.CustomerDAO;
import com.hkl.chuanuc.entity.Customer;

@Repository
public class CustomerDAOImpl extends BaseDAOImpl<Customer, Integer> implements CustomerDAO {

}
