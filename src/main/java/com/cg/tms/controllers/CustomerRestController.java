package com.cg.tms.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cg.tms.dto.CreateCustomerRequest;
import com.cg.tms.dto.CustomerDetails;
import com.cg.tms.dto.DeleteCustomerRequest;
import com.cg.tms.entities.Customer;
import com.cg.tms.service.ICustomerService;
import com.cg.tms.util.CustomerUtil;

@RequestMapping("/customers")
@RestController
public class CustomerRestController {


	@Autowired
	private ICustomerService customerService;
	@Autowired
	private CustomerUtil customerUtil;

	@GetMapping(value = "/byid/{id}")
	public CustomerDetails fetchCustomer(@PathVariable("id") int customerId) {
		Customer customer = customerService.viewCustomer(customerId);
		CustomerDetails customerDetails = customerUtil.toDetailCustomer(customer);
		return customerDetails;
	}


	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("/addCustomer")
	public CustomerDetails addCustomer(@RequestBody CreateCustomerRequest requestData) {

		Customer customer = new Customer();
		customer.setCustomerName(requestData.getCustomerName());
		customer.setCustomerPassword(requestData.getCustomerPassword());
		customer.setAddress(requestData.getAddress());
		customer.setMobileNo(requestData.getMobileNo());
		customer.setEmail(requestData.getEmail());
		Customer added = customerService.addCustomer(customer);
		CustomerDetails customerDetails = customerUtil.toDetailCustomer(added);
		return customerDetails;
	}

	@DeleteMapping("/deleteCustomer/{cid}")
	public String deleteCustomer(@RequestBody int cid) {
        Customer customer=customerService.viewCustomer(cid);
		customerService.deleteCustomer(customer);
		return "deleted customer";
	}

}