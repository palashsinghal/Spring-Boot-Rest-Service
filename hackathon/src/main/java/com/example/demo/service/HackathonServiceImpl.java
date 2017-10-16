package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.UserProfile;
import com.example.demo.repository.UserRepository;

@Service
public class HackathonServiceImpl implements HackathonService {

	@Autowired
	UserRepository userRepository;
	
	public UserRepository getUserRepository() {
		return userRepository;
	}

	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public List<UserProfile> getAllProfiles() {
		return (List<UserProfile>) userRepository.findAll();
	}

	@Override
	public UserProfile getProfileById(int id) {
		return userRepository.findOne(id);
	}

	@Override
	public UserProfile addUpdateProfile(UserProfile userProfile) {
		 userRepository.save(userProfile);
		return userProfile;
	}

	@Override
	public String deleteProfile(int id) {
		 userRepository.delete(userRepository.findOne(id));
		return "Profile deleted";
	}

}
