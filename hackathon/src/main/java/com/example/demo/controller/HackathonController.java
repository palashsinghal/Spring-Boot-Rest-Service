package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.UserProfile;
import com.example.demo.service.HackathonServiceImpl;

@RestController

@RequestMapping("/v2.0/restcontroller")
public class HackathonController {
	
	@Autowired
	HackathonServiceImpl hackathonServiceImpl;
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity getAllProfiles(){
		return new ResponseEntity(hackathonServiceImpl.getAllProfiles(), HttpStatus.OK);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity getProfileById(@PathVariable(value="id") Integer id) {
		return new ResponseEntity(hackathonServiceImpl.getProfileById(id),HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity saveProfile(RequestEntity<UserProfile> userProfile) {
		return new ResponseEntity(hackathonServiceImpl.addUpdateProfile(userProfile.getBody()),HttpStatus.OK);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity deleteProfile(@PathVariable(value="id") int id) {
		return new ResponseEntity(hackathonServiceImpl.deleteProfile(id), HttpStatus.OK);
	}
}
