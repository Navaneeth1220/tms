package com.cg.tms.service;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;
import com.cg.tms.entities.*;
import com.cg.tms.entities.Package;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.function.Executable;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import com.cg.tms.exceptions.InvalidCustomerIdException;
import com.cg.tms.repository.ICustomerRepository;
import com.cg.tms.repository.IPackageRepository;
import com.cg.tms.repository.IRouteRepository;

@ExtendWith(MockitoExtension.class)
public class CustomerServiceImplUnitTesting {

	@Mock
	ICustomerRepository customerRepository;
	@Mock
	IRouteRepository routeRepository;
	@Mock
	IPackageRepository packageRepository;

	@Spy
	@InjectMocks
	CustomerServiceImpl service;
	/*
	 * Success scenario
	 * Addition of customer
	 * 
	 */

	@Test
	void test_AddCustomer() {
		int customerId = 1;
		String customerName = "msp";
		String customerAddress = "chennai";

		Customer customer = new Customer();
		customer.setAddress(customerAddress);
		customer.setCustomerName(customerName);
		customer.setCustomerId(customerId);
		when(customerRepository.save(customer)).thenReturn(customer);
		Customer result = service.addCustomer(customer);

		Assertions.assertNotNull(result);
		Assertions.assertEquals(customerName, result.getCustomerName());
		Assertions.assertEquals(customerAddress, result.getAddress());
		Assertions.assertEquals(customerId, result.getCustomerId());
	}
	/*
	 *  success scenario
	 *  View_all_Test
	 */


	/*
	 * testValidateCustomerId_1 fail case scenario
	 */
	@Test
	public void testValidateCustomerId_1() {

		String CustomerName = "";
		Executable executable = () -> service.validateCustomerName(CustomerName);
		Assertions.assertThrows(InvalidCustomerIdException.class, executable);

	}

	/*
	 * testValidateCustomer Success Scenario
	 */
	@Test
	public void testValidateCustomerId_2() {

		String CustomerName = "Mohan";
		service.validateCustomerName(CustomerName);
	}

	/*
	 * Success Scenario Testing updationOfCustomer
	 * 
	 */
	@Test
	public void testUpdateCustomer() {
		int CustomerId = 1;
		String customername = "msp";
		String customeraddress = "chennai";
		String customerpassword = "Msp23";
		Customer customer = mock(Customer.class);
		when(customer.getCustomerId()).thenReturn(CustomerId);
		when(customer.getCustomerName()).thenReturn(customername);
		when(customer.getCustomerPassword()).thenReturn(customerpassword);
		when(customer.getAddress()).thenReturn(customeraddress);
		Optional<Customer> optional = Optional.of(customer);
		when(customerRepository.findById(CustomerId)).thenReturn(optional);
		doNothing().when(service).validateCustomerName(customername);
		when(customerRepository.save(customer)).thenReturn(customer);
		Customer result = service.updateCustomer(customer);
		Assertions.assertNotNull(result);
		Assertions.assertSame(result, customer);

	}

	/*
	 * View customer List with same route ID
	 */
	@Test
	public void testViewCustomerList() {
		
		String routeId="R1";
		List<Customer>customers=mock(List.class);
		Customer customer=mock(Customer.class);
		Route route =mock(Route.class);
		Optional<Customer>optional=Optional.of(customer);
		Optional<Route>optional1=Optional.of(route);
		when(routeRepository.findById(routeId)).thenReturn(optional1);
		when(customerRepository.findByRoute(route)).thenReturn(customers);
		List<Customer>result=service.viewCustomerList(routeId);
		Assertions.assertNotNull(result);
		Assertions.assertSame(result, customers);
		
		

		
	}
	/*
	 * List of customers with the same package id
	 */
	@Test
	public void testViewCustomerList_2() {
		
		int packageId=1;
		List<Customer>customers=mock(List.class);
		Customer customer=mock(Customer.class);
		Package pack =mock(Package.class);
		Optional<Customer>optional=Optional.of(customer);
		Optional<Package>optional1=Optional.of(pack);
		when(packageRepository.findById(packageId)).thenReturn(optional1);
		when(customerRepository.findByPack(pack)).thenReturn(customers);
		List<Customer>result=service.viewAllCustomers(packageId);
		Assertions.assertNotNull(result);
		Assertions.assertSame(result, customers);
		
	
}
	}
