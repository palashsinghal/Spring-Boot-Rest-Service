package com.example.demo.service;

import java.util.List;

import com.example.demo.model.UserProfile;

public interface HackathonService {
	
	public List<UserProfile> getAllProfiles();
	public UserProfile getProfileById(int id);
	public UserProfile addUpdateProfile(UserProfile userProfile);
	public String deleteProfile(int id);
}
