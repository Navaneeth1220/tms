package com.cg.tms.controllers;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Min;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cg.tms.dto.AddTravels;
import com.cg.tms.dto.ChangeTravels;
import com.cg.tms.dto.RemoveTravels;
import com.cg.tms.dto.TravelsDetails;
import com.cg.tms.entities.Travels;
import com.cg.tms.service.ITravelsService;
import com.cg.tms.util.TravelsUtil;

@Validated
@RequestMapping("/travels")
@RestController
public class TravelsRestController {
	@Autowired
	private ITravelsService service;
	@Autowired
	private TravelsUtil util;

	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("/add")
	public TravelsDetails addTravels(@RequestBody @Valid AddTravels requestData) {
		Travels travel = new Travels();
		travel.setTravelsName(requestData.getTravelsName());
		travel.setAgentName(requestData.getAgentName());
		travel.setAddress(requestData.getAddress());
		travel.setContact(requestData.getContact());
		Travels added = service.addTravels(travel);
		TravelsDetails details = util.toTravelsDetail(added);
		return details;
	}

	@GetMapping(value = "/byid/{id}")
	public TravelsDetails fetchTravels(@PathVariable("id") @Min(1) int travelsId) {
		Travels travel = service.searchTravels(travelsId);
		TravelsDetails details = util.toTravelsDetail(travel);
		return details;
	}

	@GetMapping
	public List<TravelsDetails> allTravels() {
		List<Travels> viewing = service.viewTravels();
		List<TravelsDetails> view = util.toTravelsDetails(viewing);
		return view;
	}

	@PutMapping("/changename")
	public TravelsDetails changeTravelsName(@RequestBody @Valid ChangeTravels requestData,
			@PathVariable int travelsId) {
		Travels travels = service.searchTravels(travelsId);
		travels.setTravelsName(requestData.getTravelsName());
		travels.setAddress(requestData.getAddress());
		travels.setContact(requestData.getContact());
		Travels updatedTravels = service.updateTravels(travels);
		TravelsDetails details = util.toTravelsDetail(updatedTravels);
		return details;

	}

	@DeleteMapping("/delete")
	public void removeTravels(@RequestBody @Valid RemoveTravels requestData) {
		service.removeTravels(requestData.getTravelsId());
		// return travel delete for id "+requestData.getId();
	}

}
