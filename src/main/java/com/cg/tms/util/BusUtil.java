package com.cg.tms.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Component;

import com.cg.tms.dto.BusDetails;
import com.cg.tms.dto.toGetTravelsReq;
import com.cg.tms.entities.Bus;
import com.cg.tms.entities.Travels;

@Component
public class BusUtil {

	public BusDetails toBusDetails(Bus bus) {
		BusDetails details = new BusDetails();
		details.setBusId(bus.getBusId());
		details.setBusType(bus.getBusType());
		details.setBusNumber(bus.getBusNumber());
		details.setCapacity(bus.getCapacity());
		return details;
	}

	public List<BusDetails> toBusDetails(Collection<Bus> buses) {
		List<BusDetails> busList = new ArrayList<>();
		for (Bus bus : buses) {

			BusDetails busDetails = toBusDetails(bus);
			busList.add(busDetails);

		}
		return busList;
	}

	public toGetTravelsReq toGetTravels(Travels travel) {
		toGetTravelsReq travelReq = new toGetTravelsReq();
		travelReq.setTravelsId(travel.getTravelsId());
		travelReq.setTravelsName(travel.getTravelsName());
		travelReq.setAgentName(travel.getAgentName());
		travelReq.setAddress(travel.getAddress());
		travelReq.setContact(travel.getContact());
		return travelReq;
	}

}
