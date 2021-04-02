package com.cg.tms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cg.tms.entities.Customer;
import com.cg.tms.entities.Package;
import com.cg.tms.entities.Route;

public interface ICustomerRepository extends JpaRepository<Customer, Integer> {
   @Query("select booking.userId from Booking booking join booking.ticket tick  where tick.route=:route")
    List<Integer> findByRoute(@Param("route")Route route);

    @Query("select booking.userId from Booking booking where booking.pack=:pack")
    List<Integer> findByPack(@Param("pack")Package pack);



}
