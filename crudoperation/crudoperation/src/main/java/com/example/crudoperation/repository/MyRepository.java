package com.example.crudoperation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.crudoperation.model.MyModel;

public interface MyRepository  extends JpaRepository<MyModel, Integer>{

}
