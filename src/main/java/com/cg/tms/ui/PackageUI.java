package com.cg.tms.ui;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.cg.tms.service.*;
import com.cg.tms.exceptions.*;
import com.cg.tms.entities.*;
import com.cg.tms.entities.Package;

@Component
public class PackageUI {

	@Autowired
	private IPackageService packageService;

	public void start() {

		try {

			/*
			 * Creating Package: pack1 object
			 * 
			 * */

			System.out.println();
			System.out.println("Adding a new Package: ");
			Package pack1 = new Package();
			pack1.setPackageName("Local");
			pack1.setPackageDescription("diverse and cultural");
			pack1.setPackageType("Normal");
			pack1.setPackageCost(8500.0);

			/*
			 * Creating Hotel: hotel1 object
			 * 
			 * */
			Hotel hotel1 = new Hotel();
			hotel1.setHotelId(177);
			hotel1.setHotelName("Guhantara");
			hotel1.setHotelDescription("Authentic and relaxing");
			hotel1.setHotelType("Three star");
			hotel1.setAddress(
					"Sy. No. 177 & 177/18, Nowkal Palya, Kaggalipura, Off Kanakapura Main Road, South, Taluk, Bengaluru, Karnataka 560082");
			hotel1.setRent(4720.0);
			hotel1.setStatus("Good");

			/*
			 * Creating TicketDetails: ticket1 object
			 * 
			 * */
			TicketDetails ticket1 = new TicketDetails();
			ticket1.setTicketId("401254");
			ticket1.setRoute(null);
			ticket1.setStatus("Processing");

			/*
			 * Creating PaymentDetails: payment1 object
			 * 
			 * */
			PaymentDetails payment1 = new PaymentDetails();
			payment1.setPaymentId(4012);
			payment1.setPaymentMode("Debit");
			payment1.setBankName("SBI");
			payment1.setCardNo(1234567891);
			payment1.setNetAmount(1000000.0);
			payment1.setPaymentStatus("Tranaction Complete");
			payment1.setUserId(21);

			/*
			 * Adding a package: addPackage1 to the repository
			 * 
			 * */
			
			Package addPackage1 = packageService.addPackage(pack1);
			displayPackage(addPackage1);
			displayHotel(hotel1);
			displayTicketDetails(ticket1);
			displayPaymentDetails(payment1);

			/*
			 * Creating Package: pack2 object
			 * 
			 * */
			Package pack2 = new Package();
			pack2.setPackageName("National");
			pack2.setPackageDescription("challenging adventure");
			pack2.setPackageType("Ultra");
			pack2.setPackageCost(10500.0);

			/*
			 * Creating Hotel: hotel2 object
			 * 
			 * */
			Hotel hotel2 = new Hotel();
			hotel2.setHotelId(277);
			hotel2.setHotelName("Leela Palace");
			hotel2.setHotelDescription("Luxurious and sparkling");
			hotel2.setHotelType("Four star");
			hotel2.setAddress(
					"23, Old Airport Road, Opp. Manipal Hospital, HAL 3rd Stage, Kodihalli, 560008, Bengaluru, India");
			hotel2.setRent(5720.0);
			hotel2.setStatus("Very good");


			/*
			 * Creating TicketDetails: ticket2 object
			 * 
			 * */
			TicketDetails ticket2 = new TicketDetails();
			ticket2.setTicketId("401255");
			ticket2.setRoute(null);
			ticket2.setStatus("Processing");

			/*
			 * Creating PaymentDetails: payment2 object
			 * 
			 * */
			PaymentDetails payment2 = new PaymentDetails();
			payment2.setPaymentId(4013);
			payment2.setPaymentMode("Credit");
			payment2.setBankName("HDFC");
			payment2.setCardNo(721546812);
			payment2.setNetAmount(2000000.0);
			payment2.setPaymentStatus("Tranaction Processing");
			payment2.setUserId(22);

			/*
			 * Adding a package: addPackage2 to the repository
			 * 
			 * */
			
			Package addPackage2 = packageService.addPackage(pack2);
			displayPackage(addPackage2);
			displayHotel(hotel2);
			displayTicketDetails(ticket2);
			displayPaymentDetails(payment2);

			/*
			 * Creating Package: pack3 object
			 * 
			 * */
			Package pack3 = new Package();
			pack3.setPackageName("Holiday");
			pack3.setPackageDescription("peace and relaxation");
			pack3.setPackageType("Deluxe");
			pack3.setPackageCost(12500.0);

			/*
			 * Creating Hotel: hotel3 object
			 * 
			 * */
			Hotel hotel3 = new Hotel();
			hotel3.setHotelId(377);
			hotel3.setHotelName("Taj Holiday");
			hotel3.setHotelDescription("Lively and Charming");
			hotel3.setHotelType("Five star");
			hotel3.setAddress("Fort Aguada Road, Sinquerim 403 515 India");
			hotel3.setRent(6720.0);
			hotel3.setStatus("Excellent");


			/*
			 * Creating TicketDetails: ticket3 object
			 * 
			 * */
			TicketDetails ticket3 = new TicketDetails();
			ticket3.setTicketId("401256");
			ticket3.setRoute(null);
			ticket3.setStatus("Processing");

			/*
			 * Creating PaymentDetails: payment3 object
			 * 
			 * */
			PaymentDetails payment3 = new PaymentDetails();
			payment3.setPaymentId(4012);
			payment3.setPaymentMode("NetBanking");
			payment3.setBankName("ICICI");
			payment3.setCardNo(423456781);
			payment3.setNetAmount(3000000.0);
			payment3.setPaymentStatus("Tranaction Failed");
			payment3.setUserId(27);

			/*
			 * Adding a package: addPackage3 to the repository
			 * 
			 * */
			
			Package addPackage3 = packageService.addPackage(pack3);
			displayPackage(addPackage3);
			displayHotel(hotel3);
			displayTicketDetails(ticket3);
			displayPaymentDetails(payment3);

			/*
			 * Deleting a package: deletePackage by passing packageId
			 * 
			 * */
			System.out.println();
			System.out.println("Deleting a package: ");
			Package deletePackage = packageService.deletePackage(pack3.getPackageId());
			displayPackage(deletePackage);

			/*
			 * Searching a package: searchPackage by passing packageId
			 * 
			 * */
			System.out.println();
			System.out.println("Searching a package: ");
			Package searchPackage = packageService.searchPackage(pack1.getPackageId());
			displayPackage(searchPackage);

			/*
			 * Viewing all packages
			 * 
			 * */
			System.out.println();
			System.out.println("Viewing all packages: ");
			List<Package> viewAllPackages = packageService.viewAllPackages();
			displayAllPackages(viewAllPackages);

		} catch (PackageNotFoundException e) {

			System.out.println("Package not found");
			e.printStackTrace();

		} catch (InvalidPackageIdException e) {

			System.out.println(e.getMessage());
			e.printStackTrace();

		} catch (InvalidPackageNameException e) {

			System.out.println(e.getMessage());
			e.printStackTrace();

		} catch (InvalidPackageDescriptionException e) {

			System.out.println(e.getMessage());
			e.printStackTrace();

		} catch (InvalidPackageTypeException e) {

			System.out.println(e.getMessage());
			e.printStackTrace();

		} catch (Exception e) {

			System.out.println("Parent exception");
			e.printStackTrace();
		}

	}

