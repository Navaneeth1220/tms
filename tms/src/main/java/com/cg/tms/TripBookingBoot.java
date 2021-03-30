package com.cg.tms;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.cg.tms.manualTesting.RouteUI;

@SpringBootApplication
public class TripBookingBoot {

	private static final Logger Log = LoggerFactory.getLogger(TripBookingBoot.class);

	public static void main(String args[]) {

		ConfigurableApplicationContext context = SpringApplication.run(TripBookingBoot.class, args);
		RouteUI routeUI = context.getBean(RouteUI.class);
		routeUI.start();

	}
}