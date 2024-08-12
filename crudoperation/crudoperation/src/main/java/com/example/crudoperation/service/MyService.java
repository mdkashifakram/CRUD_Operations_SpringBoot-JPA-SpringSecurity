package com.example.crudoperation.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.crudoperation.model.MyModel;

@Service
public class MyService {

	private List<MyModel> modelList=new ArrayList<>(Arrays.asList(new MyModel(1,"Message 1"),new MyModel(2,"Message2")));

	public List<MyModel> getAllModels(){
		return modelList;
	}
	
	public MyModel createModel(MyModel newModel) {
		modelList.add(newModel);
		return newModel;
	}
	
	public MyModel updateModel(int id,MyModel updatedModel) {
		for(MyModel existingModel:modelList) {
			if(existingModel.getId()==id) {
				existingModel.setMessage(updatedModel.getMessage());
				return existingModel;
			}
		}
	return null;
	}

	public MyModel deleteModel(int id) {
		for(MyModel existingModel:modelList) {
			if(existingModel.getId()==id) {
				modelList.remove(existingModel);
				return existingModel;
			}
		}
		return null;
	}
}

