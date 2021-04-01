package com.cg.tms.repository;

import java.util.List;

import com.cg.tms.entities.Route;
import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.tms.entities.Customer;
import com.cg.tms.exceptions.CustomerNotFoundException;
import com.cg.tms.exceptions.PackageNotFoundException;
import com.cg.tms.exceptions.RouteNotFoundException;
import com.cg.tms.entities.Package;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ICustomerRepository extends JpaRepository<Customer, Integer> {
   @Query("select booking.userId from Booking booking join booking.ticket tick  where tick.route=:route")
    List<Integer> findByRoute(@Param("route")Route route);

    @Query("select booking.userId from Booking booking where pack=:pack")
    List<Integer> findByPack(@Param("pack")Package pack);



}
