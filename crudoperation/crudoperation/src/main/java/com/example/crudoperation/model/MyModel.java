package com.example.crudoperation.model;
import jakarta.persistence.*;


@Entity
public class MyModel {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String message;
	
	public MyModel() {
		
	}
	public MyModel(int id, String message){
		this.id=id;
		
		this.message=message;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	

}

