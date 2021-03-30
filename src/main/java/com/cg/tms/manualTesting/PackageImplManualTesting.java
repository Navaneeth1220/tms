package com.cg.tms.manualTesting;

import java.util.*;
import com.cg.tms.manualTesting.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.cg.tms.service.*;
import com.cg.tms.exceptions.*;
import com.cg.tms.entities.*;
import com.cg.tms.entities.Package;

@Component
public class PackageImplManualTesting {

	@Autowired
	private IPackageService packageService;

	public void start() {

		try {

			System.out.println();
			System.out.println("Adding a new Package: ");

			Hotel hotel1 = new Hotel();
			hotel1.setHotelId(177);
			hotel1.setHotelName("Guhantara");
			hotel1.setHotelDescription("Authentic and relaxing");
			hotel1.setHotelType("Three star");
			hotel1.setAddress(
					"Sy. No. 177 & 177/18, Nowkal Palya, Kaggalipura, Off Kanakapura Main Road, South, Taluk, Bengaluru, Karnataka 560082");
			hotel1.setRent(4720.0);
			hotel1.setStatus("Good");

			TicketDetails ticket1 = new TicketDetails();
			ticket1.setTicketId("401254");
			ticket1.setStatus("Processing");

			PaymentDetails payment1 = new PaymentDetails();
			payment1.setPaymentId(4012);
			payment1.setPaymentMode("Debit");
			payment1.setBankName("SBI");
			payment1.setCardNo(1234567891);
			payment1.setNetAmount(1000000.0);
			payment1.setPaymentStatus("Tranaction Complete");
			payment1.setUserId(21);

			Package pack1 = new Package();
			pack1.setPackageName("Local");
			pack1.setPackageDescription("diverse and cultural");
			pack1.setPackageType("Normal");
			pack1.setPackageCost(8500.0);
			pack1.setHotel(hotel1);
			pack1.setTicket(ticket1);
			pack1.setPayment(payment1);

			Package addPackage1 = packageService.addPackage(pack1);
			displayPackage(addPackage1);

			Hotel hotel2 = new Hotel();
			hotel2.setHotelId(277);
			hotel2.setHotelName("Leela Palace");
			hotel2.setHotelDescription("Luxurious and sparkling");
			hotel2.setHotelType("Four star");
			hotel2.setAddress(
					"23, Old Airport Road, Opp. Manipal Hospital, HAL 3rd Stage, Kodihalli, 560008, Bengaluru, India");
			hotel2.setRent(5720.0);
			hotel2.setStatus("Very good");

			TicketDetails ticket2 = new TicketDetails();
			ticket2.setTicketId("401255");

			ticket2.setStatus("Processing");

			PaymentDetails payment2 = new PaymentDetails();
			payment2.setPaymentId(4013);
			payment2.setPaymentMode("Credit");
			payment2.setBankName("HDFC");
			payment2.setCardNo(721546812);
			payment2.setNetAmount(2000000.0);
			payment2.setPaymentStatus("Tranaction Processing");
			payment2.setUserId(22);

			Package pack2 = new Package();
			pack2.setPackageName("National");
			pack2.setPackageDescription("challenging adventure");
			pack2.setPackageType("Ultra");
			pack2.setPackageCost(10500.0);
			pack2.setHotel(hotel2);
			pack2.setTicket(ticket2);
			pack2.setPayment(payment2);

			Package addPackage2 = packageService.addPackage(pack2);
			displayPackage(addPackage2);

			Hotel hotel3 = new Hotel();
			hotel3.setHotelId(377);
			hotel3.setHotelName("Taj Holiday");
			hotel3.setHotelDescription("Lively and Charming");
			hotel3.setHotelType("Five star");
			hotel3.setAddress("Fort Aguada Road, Sinquerim 403 515 India");
			hotel3.setRent(6720.0);
			hotel3.setStatus("Excellent");

			TicketDetails ticket3 = new TicketDetails();
			ticket3.setTicketId("401256");
			ticket3.setStatus("Processing");

			PaymentDetails payment3 = new PaymentDetails();
			payment3.setPaymentId(4012);
			payment3.setPaymentMode("NetBanking");
			payment3.setBankName("ICICI");
			payment3.setCardNo(423456781);
			payment3.setNetAmount(3000000.0);
			payment3.setPaymentStatus("Tranaction Failed");
			payment3.setUserId(27);

			Package pack3 = new Package();
			pack3.setPackageName("Holiday");
			pack3.setPackageDescription("peace and relaxation");
			pack3.setPackageType("Deluxe");
			pack3.setPackageCost(12500.0);
			pack3.setHotel(hotel3);
			pack3.setTicket(ticket3);
			pack3.setPayment(payment3);

			Package addPackage3 = packageService.addPackage(pack3);
			displayPackage(addPackage3);

			System.out.println();
			System.out.println("Deleting a package: ");
			Package deletePackage = packageService.deletePackage(pack3.getPackageId());
			displayPackage(deletePackage);

			System.out.println();
			System.out.println("Searching a package: ");
			Package searchPackage = packageService.searchPackage(pack1.getPackageId());
			displayPackage(searchPackage);

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

	public void displayPackage(Package pack) {

		System.out.println();
		System.out.println("packageId: " + pack.getPackageId() + " packageName: " + pack.getPackageName()
				+ " packageDescription: " + pack.getPackageDescription() + " packageType: " + pack.getPackageType()
				+ " packageCost: " + pack.getPackageCost() + "\nHotelId: " + pack.getHotel().getHotelId()
				+ " HotelName: " + pack.getHotel().getHotelName() + " HotelDescription: "
				+ pack.getHotel().getHotelDescription() + " HotelType: " + pack.getHotel().getHotelType()
				+ " HotelAddress: " + pack.getHotel().getAddress() + " HotelRent: " + pack.getHotel().getRent()
				+ " HotelStatus: " + pack.getHotel().getStatus() + "\nTicketId: " + pack.getTicket().getTicketId()
				+ " TicketStatus: " + pack.getTicket().getStatus() + "\nPaymentId: " + pack.getPayment().getPaymentId()
				+ " PaymentMode: " + pack.getPayment().getPaymentMode() + " Payment BankName: "
				+ pack.getPayment().getBankName() + " Payment CardNumber: " + pack.getPayment().getCardNo()
				+ " Payment NetAmount: " + pack.getPayment().getNetAmount() + " PaymentStatus: "
				+ pack.getPayment().getPaymentStatus() + " Payment UserId: " + pack.getPayment().getUserId());

	}

	public void displayAllPackages(Collection<Package> packs) {

		for (Package pack : packs) {

			displayPackage(pack);
		}
	}

}
