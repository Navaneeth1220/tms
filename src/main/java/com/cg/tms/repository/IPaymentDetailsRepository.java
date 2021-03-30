package com.cg.tms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.tms.entities.PaymentDetails;

public interface IPaymentDetailsRepository extends JpaRepository<PaymentDetails, Integer> {

}
