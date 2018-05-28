package com.purpletalk.helper;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.purpletalk.entities.TestUser;

@Service
@Transactional
public class UserService {

	@Autowired
	//used for performing crud operations
	private UserRepositary userRepositary;

	//adding the users
	public void addUser(TestUser testUser){
		System.out.println("adding user..");
		userRepositary.save(testUser);
	}

	//getting the user based on the id
	public Optional<TestUser> getUser(String id){
		System.out.println("getting the user details..");
		Optional<TestUser> user=Optional.of(new TestUser());
		if(userRepositary.existsById(id)){
			return userRepositary.findById(id);
		}else{
			System.out.println("data doesn't exists for this id: "+id);
			return user;
		}
	}

	//deletion of user by id
	public void delete(String id){
		System.out.println("deleting user details..");

		if(userRepositary.existsById(id)){
			userRepositary.deleteById(id);
		}else{
			System.out.println("data doesn't exists for this id: "+id);
		}
	}

	//getting the list of users
	public List<TestUser> getAllUsers(){
		System.out.println("getting list of users..");
		List<TestUser> user=new ArrayList<TestUser>();
		userRepositary.findAll().forEach(user::add);
		//System.out.println("data: "+userRepositary.FindById("ff80818163731aea0163731b190c0000"));
		return user;
	}

}
