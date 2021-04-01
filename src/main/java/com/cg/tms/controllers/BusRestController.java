package com.cg.tms.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.tms.dto.BusDetails;
import com.cg.tms.dto.CreateBusRequest;
import com.cg.tms.dto.toGetTravelsReq;
import com.cg.tms.entities.Bus;
import com.cg.tms.service.IBusService;
import com.cg.tms.util.BusUtil;

@Validated
@RequestMapping("/buses")
@RestController
public class BusRestController {

	@Autowired
	private IBusService busService;
	@Autowired
	private BusUtil busUtil;

	@PostMapping("/add")
	public BusDetails addBus(@RequestBody @Valid CreateBusRequest requestData) {
		Bus bus = new Bus();
		bus.setBusId(requestData.getBusId());
		bus.setBusType(requestData.getBusType());
		bus.setBusNumber(requestData.getBusNumber());
		bus.setCapacity(requestData.getCapacity());
		Bus savedBus = busService.addBus(bus);
		BusDetails details = busUtil.toBusDetails(savedBus);
		return details;
	}

	@GetMapping(value = "/byid/{id}")
	public BusDetails fetchPackage(@PathVariable("id") int busId) {
		Bus bus = busService.searchBus(busId);
		BusDetails busDetails = busUtil.toBusDetails(bus);
		return busDetails;
	}

	@GetMapping
	public List<BusDetails> allBuses() {
		List<Bus> buses = busService.viewBusList();
		List<BusDetails> busList = busUtil.toBusDetails(buses);
		return busList;
	}

	@GetMapping(value = "/getTravels/{id}")
	public toGetTravelsReq getTravel(@PathVariable("id") int busId) {
		Bus bus = busService.searchBus(busId);
		toGetTravelsReq travelReq = busUtil.toGetTravels(bus.getTravel());
		return travelReq;
	}
}
