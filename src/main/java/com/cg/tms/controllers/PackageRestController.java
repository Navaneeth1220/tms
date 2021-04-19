package com.cg.tms.controllers;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Min;

import com.cg.tms.service.IHotelService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cg.tms.dto.CreatePackageRequest;
import com.cg.tms.dto.DeletePackageRequest;
import com.cg.tms.dto.PackageDetails;
import com.cg.tms.entities.Hotel;
import com.cg.tms.entities.Package;
import com.cg.tms.service.IPackageService;
import com.cg.tms.util.PackageUtil;

@Validated
@RequestMapping("/packages")
@RestController
public class PackageRestController {

	private static final Logger LOG = LoggerFactory.getLogger(PackageRestController.class);

	@Autowired
	private IPackageService packageService;

	@Autowired
	private IHotelService hotelService;

	@Autowired
	private PackageUtil packageUtil;

	/**
	 * method to view package fetched by the given packageId
	 * 
	 * @param packageId of the booking made
	 * @return package details of the given packaged
	 */
	@GetMapping(value = "/byid/{id}")
	public PackageDetails fetchPackage(@PathVariable("id") @Min(1) int packageId) {
		LOG.debug("packageId in fetchpackage in PackageRestController " + packageId);
		Package pack = packageService.searchPackage(packageId);
		PackageDetails packageDetails = packageUtil.toDetailPackage(pack);
		return packageDetails;
	}

	/**
	 * method to view details of all the packages made
	 * 
	 * @return details of all the packages made
	 */

	@GetMapping
	public List<PackageDetails> allPackages() {
		List<Package> packs = packageService.viewAllPackages();
		List<PackageDetails> packageDetails = packageUtil.toDetailsPackages(packs);
		return packageDetails;
	}

	/**
	 * method to make a new package
	 * 
	 * @param requestData
	 * @return details of the new package made
	 */
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("/add")
	public PackageDetails addPackage(@RequestBody @Valid CreatePackageRequest requestData) {
		Package pack = new Package();
		Hotel hotel = 	hotelService.findById(requestData.getHotelId());
		pack.setPackageName(requestData.getPackageName());
		pack.setPackageDescription(requestData.getPackageDescription());
		pack.setPackageType(requestData.getPackageType());
		pack.setPackageCost(requestData.getPackageCost());
		pack.setHotel(hotel);
		Package added = packageService.addPackage(pack);
		PackageDetails response = packageUtil.toDetailPackage(added);
		return response;
	}

	/**
	 * method to delete a existing package, delete is done by providing packageId
	 * 
	 * @param requestData
	 */
	@DeleteMapping("/delete")
	public String deletePackage(@RequestBody @Valid DeletePackageRequest requestData) {

		packageService.deletePackage(requestData.getPackageId());
		return "package deleted for packageId=" + requestData.getPackageId();
	}

}
