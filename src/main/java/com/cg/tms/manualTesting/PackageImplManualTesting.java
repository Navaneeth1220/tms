package com.cg.tms.manualTesting;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.tms.entities.Hotel;
import com.cg.tms.entities.Package;
import com.cg.tms.exceptions.InvalidPackageDescriptionException;
import com.cg.tms.exceptions.InvalidPackageIdException;
import com.cg.tms.exceptions.InvalidPackageNameException;
import com.cg.tms.exceptions.InvalidPackageTypeException;
import com.cg.tms.exceptions.PackageNotFoundException;
import com.cg.tms.service.IHotelService;
import com.cg.tms.service.IPackageService;

@Component
public class PackageImplManualTesting {

	@Autowired
	private IPackageService packageService;

	@Autowired
	private IHotelService hotelService;

	public void start() {

		try {

			System.out.println();
			System.out.println("Adding a new Package: ");

			Hotel hotel1 = new Hotel();
			hotel1.setHotelName("Guhantara");
			hotel1.setHotelDescription("Authentic and relaxing");
			hotel1.setHotelType("Three star");
			hotel1.setAddress(
					"Sy. No. 177 & 177/18, Nowkal Palya, Kaggalipura, Off Kanakapura Main Road, South, Taluk, Bengaluru, Karnataka 560082");
			hotel1.setRent(4720.0);
			hotel1.setStatus("Good");

			Hotel addHotel1 = hotelService.addHotel(hotel1);

			Package pack1 = new Package();
			pack1.setPackageName("Local");
			pack1.setPackageDescription("diverse and cultural");
			pack1.setPackageType("Normal");
			pack1.setPackageCost(8500.0);
			pack1.setHotel(addHotel1);

			Package addPackage1 = packageService.addPackage(pack1);
			displayPackage(addPackage1);

			Hotel hotel2 = new Hotel();
			hotel2.setHotelName("Leela Palace");
			hotel2.setHotelDescription("Luxurious and sparkling");
			hotel2.setHotelType("Four star");
			hotel2.setAddress(
					"23, Old Airport Road, Opp. Manipal Hospital, HAL 3rd Stage, Kodihalli, 560008, Bengaluru, India");
			hotel2.setRent(5720.0);
			hotel2.setStatus("Very good");
			
			Hotel addHotel2 = hotelService.addHotel(hotel2);


			Package pack2 = new Package();
			pack2.setPackageName("National");
			pack2.setPackageDescription("challenging adventure");
			pack2.setPackageType("Ultra");
			pack2.setPackageCost(10500.0);
			pack2.setHotel(addHotel2);

			Package addPackage2 = packageService.addPackage(pack2);
			displayPackage(addPackage2);

			Hotel hotel3 = new Hotel();
			hotel3.setHotelName("Taj Holiday");
			hotel3.setHotelDescription("Lively and Charming");
			hotel3.setHotelType("Five star");
			hotel3.setAddress("Fort Aguada Road, Sinquerim 403 515 India");
			hotel3.setRent(6720.0);
			hotel3.setStatus("Excellent");
			
			Hotel addHotel3 = hotelService.addHotel(hotel3);


			Package pack3 = new Package();
			pack3.setPackageName("Holiday");
			pack3.setPackageDescription("peace and relaxation");
			pack3.setPackageType("Deluxe");
			pack3.setPackageCost(12500.0);
			pack3.setHotel(addHotel3);

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
				+ " HotelStatus: " + pack.getHotel().getStatus());

	}

	public void displayAllPackages(Collection<Package> packs) {

		for (Package pack : packs) {

			displayPackage(pack);
		}
	}

}
