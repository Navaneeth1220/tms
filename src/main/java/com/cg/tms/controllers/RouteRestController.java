package com.cg.tms.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.tms.dto.CreateRouteRequest;
import com.cg.tms.dto.DeleteRouteRequest;
import com.cg.tms.dto.RouteDetails;
import com.cg.tms.dto.BusDetails;
import com.cg.tms.entities.Route;
import com.cg.tms.service.IRouteService;
import com.cg.tms.util.RouteUtil;

@RequestMapping("/routes")
@RestController
public class RouteRestController {

	@Autowired
	private IRouteService routeService;
	@Autowired
	private RouteUtil routeUtil;

	@PostMapping("/add")
	public RouteDetails addRoute(@RequestBody CreateRouteRequest requestData) {
		Route route = routeUtil.toRouteEntity(requestData);
		Route savedRoute = routeService.addRoute(route);
		RouteDetails details = routeUtil.toRouteDetails(savedRoute);
		return details;
	}

	@GetMapping(value = "/byid/{id}")
	public RouteDetails fetchPackage(@PathVariable("id") String routeId) {
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
	public void deleteRoute(@RequestBody DeleteRouteRequest requestData) {
		routeService.removeRoute(requestData.getId());
	}

	@GetMapping(value = "/getBus/{id}")
	public List<BusDetails> getBus(@PathVariable("id") String routeId) {
		Route route = routeService.searchRoute(routeId);
		List<BusDetails> busList = routeUtil.getBusList(route.getBuses());
		return busList;
	}

}
