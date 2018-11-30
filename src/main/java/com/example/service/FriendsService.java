package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.FriendsRepository;
import com.example.model.Friends;

@Service
public class FriendsService {

	@Autowired
	FriendsRepository friendsRepository;
	
	public Friends save(Friends f){
		
		
		return f;
		
	}
public List<Friends> getAllBySeason(int season){
		
		
		return null;
		
	}
public Friends getBySeasonAndNumber(int season,int number){
	
	
	return null;
	
}

public int getSeasonsCount(){
	
	return 0;
}

}
