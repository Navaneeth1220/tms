package com.cg.tms;



import com.cg.tms.manualTesting.BookingServiceImplManualTesting;
import com.cg.tms.manualTesting.PackageImplManualTesting;


import com.cg.tms.manualTesting.CustomerServiceManualTesting;
import com.cg.tms.manualTesting.FeedbackImplManualTesting;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class TripBookingBoot {

	private static final Logger Log = LoggerFactory.getLogger(TripBookingBoot.class);

	public static void main(String args[]) {

		ConfigurableApplicationContext context = SpringApplication.run(TripBookingBoot.class, args);
		BookingServiceImplManualTesting book = context.getBean(BookingServiceImplManualTesting.class);
		book.start();
		PackageImplManualTesting packageUI = context.getBean(PackageImplManualTesting.class);
		packageUI.start();
		FeedbackImplManualTesting feedbackUI=context.getBean(FeedbackImplManualTesting.class);
		feedbackUI.start();

		Log.debug("i am logged using debug level");
		/*PackageUI packageUI = context.getBean(PackageUI.class);
		packageUI.start();
*/
		CustomerServiceManualTesting customerserviceManualTesting =context.getBean(CustomerServiceManualTesting.class);
		customerserviceManualTesting.start();
	/*	Log.debug("i am logged using debug level");
		Log.info("i am logged using info level");
		Log.error("i am logged using error level");
		*/
	}
}