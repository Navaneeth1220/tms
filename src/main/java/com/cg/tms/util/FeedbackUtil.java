package com.cg.tms.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.cg.tms.entities.Customer;
import org.springframework.stereotype.Component;

import com.cg.tms.dto.FeedbackDetails;
import com.cg.tms.entities.Feedback;

@Component
public class FeedbackUtil {

    public FeedbackDetails toFeedbackDetail(Feedback feedback) {
        Customer customer = feedback.getCustomer();
        FeedbackDetails details = new FeedbackDetails();
        details.setFeedbackId(feedback.getFeedbackId());
        details.setCustomerId(customer.getCustomerId());
        details.setCustomerName(customer.getCustomerName());
        details.setFeedback(feedback.getFeedback());
        details.setRating(feedback.getRating());
        return details;
    }

    public List<FeedbackDetails> toFeedbackDetail(Collection<Feedback> feedbacks) {
        List<FeedbackDetails> desired = new ArrayList<>();
        for (Feedback feedback : feedbacks) {
            FeedbackDetails details = toFeedbackDetail(feedback);
            desired.add(details);
        }
        return desired;

    }
}
