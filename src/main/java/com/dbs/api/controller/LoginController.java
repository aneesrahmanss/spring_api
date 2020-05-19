package com.dbs.api.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dbs.api.dao.UsersRepository;
import com.dbs.api.entity.Users;
import com.dbs.api.model.User;

@RestController
@CrossOrigin
public class LoginController {

	@Autowired
    private UsersRepository userRepo;
	
	@GetMapping("/login")
	public User login(@RequestParam(value="username") String username,
			@RequestParam(value="password") String password) {
		Users user = null;
		User userResp = null;
		if(null != username && username.length() > 0 ){
			List<Users> users = userRepo.findByUsernameAndPassword(username, password);
			if(users.size()>0){
				userResp = new User();
				userResp.setUsername(users.get(0).getUsername());
				userResp.setRole(users.get(0).getRole());
				String key = users.get(0).getUsername()+ new Date().toString();
				userResp.setKey(key);
				Users keySessionUser = users.get(0);
				keySessionUser.setKey(key);
				user = userRepo.save(keySessionUser);
				userResp = new User();
				userResp.setUsername(user.getUsername());
				userResp.setRole(user.getRole());
				userResp.setKey(user.getKey());
				return userResp;
			}
		}
		return userResp;
	}
	
	@GetMapping("/logout")
	public Users logout(@RequestParam(value="key") String key) {
		userRepo.findByKey(key);
		return null;
	}
	
	
	
}
