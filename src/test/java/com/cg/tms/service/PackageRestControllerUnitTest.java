package com.cg.tms.service;

import org.junit.jupiter.api.extension.ExtendWith;
import com.cg.tms.util.*;
import com.cg.tms.controllers.*;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import com.cg.tms.entities.Package;
import org.junit.jupiter.api.Assertions;
import com.cg.tms.dto.*;

@ExtendWith(MockitoExtension.class)
public class PackageRestControllerUnitTest {

	@Mock
	IPackageService packageService;

	@Mock
	PackageUtil packageUtil;

	@Spy
	@InjectMocks
	PackageRestController packageController;

	@Test
	public void testFetchPackage_1() {

		int packageId = 2;
		Package pack = mock(Package.class);
		PackageDetails packageDetails = mock(PackageDetails.class);
		when(packageService.searchPackage(packageId)).thenReturn(pack);
		when(packageUtil.toDetailPackage(pack)).thenReturn(packageDetails);
		PackageDetails result = packageController.fetchPackage(packageId);
		Assertions.assertSame(packageDetails, result);
		verify(packageService).searchPackage(packageId);
		verify(packageUtil).toDetailPackage(pack);

	}

	@Test
	public void testAddPackage_1() {

		String packageName = "Omega";
		String packageDescription = "ultimate experience";
		String packageType = "Mega";
		double packageCost = 14500.0;
		CreatePackageRequest request = new CreatePackageRequest();
		request.setPackageName(packageName);
		request.setPackageDescription(packageDescription);
		request.setPackageType(packageType);
		request.setPackageCost(packageCost);
		Package pack = mock(Package.class);
		when(packageService.addPackage(pack)).thenReturn(pack);
		PackageDetails packageDetails = mock(PackageDetails.class);
		when(packageUtil.toDetailPackage(pack)).thenReturn(packageDetails);
		PackageDetails result = packageController.addPackage(request);
		Assertions.assertSame(packageDetails, result);
		verify(packageService.addPackage(pack));

	}

}
