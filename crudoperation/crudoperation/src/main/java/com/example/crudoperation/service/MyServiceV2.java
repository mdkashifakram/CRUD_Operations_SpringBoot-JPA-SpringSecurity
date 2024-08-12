//we would be using JPA as well, hence creatign another Service class

package com.example.crudoperation.service;

import com.example.crudoperation.exception.ModelNotFoundException;
import com.example.crudoperation.exception.InvalidModelException;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.crudoperation.model.MyModel;
import com.example.crudoperation.repository.MyRepository;

@Service
public class MyServiceV2 {
	@Autowired
	private MyRepository myRepository;
	public List<MyModel> getAllModels(){
		return myRepository.findAll();
	}
	
	public MyModel createModel(MyModel newModel) {
		if(newModel==null || newModel.getMessage().isEmpty()) {
			throw new InvalidModelException("Model data is invalid");
		}
		return myRepository.save(newModel);
	}
	public MyModel updateModel(int id,MyModel updatedModel) {
		return myRepository.findById(id).map(existingModel->{
			existingModel.setMessage(updatedModel.getMessage());
			return myRepository.save(existingModel);
		}).orElseThrow(()-> new ModelNotFoundException("Model with Id "+id+ " not found!"));
	}
	public MyModel deleteModel(int id) {
		return myRepository.findById(id).map(existingModel->{
			myRepository.delete(existingModel);
			return existingModel;
		})
		.orElseThrow(()-> new ModelNotFoundException("Model with ID "+id+" not found!"));
	}
	
}
