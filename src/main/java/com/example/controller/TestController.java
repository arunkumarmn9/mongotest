package com.example.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.dao.ConsignmentRepo;
import com.example.dao.FriendsRepository;
import com.example.model.Friends;

import org.springframework.beans.factory.annotation.Autowired;
 

@RestController
public class TestController {

	@Autowired
	FriendsRepository friendsRepository;
 
 
	@RequestMapping("/test")
	public List tester1(){
		Friends fr=new Friends();
		fr.setName("arun");
		fr.setId(9811);
		fr.setSeason(1);
		fr.setNumber(1);
		fr.setName("First Episode:");
		fr.setRuntime(30);
		fr.setUrl("nothing");
		fr.setAirdate("donno");
		fr.setAirtime("donno:");
		//friendsRepository.save(fr);
		friendsRepository.aggregate();
		
		friendsRepository.count();
		friendsRepository.findAllByName("ak96");
		friendsRepository.findOneById(40880);
		friendsRepository.findAllBySeason(2);
		
		
		return  		friendsRepository.aggregate();
		
	}
	
	@RequestMapping("/getEpisodeData")
	public void getEpisodedata(@RequestParam("season")int season,@RequestParam("number")int number){
		
		
	}
	@RequestMapping("/getAllSeasonsData")
	public void getAllSeasonsData(){
		
	}
	@RequestMapping("/getSeasonData")
	public void getSeasonData(@RequestParam("season")int season)
	{
		
	}
	
	@RequestMapping("/getActorsList")
	public void getActorsList(@RequestParam("series")String series)
	{
		
	}
	
	
	
	
}
