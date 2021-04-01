package com.cg.tms.service;

import java.util.List;
import java.util.Optional;

import com.cg.tms.entities.Route;
import com.cg.tms.repository.IPackageRepository;
import com.cg.tms.repository.IRouteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.tms.entities.Package;
import com.cg.tms.entities.Customer;
import com.cg.tms.exceptions.CustomerNotFoundException;
import com.cg.tms.exceptions.PackageNotFoundException;
import com.cg.tms.exceptions.RouteNotFoundException;
import com.cg.tms.repository.ICustomerRepository;
import com.cg.tms.exceptions.*;

@Service
public class CustomerServiceImpl implements ICustomerService {
    @Autowired
    private ICustomerRepository customerRepository;

    @Autowired
    private IRouteRepository routeRepository;

    @Autowired
    private IPackageRepository packageRepository;

    @Override
    public Customer addCustomer(Customer customer) {
        validateCustomer(customer);
        customerRepository.save(customer);
        return customer;
    }

    @Override
    public Customer updateCustomer(Customer customer) throws CustomerNotFoundException {
        validateCustomer(customer);
        boolean exists = customerRepository.existsById(customer.getCustomerId());
        if (!exists) {
            throw new CustomerNotFoundException("This Customer is not found in Database");
        }
        customerRepository.save(customer);
        return customer;
    }

    @Override
    public Customer deleteCustomer(Customer customer) throws CustomerNotFoundException {
        validateCustomer(customer);
        customerRepository.delete(customer);
        return customer;
    }


    @Override
    public Customer viewCustomer(int custid) throws CustomerNotFoundException {
        Optional<Customer> optional = customerRepository.findById(custid);
        if (!optional.isPresent()) {
            throw new CustomerNotFoundException("Booking not found");
        }
        return optional.get();
    }

    @Override
    public List<Customer> viewAllCustomers(int packageId) throws PackageNotFoundException {
        Optional<Package> optionalPack = packageRepository.findById(packageId);
        if (!optionalPack.isPresent()) {
            throw new PackageNotFoundException("The package does not exist for the mentioned packageId= " + packageId);
        }
        Package pack = optionalPack.get();
        List<Integer> ids = customerRepository.findByPack(pack);
        List<Customer>customers=customerRepository.findAllById(ids);
        return customers;
    }

    @Override
    public List<Customer> viewCustomerList(String routeId) throws RouteNotFoundException {
        Optional<Route> optionalRoute = routeRepository.findById(routeId);
        if (!optionalRoute.isPresent()) {
            throw new RouteNotFoundException("The route does not exist for the mentioned Route Id =" + routeId);
        }
        Route route = optionalRoute.get();
        List<Integer> ids = customerRepository.findByRoute(route);
        List<Customer>customers=customerRepository.findAllById(ids);
        return customers;
    }


    void validateCustomer(Customer customer) {
        if (customer == null) {
            throw new InvalidCustomerException("Customer can't be null or empty");
        }
        validateCustomerAddress(customer.getAddress());
        validateCustomerName(customer.getCustomerName());
    }

    void validateCustomerAddress(String address) {
        if (address == null || address.isEmpty() || address.trim().isEmpty()) {

            throw new InvalidCustomerAddressException("CustomerAddress can't be null or empty");
        }

    }

    void validateCustomerName(String customerName) {
        if (customerName == null || customerName.isEmpty() || customerName.trim().isEmpty()) {

            throw new InvalidCustomerNameException("CustomerName can't be null or empty");
        }
    }


}
