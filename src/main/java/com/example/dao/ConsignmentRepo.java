package com.example.dao;
import java.util.List;

import com.example.model.Consignment;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ConsignmentRepo extends MongoRepository<Consignment,Integer> {

	
	public List<Consignment> findAllByCount(int count);
	
}
