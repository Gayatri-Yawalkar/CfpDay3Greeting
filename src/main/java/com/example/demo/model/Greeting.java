package com.example.demo.model;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="GREETINGS")
public class Greeting {
	@Id
	private long id;
	private String message;
	public Greeting() {
		this.id=0;
		this.message="";
	}
	public Greeting(long id,String message) {
		this.id=id;
		this.message=message;
	}
	public long getId() {
		return id;
	}
	public String getMessage() {
		return message;
	}
}
