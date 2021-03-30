package com.cg.tms.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.tms.dto.AddFeedbackRequest;
import com.cg.tms.dto.FeedbackDetails;
import com.cg.tms.entities.Feedback;
import com.cg.tms.service.IFeedbackService;
import com.cg.tms.util.FeedbackUtil;

@RequestMapping("/feedback")
@RestController
public class FeedbackRestController {
	@Autowired
	private IFeedbackService service;
	@Autowired
	private FeedbackUtil util;

	@PostMapping("/add")
	public FeedbackDetails addFeedback(@RequestBody AddFeedbackRequest requestData) {
		Feedback feedback = new Feedback();

		feedback.setFeedbackId(requestData.getFeedbackId());
		feedback.setCustomer(requestData.getCustomer());
		feedback.setFeedback(requestData.getFeedback());
		feedback.setRating(requestData.getrating());

		Feedback added = service.addFeedback(feedback);
		FeedbackDetails details = util.toFeedbackDetail(added);
		return details;
	}

	@GetMapping("/byid/{id}")
	public FeedbackDetails findbyFeedback(@PathVariable("id") int id) {
		Feedback feedback = service.viewAllFeedbacks(id);
		FeedbackDetails fetched = util.toFeedbackDetail(feedback);
		return fetched;
	}

	@GetMapping
	public List<FeedbackDetails> allFeedback() {
		List<Feedback> viewing = service.viewAllFeedbacks();
		List<FeedbackDetails> view = util.toFeedbackDetail(viewing);
		return view;
	}
}
