package io.pivotal.devopsdays.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import io.pivotal.devopsdays.entity.DrawingRegistrant;
import io.pivotal.devopsdays.repository.DrawingRegistrantRepository;

@Controller
public class CSVDownloadController {

	@Autowired
	DrawingRegistrantRepository repo;
	
	
	@RequestMapping(value = "/csv")
	public void downloadCSV(HttpServletResponse response) throws IOException{
		
		PrintWriter pw = response.getWriter();
		pw.println("name,company,emailAddress");
		for(DrawingRegistrant dw: repo.findAll()){
			pw.println(dw.getName()+","+dw.getCompany()+","+dw.getEmailAddress());;
		}
		


	}
}
