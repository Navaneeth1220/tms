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
    private ICustomerService service;

    @Autowired
    private IPackageRepository packageRepository;

    @Autowired
    private IPaymentDetailsRepository paymentRepository;

    @Autowired
    private ITicketDetailsRepository ticketRepository;

    @Autowired
    private IBookingRepository bookingRepository;

    public void start() {
        Customer customer1 = new Customer();
        Customer customer2 = new Customer();
        customer1.setCustomerName("Mohan");
        customer1.setAddress("kancheepuram");
        customer2.setCustomerName("Navneeth");
        customer2.setAddress("chennai");
        customer1 = service.addCustomer(customer1);
        customer2 = service.addCustomer(customer2);
        display(customer1);
        display(customer2);
        customer1.setCustomerName("MSP");
        customer1.setAddress("Chennai");
        customer1 = service.addCustomer(customer1);
        display(customer1);

        PaymentDetails paymentDetails=new PaymentDetails();
        paymentDetails.setUserId(customer1.getCustomerId());
        paymentDetails=paymentRepository.save(paymentDetails);
        TicketDetails ticketDetails =new TicketDetails();
        ticketDetails.setTicketId("t1");
        Route route1 = new Route();
        route1.setRouteId("R1");
        route1.setRouteFrom("Jaipur");
        route1.setRouteTo("Delhi");
        route1.setFare(600);

        Package pack = new Package();
        pack.setPackageName("Local");
        pack.setPackageDescription("diverse and cultural");
        pack.setPackageType("Normal");
        pack.setPackageCost(8500.0);

        Package saved = packageRepository.save(pack);
        route1 = routeRepository.save(route1);
        ticketDetails.setRoute(route1);
        ticketDetails=ticketRepository.save(ticketDetails);

        Booking booking=new Booking();
        booking.setTicket(ticketDetails);
        booking.setPayment(paymentDetails);
        booking.setUserId(customer1.getCustomerId());
        booking.setPack(pack);
        booking=bookingRepository.save(booking);


        List<Customer> list1 = service.viewAllCustomers(saved.getPackageId());
        System.out.println("********display customers by package****");
        for (Customer i : list1) {
            System.out.println(i.getCustomerId());

        }


        List<Customer> list2 = service.viewCustomerList(route1.getRouteId());
        System.out.println("***displaying customers by route");
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

    }

}

