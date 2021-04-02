package com.cg.tms.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Component;

import com.cg.tms.dto.TravelsDetails;
import com.cg.tms.entities.Travels;

@Component
public class TravelsUtil {

	public TravelsDetails toTravelsDetail(Travels travel) {
		TravelsDetails travelsDetails = new TravelsDetails();
		travelsDetails.setTravelsId(travel.getTravelsId());
		travelsDetails.setTravelsName(travel.getTravelsName());
		travelsDetails.setAgentName(travel.getAgentName());
		travelsDetails.setAddress(travel.getAddress());
		travelsDetails.setContact(travel.getContact());

		return travelsDetails;
	}

	public List<TravelsDetails> toTravelsDetails(Collection<Travels> travels) {
		List<TravelsDetails> desired = new ArrayList<>();
		for (Travels travel : travels) {

			TravelsDetails travelDetails = toTravelsDetail(travel);
			desired.add(travelDetails);
		}

		return desired;

	}

}