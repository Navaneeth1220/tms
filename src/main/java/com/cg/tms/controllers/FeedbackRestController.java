package com.cg.tms.controllers;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Min;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.tms.dto.AddFeedbackRequest;
import com.cg.tms.dto.FeedbackDetails;
import com.cg.tms.entities.Customer;
import com.cg.tms.entities.Feedback;
import com.cg.tms.service.ICustomerService;
import com.cg.tms.service.IFeedbackService;
import com.cg.tms.util.FeedbackUtil;

@Validated
@RequestMapping("/feedbacks")
@RestController
public class FeedbackRestController {
    @Autowired
    private IFeedbackService feedbackService;

    @Autowired
    private ICustomerService customerService;

    @Autowired
    private FeedbackUtil util;


    @PostMapping("/add")
    public FeedbackDetails addFeedback(@RequestBody @Valid AddFeedbackRequest requestData) {
        Feedback feedback = new Feedback();
        Customer customer = customerService.viewCustomer(requestData.getCustomerId());
        feedback.setCustomer(customer);
        feedback.setFeedback(requestData.getFeedback());
        feedback.setRating(requestData.getRating());

        Feedback added = feedbackService.addFeedback(feedback);
        FeedbackDetails details = util.toFeedbackDetail(added);
        return details;
    }

    @GetMapping("/byid/{id}")
    public FeedbackDetails getFeedbackById(@PathVariable("id") @Min(1)int id) {
        Feedback feedback = feedbackService.findByFeedbackId(id);
        FeedbackDetails fetched = util.toFeedbackDetail(feedback);
        return fetched;
    }

    @GetMapping("/customer/{cid}")
    public FeedbackDetails getByCustomer(@PathVariable("cid") @Min(1)int cid) {
        Feedback feedback = feedbackService.findByCustomerId(cid);
        FeedbackDetails details = util.toFeedbackDetail(feedback);
        return details;
    }

    @GetMapping
    public List<FeedbackDetails> allFeedback() {
        List<Feedback> viewing = feedbackService.viewAllFeedbacks();
        List<FeedbackDetails> view = util.toFeedbackDetail(viewing);
        return view;
    }
}
