package com.cg.tms.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.cg.tms.dto.CreateRouteRequest;
import org.springframework.stereotype.Component;

import com.cg.tms.dto.RouteDetails;
import com.cg.tms.dto.BusDetails;
import com.cg.tms.entities.Bus;
import com.cg.tms.entities.Route;

@Component
public class RouteUtil {

	public Route toRouteEntity(CreateRouteRequest request){
		Route route = new Route();
		route.setRouteFrom(request.getRouteFrom());
		route.setRouteTo(request.getRouteTo());
		route.setPickupPoint(request.getPickupPoint());
		route.setFare(request.getFare());
        return route;
	}

	public RouteDetails toRouteDetails(Route route) {
		RouteDetails details = new RouteDetails();
		details.setRouteId(route.getRouteId());
		details.setRouteFrom(route.getRouteFrom());
		details.setRouteTo(route.getRouteTo());
		details.setPickupPoint(route.getPickupPoint());
		details.setFare(route.getFare());
		return details;
	}

	public List<RouteDetails> toRouteDetails(Collection<Route> routes) {

		List<RouteDetails> routeList = new ArrayList<>();
		for (Route route : routes) {

			RouteDetails routeDetails = toRouteDetails(route);
			routeList.add(routeDetails);
		}

		return routeList;

	}

	public List<BusDetails> getBusList(List<Bus> buses) {
		List<BusDetails> busList = new ArrayList<>();
		for (Bus bus : buses) {
			BusDetails getBus = new BusDetails();
			getBus.setId(bus.getBusId());
			getBus.setBusNumber(bus.getBusNumber());
			getBus.setCapacity(bus.getCapacity());
			busList.add(getBus);
		}
		return busList;
	}

}
