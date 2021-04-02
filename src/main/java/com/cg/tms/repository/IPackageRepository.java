package com.cg.tms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.tms.entities.Package;

public interface IPackageRepository extends JpaRepository<Package, Integer> {

	/*@Query("from Package where pack=:packArg")
	public Package addPackage(@Param("packArg") Package pack);

	@Query("from Package where packageId=:packageIdArg")
	public Package deletePackage(@Param("packageIdArg") int packageId) throws PackageNotFoundException;

	@Query("from Package where packageId=:packageIdArg")
	public Package searchPackage(@Param("packageIdArg") int packageId) throws PackageNotFoundException;

	@Query("from Package")
	public List<Package> viewAllPackages();
*/
}

