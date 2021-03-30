package com.cg.tms.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.tms.service.ICustomerService;

@RequestMapping("/customers")
@RestController
public class CustomerRestController {


	@Autowired
	private ICustomerService Service;
}
