package com.example.demo.controller;


import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.HackathonApplication;
import com.example.demo.model.UserProfile;
@RunWith(SpringRunner.class)
@SpringBootTest(classes = HackathonApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HackathonControllerTest {
    String user1;
    @LocalServerPort
    private int port;
    TestRestTemplate restTemplate = new TestRestTemplate();
    HttpHeaders headers = new HttpHeaders();
    UserProfile userProfile;
    @Before
    public void setUp() throws Exception {
         userProfile = new UserProfile(3,"Paul Dawson","216805");
    }
    private String createURLWithPort(String uri) {
        return "http://localhost:" + port + uri;
    }
    @After
    public void tearDown() throws Exception {
    }
    @Test
    public void testSaveProfile() throws Exception {
        HttpEntity<UserProfile> entity = new HttpEntity<UserProfile>(userProfile, headers);
        ResponseEntity<UserProfile> response = restTemplate.exchange(
                createURLWithPort("/v2.0/restcontroller"),
                HttpMethod.POST, entity, UserProfile.class);
        assertNotNull(response);
        UserProfile actual = response.getBody();
        assertEquals(userProfile.getId(),actual.getId());
    }

    @Test
    public void testGetProfileById() throws Exception {
    	 HttpEntity<UserProfile> entity = new HttpEntity<UserProfile>(headers);
         ResponseEntity<UserProfile> response = restTemplate.exchange(
                 createURLWithPort("/v2.0/restcontroller/3"),
                 HttpMethod.GET, entity, UserProfile.class);
         assertNotNull(response);
         UserProfile actual = response.getBody();
         assertEquals(userProfile.getUserId(),actual.getUserId());
    	
    }
    
    @Test
    public void testUpdateUser() throws Exception {
    	HttpEntity<UserProfile> entity = new HttpEntity<UserProfile>(userProfile, headers);
        ResponseEntity<UserProfile> response = restTemplate.exchange(
                createURLWithPort("/v2.0/restcontroller"),
                HttpMethod.POST, entity, UserProfile.class);
        assertNotNull(response);
        UserProfile actual = response.getBody();
        assertEquals(userProfile.getId(),actual.getId());
    }
    @Test
    public void testDeleteUser() throws Exception {
    }
}