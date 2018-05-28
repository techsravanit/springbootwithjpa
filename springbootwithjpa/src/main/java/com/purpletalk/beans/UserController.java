package com.purpletalk.beans;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.purpletalk.entities.TestUser;
import com.purpletalk.helper.UserRepositary;
import com.purpletalk.helper.UserService;

@RestController
@Transactional
public class UserController {
	
	/*@Autowired
	//used for performing crud operations
	private UserRepositary userRepositary;
	
	@RequestMapping("/")
	public List<TestUser> getAllUsers(){
		return userRepositary.findByNameAndEmail("dev","raj@mail.com");
	}*/

	@Autowired
	private UserService userService;

	@RequestMapping("/")
	public List<TestUser> getAllUsers(){
		return userService.getAllUsers();
	}

	@RequestMapping(value="/adduser", method=RequestMethod.POST)
	public void addUser(@RequestBody TestUser user){
		userService.addUser(user);
	}

	@RequestMapping(value="/getuser/{id}", method=RequestMethod.GET)
	public Optional<TestUser> getUser(@PathVariable("id") String id){
		return userService.getUser(id);
	}

	@RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
	public void delete(@PathVariable("id") String id){
		userService.delete(id);
	}
}
