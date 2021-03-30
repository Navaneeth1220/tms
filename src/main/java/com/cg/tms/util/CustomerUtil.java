package com.cg.tms.util;

import com.cg.tms.dto.CustomerDetails;
import com.cg.tms.dto.PackageDetails;
import com.cg.tms.entities.Customer;
import com.cg.tms.entities.Package;
import com.cg.tms.entities.Route;

public class CustomerUtil {
	public CustomerDetails toDetailCustomer(Customer customer) {

		CustomerDetails customerDetails = new CustomerDetails();
		customerDetails.setCustomerId(customer.getCustomerId());
		customerDetails.setCustomerName(customer.getCustomerName());
		customerDetails.setCustomerPassword(customer.getCustomerPassword());
		customerDetails.setEmail(customer.getEmail());
		customerDetails.setMobileNo(customer.getMobileNo());
		
		
		Package pack =customer.getPack();
		if(pack != null) {
	
		customerDetails.setPackageId(pack.getPackageId());
		customerDetails.setPackageName(pack.getPackageName());
		customerDetails.setPackageDescription(pack.getPackageDescription());
		customerDetails.setPackageType(pack.getPackageType());
		}
		
		Route route = customer.getRoute();
		if (route != null) {
			
			customerDetails.setRouteId(route.getRouteId());
			customerDetails.setRouteFrom(route.getRouteFrom());
			customerDetails.setRouteTo(route.getRouteTo());
		}
		
      return customerDetails;
}
	
}