	/*
	 * Displaying a Package 
	 * 
	 * */
	public void displayPackage(Package pack) {

		System.out.println();
		System.out.println("packageId: " + pack.getPackageId() + " packageName: " + pack.getPackageName()
				+ " packageDescription: " + pack.getPackageDescription() + " packageType: " + pack.getPackageType()
				+ " packageCost: " + pack.getPackageCost());

	}

	/*
	 * Displaying a Hotel 
	 * 
	 * */
	public void displayHotel(Hotel hotel) {

		System.out.println(
				"hotelId: " + hotel.getHotelId() + " hotelName: " + hotel.getHotelName() + " hotelDescription: "
						+ hotel.getHotelDescription() + " hotelType: " + hotel.getHotelType() + " hotelAddress: "
						+ hotel.getAddress() + " hotelRent: " + hotel.getRent() + " hotelStatus: " + hotel.getStatus());
	}

	/*
	 * Displaying a TicketDetail
	 * 
	 * */
	public void displayTicketDetails(TicketDetails ticket) {

		System.out.println("ticketId: " + ticket.getTicketId() + " route: " + ticket.getRoute() + " ticketStatus: "
				+ ticket.getStatus());
	}

	/*
	 * Displaying a PaymentDetail
	 * 
	 * */
	public void displayPaymentDetails(PaymentDetails payment) {

		System.out.println("paymentId: " + payment.getPaymentId() + " paymentMode: " + payment.getPaymentMode()
				+ " paymentBankName: " + payment.getBankName() + " paymentCardNumber: " + payment.getCardNo()
				+ " paymentNetAmount: " + payment.getNetAmount() + " paymentStatus: " + payment.getPaymentStatus()
				+ " paymentUserId: " + payment.getUserId());

	}

	/*
	 * Displaying all Packages
	 * 
	 * */
	public void displayAllPackages(Collection<Package> packs) {

		for (Package pack : packs) {

			displayPackage(pack);
		}
	}

	/*
	 * Displaying all Hotels
	 * 
	 * */
	public void displayAllHotels(Collection<Hotel> hotels) {

		for (Hotel hotel : hotels) {

			displayHotel(hotel);
		}
	}

	/*
	 * Displaying all TicketDetails
	 * 
	 * */
	public void displayAllTicketDetails(Collection<TicketDetails> tickets) {

		for (TicketDetails ticket : tickets) {

			displayTicketDetails(ticket);
		}
	}

	/*
	 * Displaying all PaymentDetails
	 * 
	 * */
	public void displayAllPaymentDetails(Collection<PaymentDetails> payments) {

		for (PaymentDetails payment : payments) {

			displayPaymentDetails(payment);
		}

	}

}
