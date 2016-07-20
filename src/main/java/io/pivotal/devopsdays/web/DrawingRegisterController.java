package io.pivotal.devopsdays.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import io.pivotal.devopsdays.entity.DrawingRegistrant;
import io.pivotal.devopsdays.entity.LeadCapture;
import io.pivotal.devopsdays.repository.DrawingRegistrantRepository;
import io.pivotal.devopsdays.repository.LeadCaptureRepository;

@Controller
public class DrawingRegisterController {

	@Autowired
	private DrawingRegistrantRepository drawingRegistrantRepo;
	
	@Autowired
	private LeadCaptureRepository leadCaptureRepo;

	@RequestMapping("/")
	public String index() {
		return "index";
	}

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String register() {
		return "register";
	}

	@RequestMapping(value = "/learnMore", method = RequestMethod.GET)
	public String learnMore() {
		return "registerLearnMore";
	}

	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String newRegistrant(@RequestParam String name, @RequestParam String emailAddress,
			@RequestParam String company) {

		DrawingRegistrant drawingRegistrant = createDrawingRegistrant(name, emailAddress, company);
		
		drawingRegistrantRepo.save(drawingRegistrant);

		return "registerSuccess";
	}

	@RequestMapping(value = "/learnMore", method = RequestMethod.POST)
	public String learnMore(@RequestParam String name, @RequestParam String emailAddress,
			@RequestParam String company, @RequestParam String title, @RequestParam String phoneNumber, @RequestParam String currentChallenge, @RequestParam String nextSteps) {

		DrawingRegistrant drawingRegistrant = createDrawingRegistrant(name, emailAddress, company);
		
		LeadCapture leadCapture = new LeadCapture();
		leadCapture.setDrawingRegistrant(drawingRegistrant);
		leadCapture.setCurrentChallenge(currentChallenge);
		leadCapture.setNextSteps(nextSteps);
		leadCapture.setPhoneNumber(phoneNumber);
		leadCapture.setTitle(title);
		
		leadCaptureRepo.save(leadCapture);

		return "registerSuccess";
	}
	
	private DrawingRegistrant createDrawingRegistrant(String name, String emailAddress, String company) {
		DrawingRegistrant drawingRegistrant = new DrawingRegistrant();

		drawingRegistrant.setName(name);
		drawingRegistrant.setEmailAddress(emailAddress);
		drawingRegistrant.setCompany(company);
		
		return drawingRegistrant;

	}

}
