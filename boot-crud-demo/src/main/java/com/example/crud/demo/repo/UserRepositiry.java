package com.example.crud.demo.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.crud.demo.model.User;

public interface UserRepositiry extends CrudRepository<User, Integer>{
	

}
