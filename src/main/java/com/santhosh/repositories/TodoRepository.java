package com.santhosh.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.santhosh.models.Tasks;

@Repository
public interface TodoRepository extends MongoRepository<Tasks, String> {
	
}