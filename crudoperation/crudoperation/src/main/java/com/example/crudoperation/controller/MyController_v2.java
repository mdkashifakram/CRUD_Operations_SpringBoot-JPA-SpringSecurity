//this class is using Service class
package com.example.crudoperation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.crudoperation.model.MyModel;
import com.example.crudoperation.service.MyService;
import com.example.crudoperation.service.MyServiceV2;


@RestController
@RequestMapping("/api")
public class MyController_v2 {
	@Autowired
	private MyServiceV2 myServiceV2;
	@GetMapping("/models")
	public List<MyModel> getAllModels(){
		return myServiceV2.getAllModels();
	}
	
	@PostMapping("/models")
	public MyModel createModels(@RequestBody MyModel newModel) {
		return myServiceV2.createModel(newModel);
	}
	@PutMapping("models/{id}")
	public MyModel updateModel(@PathVariable int id, @RequestBody MyModel updatedModel) {
		return myServiceV2.updateModel(id, updatedModel);
	}
	@DeleteMapping("models/{id}")
	public MyModel deleteModel(@PathVariable int id) {
		return myServiceV2.deleteModel(id);
	}
	
	
}
