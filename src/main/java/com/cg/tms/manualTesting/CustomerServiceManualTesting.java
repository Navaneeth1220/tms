package com.cg.tms.manualTesting;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.tms.entities.Customer;
import com.cg.tms.entities.Package;
import com.cg.tms.entities.Route;
import com.cg.tms.service.ICustomerService;
import com.cg.tms.service.IPackageService;
import com.cg.tms.service.IRouteService;
@Component
public class CustomerServiceManualTesting {
	
	@Autowired
	private IPackageService packageservice;
	
	@Autowired
	private IRouteService routeservice;

		@Autowired
		private ICustomerService service;

		public void start(){
			Customer customer1 = new Customer();
			Customer customer2 = new Customer();
			customer1.setCustomerId(1);
			customer1.setCustomerName("Mohan");
			customer1.setAddress("kancheepuram");
			customer2.setCustomerId(2);
			customer2.setCustomerName("Navneeth");
			customer2.setAddress("chennai");
			customer1 = service.addCustomer(customer1);
			customer2 = service.addCustomer(customer2);
			display(customer1);
			display(customer2);
			customer1.setCustomerId(1);
			customer1.setCustomerName("MSP");
			customer1.setAddress("Chennai");
			customer1 = service.updateCustomer(customer1);
			display(customer1);
			
			Package pack =new Package();
			pack.setPackageName("Local");
			pack.setPackageDescription("diverse and cultural");
			pack.setPackageType("Normal");
			pack.setPackageCost(8500.0);
			Package saved=packageservice.addPackage(pack);
			List<Customer> list1 = service.viewAllCustomers(saved.getPackageId());
			for(Customer i :list1) {
				System.out.println(i.getCustomerId());
				
			}
			
			Route  route = new Route();
			route.setRouteId("R1");
	        route.setRouteFrom("Jaipur");
	        route.setRouteTo("Delhi");
	        route.setFare(600);
	        Route saved1=routeservice.addRoute(route);
	        List<Customer>list2=service.viewCustomerList(saved1.getRouteId());
	        for(Customer j : list2) {
	        	System.out.println(j.getCustomerId());
	        }
			
			/*List<Customer> list = new ArrayList<>();
			list = service.viewCustomerList(null);
			List<Customer> list2 = new ArrayList<>();
			list2 = service.viewAllCustomers(1);
			System.out.println(Arrays.toString(list.toArray()));
			*/
		}

		public void display(Customer customer) {
			System.out.println("Customer_Id = " + customer.getCustomerId());
			System.out.println("Customer_Name = " + customer.getCustomerName());
			System.out.println("Customer_Address= " + customer.getAddress());

		}

	}

