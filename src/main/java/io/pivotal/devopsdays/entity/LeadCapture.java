package io.pivotal.devopsdays.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class LeadCapture {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@OneToOne(cascade=CascadeType.PERSIST)
	private DrawingRegistrant drawingRegistrant;
	
	private String title;
	private String phoneNumber;
	@Column(length=512)
	private String currentChallenge;
	
	@Column(length=512)
	private String nextSteps;
	
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public DrawingRegistrant getDrawingRegistrant() {
		return drawingRegistrant;
	}

	public void setDrawingRegistrant(DrawingRegistrant drawingRegistrant) {
		this.drawingRegistrant = drawingRegistrant;
	}

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public String getCurrentChallenge() {
		return currentChallenge;
	}
	public void setCurrentChallenge(String currentChallenge) {
		this.currentChallenge = currentChallenge;
	}
	
	public String getNextSteps() {
		return nextSteps;
	}
	public void setNextSteps(String nextSteps) {
		this.nextSteps = nextSteps;
	}
	
	
	
}
