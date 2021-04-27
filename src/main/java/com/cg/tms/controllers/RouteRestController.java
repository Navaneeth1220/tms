package com.cg.tms.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.tms.dto.CreateRouteRequest;
import com.cg.tms.dto.DeleteRouteRequest;
import com.cg.tms.dto.RouteDetails;
import com.cg.tms.dto.UpdateRouteReq;
import com.cg.tms.dto.toGetBusRequest;
import com.cg.tms.entities.Route;
import com.cg.tms.service.IRouteService;
import com.cg.tms.util.RouteUtil;

@Validated
@RequestMapping("/routes")
@RestController
public class RouteRestController {

	@Autowired
	private IRouteService routeService;
	@Autowired
	private RouteUtil routeUtil;

	@PostMapping("/add")
	public RouteDetails addRoute(@RequestBody @Valid CreateRouteRequest requestData) {
		Route route = new Route();
		route.setRouteFrom(requestData.getRouteFrom());
		route.setRouteTo(requestData.getRouteTo());
		route.setPickupPoint(requestData.getPickupPoint());
		route.setFare(requestData.getFare());
		Route savedRoute = routeService.addRoute(route);
		RouteDetails details = routeUtil.toRouteDetails(savedRoute);
		return details;
	}

	@GetMapping(value = "/byid/{id}")
	public RouteDetails fetchRoute(@PathVariable("id") String routeId) {

		Route route = routeService.searchRoute(routeId);
		RouteDetails routeDetails = routeUtil.toRouteDetails(route);
		return routeDetails;
	}

	@GetMapping
	public List<RouteDetails> allRoutes() {
		List<Route> routes = routeService.viewRouteList();
		List<RouteDetails> routeList = routeUtil.toRouteDetails(routes);
		return routeList;
	}

	@DeleteMapping("/deleteRoute")
	public void deleteRoute(@RequestBody @Valid DeleteRouteRequest requestData) {

		routeService.removeRoute(requestData.getId());

	}

	@GetMapping(value = "/getBus/{id}")
	public List<toGetBusRequest> getBus(@PathVariable("id") String routeId) {

		Route route = routeService.searchRoute(routeId);
		List<toGetBusRequest> busList = routeUtil.getBusList(route.getBuses());
		return busList;
	}

	@PutMapping("/update/route/{routeId}")
	public RouteDetails toUpdateRoute(@RequestBody @Valid UpdateRouteReq requestData,
			@PathVariable("routeId") String routeId) {
		Route route = routeService.searchRoute(routeId);
		route.setRouteFrom(requestData.getRouteFrom());
		route.setRouteTo(requestData.getRouteTo());
		route.setPickupPoint(requestData.getPickupPoint());
		route.setFare(requestData.getFare());
		Route savedRoute = routeService.updateRoute(route);
		RouteDetails details = routeUtil.toRouteDetails(savedRoute);
		return details;
	}
}
