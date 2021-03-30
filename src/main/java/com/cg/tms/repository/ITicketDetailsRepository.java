package com.cg.tms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.tms.entities.TicketDetails;

public interface ITicketDetailsRepository extends JpaRepository<TicketDetails,String>{

}
