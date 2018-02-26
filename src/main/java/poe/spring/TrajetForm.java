package poe.spring;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;


public class TrajetForm {

	private String depart;
	private String arrive;
		
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date date;
	
	private Double prix;
	private int place;
	private Long user;
	
	
	
	public Long getUser() {
		return user;
	}
	public void setUser(Long user) {
		this.user = user;
	}
	public String getDepart() {
		return depart;
	}
	public void setDepart(String depart) {
		this.depart = depart;
	}
	public String getArrive() {
		return arrive;
	}
	public void setArrive(String arrive) {
		this.arrive = arrive;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Double getPrix() {
		return prix;
	}
	public void setPrix(Double prix) {
		this.prix = prix;
	}
	public int getPlace() {
		return place;
	}
	public void setPlace(int place) {
		this.place = place;
	}
	
	
}
