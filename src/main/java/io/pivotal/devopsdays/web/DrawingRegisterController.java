package io.pivotal.devopsdays.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import io.pivotal.devopsdays.entity.DrawingRegistrant;
import io.pivotal.devopsdays.repository.DrawingRegistrantRepository;

@Controller
public class DrawingRegisterController {
	
	@Autowired
	private DrawingRegistrantRepository drawingRegistrantRepo;
	
	
	@RequestMapping("/")
	public String index(){
		return "index";
	}
	
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String register(){
		return "register";
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String newRegistrant(@RequestParam String name, @RequestParam String emailAddress,@RequestParam String company){
		
		DrawingRegistrant drawingRegistrant = new DrawingRegistrant();
		
		drawingRegistrant.setName(name);
		drawingRegistrant.setEmailAddress(emailAddress);
		drawingRegistrant.setCompany(company);
		
		drawingRegistrantRepo.save(drawingRegistrant);
		
		//log all Registrants
		for(DrawingRegistrant dr: drawingRegistrantRepo.findAll()){
			System.out.println(dr.toString());
		}
				
		return "registerSuccess";
	}
	
	
}
