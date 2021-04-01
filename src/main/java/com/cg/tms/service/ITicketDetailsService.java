package com.cg.tms.service;

import com.cg.tms.entities.TicketDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITicketDetailsService {

    TicketDetails add(String routeId, String status);


}
