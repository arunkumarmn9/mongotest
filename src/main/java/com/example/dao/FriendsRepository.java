package com.example.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.example.model.Friends;

@Repository
public interface FriendsRepository extends MongoRepository<Friends,Integer>,FriendsRepositoryCustom {

	public List<Friends> findAllByName(String name);
	public List<Friends> findOneById(int id);
	public List<Friends> findAllBySeason(Integer Season);
	public List<Friends> findAllByAirtime(String Airtime);
 
	
}
