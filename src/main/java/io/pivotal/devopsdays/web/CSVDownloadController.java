package io.pivotal.devopsdays.web;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;

import io.pivotal.devopsdays.entity.DrawingRegistrant;
import io.pivotal.devopsdays.repository.DrawingRegistrantRepository;

@Controller
public class CSVDownloadController {

	@Autowired
	DrawingRegistrantRepository repo;
	
	
	@RequestMapping(value = "/downloadCSV")
	public void downloadCSV(HttpServletResponse response) throws IOException {

		String headerKey = "Content-Disposition";
		String csvFileName = "registrants.csv";
		String headerValue = String.format("attachment; filename=\"%s\"",
				csvFileName);
				response.setHeader(headerKey, headerValue);

		response.setContentType("text/csv");
		
		// uses the Super CSV API to generate CSV data from the model data
		ICsvBeanWriter csvWriter = new CsvBeanWriter(response.getWriter(),
		CsvPreference.STANDARD_PREFERENCE);
		
		String[] header = { "name", "company", "emailAddress", };
		
		csvWriter.writeHeader(header);
		for (DrawingRegistrant drawingRegistrant: repo.findAll()) {
		csvWriter.write(drawingRegistrant, header);
		}
		
		csvWriter.close();
	}
}
