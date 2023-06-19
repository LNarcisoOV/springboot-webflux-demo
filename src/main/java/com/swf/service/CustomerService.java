package com.swf.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.swf.dao.CustomerDAO;
import com.swf.dto.CustomerDTO;

@Service
public class CustomerService {

    @Autowired
    private CustomerDAO customerDAO;

    public List<CustomerDTO> getCustomers() {
        long start = System.currentTimeMillis();
        List<CustomerDTO> customers = customerDAO.getCustomers();
        long end = System.currentTimeMillis();
        System.out.println("Total time: " + (end - start));
        return customers;
    }
}
