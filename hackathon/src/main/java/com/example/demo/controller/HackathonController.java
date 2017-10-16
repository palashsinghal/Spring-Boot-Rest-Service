package com.example.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.UserProfile;
import com.example.demo.service.HackathonServiceImpl;

import io.swagger.annotations.ApiOperation;

@RestController

@RequestMapping("/v2.0/restcontroller/userProfile")
public class HackathonController {
	
	@Autowired
	HackathonServiceImpl hackathonServiceImpl;
	
	@ApiOperation(value = "Add a new User")
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
		String EMAIL_REGEX = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
	      String email1 = userProfile.getBody().getUserId();
	      String name = userProfile.getBody().getName();
	      if(!(email1.isEmpty()||name.isEmpty()))
	      {
	    	  Boolean b = email1.matches(EMAIL_REGEX);
	    	  if(b)
	    	  {
	    		  return new ResponseEntity(hackathonServiceImpl.addUpdateProfile(userProfile.getBody()),HttpStatus.OK);
	    	  }
	    	  else
	    	  {
	    		  return new ResponseEntity("Please Enter Correct Email ID",HttpStatus.CONFLICT);
	    	  }
	      }
	      
	      else
	      {
	    	  return new ResponseEntity("Please Enter the Required Values",HttpStatus.CONFLICT);
	      }			
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity deleteProfile(@PathVariable(value="id") int id) {
		return new ResponseEntity(hackathonServiceImpl.deleteProfile(id), HttpStatus.OK);
	}
}
