package io.pivotal.devopsdays.web;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.pivotal.devopsdays.entity.DrawingRegistrant;
import io.pivotal.devopsdays.repository.DrawingRegistrantRepository;

@RestController 
public class DrawingRegistrantDataRestController {
	
	@Autowired
	private DrawingRegistrantRepository repo;
	
	@RequestMapping("/data")
	public Iterable<DrawingRegistrant> registrants(){
	 return repo.findAll();	
	}
	
	@RequestMapping("/assignTicket")
	public Iterable<DrawingRegistrant> assignTicket(@RequestParam String ticketNum){
	
		int ticketNumber = Integer.parseInt(ticketNum);
		
		for(DrawingRegistrant dr: repo.findAll()){
			if(dr.getTicketNumber() == null ){
				dr.setTicketNumber(Integer.toString(ticketNumber));
				repo.save(dr);
				break;				
			}
		}
		
		return repo.findAll();
	}
	
}
