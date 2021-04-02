package com.cg.tms.controllers;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Min;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cg.tms.dto.CreateCustomerRequest;
import com.cg.tms.dto.CustomerDetails;
import com.cg.tms.dto.FetchCustomerByPackageId;
import com.cg.tms.dto.UpdateCustomerRequest;
import com.cg.tms.entities.Customer;
import com.cg.tms.service.ICustomerService;
import com.cg.tms.util.CustomerUtil;

@Validated
@RequestMapping("/customers")
@RestController
public class CustomerRestController {


	@Autowired
	private ICustomerService customerService;
	@Autowired
	private CustomerUtil customerUtil;
	
	/**
	 * method to view customer fetched by the given id
	 * @param id of the Customer
	 * @return customer details of the given id
	 */


	@GetMapping(value = "/byid/{id}")
	public CustomerDetails fetchCustomer(@PathVariable("id") @Min(1)int customerId) {
		Customer customer = customerService.viewCustomer(customerId);
		CustomerDetails customerDetails = customerUtil.toDetailCustomer(customer);
		return customerDetails;
	}
	/**
	 * method to create a Customer
	 * @param requestData
	 * @return details of the new Customer created
	 */
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("/addcustomer")
	public CustomerDetails addCustomer(@RequestBody @Valid CreateCustomerRequest requestData) {
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
	/**
	 * method to view customer fetched by the given package id
	 * @param  packageId of the needed package
	 * @return Customer details of the given packageId
	 */
	@GetMapping("/package/{id}")
	public List<FetchCustomerByPackageId> fetchCustomerByPack(@PathVariable("id")@Min(1) int packageId){
		List<Customer> customers =customerService.viewAllCustomers(packageId);
		List<FetchCustomerByPackageId> fetched = customerUtil.toCustomerDetails(customers);
		return fetched;
	}
	/**
	 * method to view customer fetched by the given route id
	 * @param  routeId of the needed Route
	 * @return Customer details of the given routeId
	 */
	@GetMapping("/route/{id}")
	public List<FetchCustomerByPackageId> fetchCustomerByroute(@PathVariable("id")String routeId ){
		List<Customer> customers =customerService.viewCustomerList(routeId);
		List<FetchCustomerByPackageId> fetched = customerUtil.toCustomerDetails(customers);
		return fetched;
	}

	/**
	 * method to delete a existing Customer,delete is done by providing id
	 * @param cid is the customerId
	 */

	@DeleteMapping("/deletecustomer/{cid}")
	public String deleteCustomer(@RequestBody @Valid int cid) {
        Customer customer=customerService.viewCustomer(cid);
		customerService.deleteCustomer(customer);
		return "deleted customer";
	}
	/**
	 * method to update  the customer details of the exsting Customer
	 * @param cid is the customerId
	 * @return
	 */
	@PutMapping("/updatecustomer/{cid}")
	public CustomerDetails toUpdateCustomer(@RequestBody @Valid UpdateCustomerRequest requestData,@PathVariable("cid") @Min(1) int customerId) {
		Customer customer = customerService.viewCustomer(customerId);
		customer.setCustomerName(requestData.getCustomerName());
		customer.setCustomerPassword(requestData.getCustomerPassword());
		customer.setAddress(requestData.getAddress());
		customer.setEmail(requestData.getEmail());
		customer.setMobileNo(requestData.getMobileNo());
		Customer savedCustomer = customerService.updateCustomer(customer);
		CustomerDetails details = customerUtil.toDetailCustomer(savedCustomer);
		return details;

}
}