package com.cg.tms.manualTesting;

import java.util.List;

import com.cg.tms.entities.*;
import com.cg.tms.entities.Package;
import com.cg.tms.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.tms.service.ICustomerService;
import com.cg.tms.service.IPackageService;
import com.cg.tms.service.IRouteService;

@Component
public class CustomerServiceManualTesting {

    @Autowired
    private IPackageService packageService;

    @Autowired
    private IRouteService routeService;

    @Autowired
    private IRouteRepository routeRepository;

    @Autowired
    private ICustomerService customerService;

    @Autowired
    private IPackageRepository packageRepository;

    @Autowired
    private IPaymentDetailsRepository paymentRepository;

    @Autowired
    private ITicketDetailsRepository ticketRepository;

    @Autowired
    private IBookingRepository bookingRepository;

    public void start() {
    	/*
    	 * Two new customers are added in the database
    	 */
        Customer customer1 = new Customer();
        Customer customer2 = new Customer();
        customer1.setCustomerName("Mohan");
        customer1.setAddress("kancheepuram");
        customer1.setEmail("msp@gmail.com");
        customer1.setMobileNo("8754489885");
        customer2.setCustomerName("Navneeth");
        customer2.setAddress("chennai");
        customer2.setEmail("navneth@gmail.com");
        customer2.setMobileNo("8755448955");
        customer1 = customerService.addCustomer(customer1);
        customer2 = customerService.addCustomer(customer2);
        display(customer1);
        display(customer2);
        /*
         * Updating the name and address of the Customer 1
         */
        customer1.setCustomerName("MSP");
        customer1.setAddress("Chennai");
        customer1 = customerService.updateCustomer(customer1);
        display(customer1);
        
        
        Customer deletecustomer = customerService.deleteCustomer(customer2);
		display(deletecustomer);
        System.out.println("****************DELETED A CUSTOMER*************");
        /*
         * payment details  and ticket details are saved in the database
         * 
         */
        PaymentDetails paymentDetails=new PaymentDetails();
        paymentDetails.setUserId(customer1.getCustomerId());
        paymentDetails=paymentRepository.save(paymentDetails);
        TicketDetails ticketDetails =new TicketDetails();
        ticketDetails.setTicketId("t1");
        /*
         * routes are setted for the Customer 1 and saved in the database
         */
        Route route1 = new Route();
        route1.setRouteId("R1");
        route1.setRouteFrom("Jaipur");
        route1.setRouteTo("Delhi");
        route1.setFare(600);
        /*
         * package details are setted for Customer 1 and saved in the database
         */

        Package pack = new Package();
        pack.setPackageId(8);
        pack.setPackageName("Local");
        pack.setPackageDescription("diverse and cultural");
        pack.setPackageType("Normal");
        pack.setPackageCost(8500.0);

        Package saved = packageRepository.save(pack);
        route1 = routeRepository.save(route1);
        ticketDetails.setRoute(route1);
        ticketDetails=ticketRepository.save(ticketDetails);
         /*
          * booking is done and saved in database
          */
        Booking booking=new Booking();
        booking.setTicket(ticketDetails);
        booking.setPayment(paymentDetails);
        booking.setUserId(customer1.getCustomerId());
        booking.setPack(pack);
        booking=bookingRepository.save(booking);


        List<Customer> list1 = customerService.viewAllCustomers(saved.getPackageId());
        System.out.println("**********display customers by package**********");
        for (Customer i : list1) {
            System.out.println(i.getCustomerId());

        }


        List<Customer> list2 = customerService.viewCustomerList(route1.getRouteId());
        System.out.println("**********displaying customers by route***********");
        for (Customer j : list2) {
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
        System.out.println("Customer_Email= " + customer.getEmail());
        System.out.println("Customer_MobileNo= " + customer.getMobileNo());

    }

}

