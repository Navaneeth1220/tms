package com.cg.tms.controllers;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Min;

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
	private PackageUtil packageUtil;

	@GetMapping(value = "/byid/{id}")
	public PackageDetails fetchPackage(@PathVariable("id") @Min(1) int packageId) {
		LOG.debug("packageId in fetchpackage in PackageRestController " + packageId);
		Package pack = packageService.searchPackage(packageId);
		PackageDetails packageDetails = packageUtil.toDetailPackage(pack);
		return packageDetails;
	}

	@GetMapping
	public List<PackageDetails> allPackages() {

		List<Package> packs = packageService.viewAllPackages();
		List<PackageDetails> packageDetails = packageUtil.toDetailsPackages(packs);
		return packageDetails;
	}

	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("/add")
	public PackageDetails addPackage(@RequestBody @Valid CreatePackageRequest requestData) {

		Package pack = new Package();
		Hotel hotel = new Hotel();
		hotel.setHotelName(requestData.getHotelName());
		hotel.setHotelDescription(requestData.getHotelDescription());
		hotel.setHotelType(requestData.getHotelType());
		hotel.setAddress(requestData.getAddress());
		hotel.setRent(requestData.getRent());
		hotel.setStatus(requestData.getHotelStatus());

		pack.setPackageName(requestData.getPackageName());
		pack.setPackageDescription(requestData.getPackageDescription());
		pack.setPackageType(requestData.getPackageType());
		pack.setPackageCost(requestData.getPackageCost());
		pack.setHotel(hotel);

		Package added = packageService.addPackage(pack);
		PackageDetails response = packageUtil.toDetailPackage(added);
		return response;
	}

	@DeleteMapping("/delete")
	public String deletePackage(@RequestBody @Valid DeletePackageRequest requestData) {

		packageService.deletePackage(requestData.getPackageId());
		return "package deleted for packageId=" + requestData.getPackageId();
	}

}
