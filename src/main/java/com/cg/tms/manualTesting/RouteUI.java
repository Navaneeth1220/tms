package com.cg.tms.manualTesting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.tms.entities.Bus;
import com.cg.tms.entities.Route;
import com.cg.tms.service.IBusService;
import com.cg.tms.service.IRouteService;

@Component
public class RouteUI {

	@Autowired
	private IRouteService service;
	@Autowired
	private IBusService busService;

	public void start() {
		Route route1 = new Route();
		Bus bus1 = new Bus();
		Bus bus2 = new Bus();

		route1.setRouteFrom("Jaipur");
		route1.setRouteTo("Delhi");
		route1.setFare(600);

		bus1.setBusType("AC");
		bus1.setBusNumber("B1");
		bus1.setCapacity(15);
		bus1 = busService.addBus(bus1);

		bus2.setBusType("AC/Seater");
		bus2.setBusNumber("B2");
		bus2.setCapacity(20);
		bus2 = busService.addBus(bus2);

		List<Bus> busList1 = new ArrayList<>();
		busList1.add(bus1);
		busList1.add(bus2);
		route1.setBuses(busList1);

		Route route2 = new Route();
		route2.setRouteFrom("Delhi");
		route2.setRouteTo("Himachal");
		route2.setFare(600);

		route1 = service.addRoute(route1);
		route2 = service.addRoute(route2);
		display(route1);
		display(route2);

		
		route1.setRouteFrom("Jaipur");
		route1.setRouteTo("Himachal");
		route1.setFare(1200);
		route1 = service.updateRoute(route1);
		display(route1);

		
		List<Route> list = new ArrayList<>();
		list.add(route1);
		list.add(route2);
		list = service.viewRouteList();
		System.out.println(Arrays.toString(list.toArray()));
	}

	public void display(Route route) {
		System.out.println("Route Id = " + route.getRouteId());
		System.out.println("Route From = " + route.getRouteFrom());
		System.out.println("Route To = " + route.getRouteTo());
		System.out.println("Route Fare = " + route.getFare());

	}

}
