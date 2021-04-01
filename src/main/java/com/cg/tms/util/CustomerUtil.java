package com.cg.tms.util;

import com.cg.tms.dto.CustomerDetails;
import com.cg.tms.dto.PackageDetails;
import com.cg.tms.entities.Customer;
import com.cg.tms.entities.Package;
import com.cg.tms.entities.Route;
import org.springframework.stereotype.Component;

@Component
public class CustomerUtil {
    public CustomerDetails toDetailCustomer(Customer customer) {

        CustomerDetails customerDetails = new CustomerDetails();
        customerDetails.setCustomerId(customer.getCustomerId());
        customerDetails.setCustomerName(customer.getCustomerName());
        customerDetails.setCustomerPassword(customer.getCustomerPassword());
        customerDetails.setEmail(customer.getEmail());
        customerDetails.setMobileNo(customer.getMobileNo());

        return customerDetails;
    }

}
