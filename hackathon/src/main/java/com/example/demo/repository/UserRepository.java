package com.example.demo.repository;



import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.UserProfile;
@Repository
public interface UserRepository extends CrudRepository<UserProfile, Integer> {

}
