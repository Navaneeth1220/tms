package com.cg.tms.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.tms.dto.CustomerDetails;
import com.cg.tms.dto.FetchCustomerByPackageId;
import com.cg.tms.dto.FetchCustomerByRouteId;
import com.cg.tms.entities.Customer;
import com.cg.tms.service.ICustomerService;

@Component
public class CustomerUtil {
    @Autowired
    private ICustomerService customerService;

    public CustomerDetails toCustomerDetail(Customer customer) {
        CustomerDetails customerDetails = new CustomerDetails();
        customerDetails.setCustomerId(customer.getCustomerId());
        customerDetails.setCustomerName(customer.getCustomerName());
        customerDetails.setCustomerPassword(customer.getCustomerPassword());
        customerDetails.setAddress(customer.getAddress());
        customerDetails.setEmail(customer.getEmail());
        customerDetails.setMobileNo(customer.getMobileNo());
        return customerDetails;
    }

    public List<CustomerDetails> toCustomerDetailList(Collection<Customer> customers) {

        List<CustomerDetails> desired = new ArrayList<>();
        for (Customer customer : customers) {
            CustomerDetails details = new CustomerDetails();
            details.setCustomerId(customer.getCustomerId());
            details.setCustomerName(customer.getCustomerName());
            details.setAddress(customer.getAddress());
            details.setEmail(customer.getEmail());
            details.setMobileNo(customer.getMobileNo());
            desired.add(details);
        }
        return desired;
    }

}
