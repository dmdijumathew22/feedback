package com.feedback.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.feedback.repository.entity.FeedbackEntity;
import com.feedback.repository.entity.FeedbackCrudRepo;

@RestController
@RequestMapping("feedback")
public class FeedbackController {
	
	@Autowired
	FeedbackCrudRepo repo;

	@PostMapping("/submit")
	public String save(FeedbackEntity feedbackEntity) {
		System.out.println("here "+feedbackEntity.toString());
		
		return "Feedback Saved to db"+repo.save(feedbackEntity);
	}
	 
	@GetMapping("/show/{id}")
	public Optional<FeedbackEntity> show(@PathVariable int id) {
		Optional<FeedbackEntity> feedbackEntity = repo.findById(id);
		//if(feedbackEntity.isPresent()) {
			return feedbackEntity;
		//}else
			//return "ID not found";
		
	}
}
