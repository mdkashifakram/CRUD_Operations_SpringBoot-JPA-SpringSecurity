package com.example.crudoperation.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.crudoperation.model.MyModel;

@RestController
@RequestMapping("_/api")
public class MyController{
	public List<MyModel> modelList=new ArrayList<>(Arrays.asList(
			new MyModel(1,"Message1"),
			new MyModel(2,"Message2")
			));
	
	
	@GetMapping("/models")
	public List<MyModel> getAllModels(){
		return modelList;
	}
	
	@PostMapping("/models")
	public MyModel createModel(@RequestBody MyModel newModel) {
		modelList.add(newModel);
		return newModel;
	}
	
	@PutMapping("/models/{id}")
	public MyModel updateModel(@PathVariable int id, @RequestBody MyModel updatedModel) {
		for(MyModel existingModel:modelList) {
			if(existingModel.getId()==id) {
				existingModel.setMessage(updatedModel.getMessage());
				return existingModel;
			}
		}
	return null;
	}

	@DeleteMapping("/models/{id}")
	public MyModel deleteModel(@PathVariable int id) {
		for(MyModel existingModel:modelList) {
			if(existingModel.getId()==id) {
				modelList.remove(existingModel);
				return existingModel;
			}
		}
	return null;
	}
		
}