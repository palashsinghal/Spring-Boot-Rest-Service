package com.example.demo.service;


import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.example.demo.model.UserProfile;
import com.example.demo.repository.UserRepository;

import static org.mockito.Mockito.*;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;






public class HackathonServiceImplTest {

  private HackathonServiceImpl hackathonServiceImpl;
   @Mock
   private UserRepository userRepository;
   @Mock
   private UserProfile userProfile;
   @Before
   public void setupMock() {
       MockitoAnnotations.initMocks(this);
       hackathonServiceImpl=new HackathonServiceImpl();
       hackathonServiceImpl.setUserRepository(userRepository);
   }
   @Test
   public void shouldReturnUserId_whenGetUserByIdIsCalled() throws Exception {
       // Arrange
       when(userRepository.findOne(5)).thenReturn(userProfile);
       // Act
       UserProfile retrievedUserProfile = hackathonServiceImpl.getProfileById(5);
       // Assert
       assertThat(retrievedUserProfile.getUserId(), is(equalTo(userProfile.getUserId())));

  }
   @Test
   public void shouldReturnUserProfile_whenSaveProfileIsCalled() throws Exception {
       // Arrange
       when(userRepository.save(userProfile)).thenReturn(userProfile);
       // Act
       UserProfile retrievedUserProfile = hackathonServiceImpl.addUpdateProfile(userProfile);
       // Assert
       assertThat(retrievedUserProfile.getId(), is(equalTo(userProfile.getId())));
   }
//   @Test
//   public void shouldCallDeleteMethodOfUserRepository_whenDeleteUserIsCalled() throws Exception {
//       // Arrange
//       doNothing().when(userRepository).delete(5);
//       UserRepository my = Mockito.mock(UserRepository.class);
//       // Act
//       hackathonServiceImpl.deleteProfile(5);
//       // Assert
//       verify(userRepository, times(1)).delete(5);
//   }
}