package com.example.crudoperation.exception;

import java.util.Date;
public class ErrorDetails {
	private Date timeStamp;
	private String message;
	private String details;
	public ErrorDetails(Date timestamp, String message,String details) {
		super();
		this.timeStamp=timestamp;
		this.message=message;
		this.details=details;
	}

}
