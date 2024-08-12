package com.example.crudoperation.actuator;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;

@Component
@Endpoint(id="custom")
public class CustomEndpoint {
	@ReadOperation
	public String custom() {
		return "Custom Endpoint Response";
	}

}
