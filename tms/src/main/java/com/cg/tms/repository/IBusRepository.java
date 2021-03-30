package com.cg.tms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.tms.entities.Bus;

public interface IBusRepository extends JpaRepository<Bus, Integer> {

}
