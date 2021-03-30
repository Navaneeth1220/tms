package com.cg.tms.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Component;

import com.cg.tms.dto.FeedbackDetails;
import com.cg.tms.entities.Feedback;

@Component
public class FeedbackUtil {

	public FeedbackDetails toFeedbackDetail(Feedback added) {
		FeedbackDetails feedbackDetails = new FeedbackDetails();
		feedbackDetails.setFeedbackId(added.getFeedbackId());
		feedbackDetails.setCustomer(added.getCustomer());
		feedbackDetails.setFeedback(added.getFeedback());
		feedbackDetails.setRating(added.getRating());
		return feedbackDetails;
	}

	public List<FeedbackDetails> toFeedbackDetail(Collection<Feedback> feedbacks) {
		List<FeedbackDetails> feedbacksall = new ArrayList<>();
		for (FeedbackDetails feedback : feedbacksall) {

			FeedbackDetails feedbackDetails = toFeedbackDetail(feedback);
			feedbacksall.add(feedbackDetails);
		}

		return feedbacksall;

	}
}
