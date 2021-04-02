package com.cg.tms.manualTesting;



import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.tms.entities.Travels;
import com.cg.tms.exceptions.TravelsNotFoundException;
import com.cg.tms.exceptions.InvalidTravelException;
import com.cg.tms.service.ITravelsService;

@Component
public class TravelImplManualTesting {
	
	@Autowired
	private ITravelsService service;
	
	public void start() {
		try {
			Travels travel= new Travels();
			travel.setTravelsId(1);
			travel.setTravelsName("abcd");
			travel.setAgentName("qwerty");
			travel.setContact("nir");
			
			Travels traveled=service.addTravels(travel);
			System.out.println("Traveled");
			display(traveled);	
			
			Travels travel1= new Travels();
			travel.setTravelsId(2);
			travel.setTravelsName("abcd");
			travel.setAgentName("qwerty");
			travel.setContact("nir");
			
			
			
			Travels traveled1=service.addTravels(travel1);
			display(travel1);
			
			System.out.println("Display all travels");
			List<Travels> travels=service.viewTravels();
			displayAll(travels);
			
			Travels fetched = service.searchTravels(travel.getTravelsId());
			System.out.println("Fetched travels");
			display(fetched);
			
			Travels removedTravels = service.removeTravels(travel1.getTravelsId());
			System.out.println("Deleted travels");
			display(removedTravels);
			
			
		}
		catch(TravelsNotFoundException e) {
			System.out.println("Travel not found");
		}
		
		catch(InvalidTravelException e) {
			System.out.println("Travel exception");

		}
	}

	 void display(Travels travels) {
		System.out.println(travels.getTravelsId()+" "+travels.getTravelsName()+" "+travels.getAgentName()
							+" "+travels.getContact());
		
	}
	 
	 void displayAll(Collection<Travels> travels) {
		 for(Travels travel : travels) {
			 display(travel);
		 }
	 }
}