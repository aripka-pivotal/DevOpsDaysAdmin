package io.pivotal.devopsdays.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
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
}
