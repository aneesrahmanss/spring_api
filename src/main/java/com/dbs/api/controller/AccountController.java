package com.dbs.api.controller;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dbs.api.dao.ExclusionAccountsRepository;
import com.dbs.api.dao.UserRequestRepository;
import com.dbs.api.entity.ExclusionAccounts;
import com.dbs.api.entity.UserRequest;

@RestController
@CrossOrigin
public class AccountController {

	@Autowired
	private ExclusionAccountsRepository accountRepo;

	@Autowired
	private UserRequestRepository userReqRepo;

	/* Exclusion Account - start */
	@GetMapping("/getAllExclAccount")
	public List<ExclusionAccounts> getAllAccount() {
		return accountRepo.findAll();
	}

	@PostMapping("/saveExclAccount")
	public ExclusionAccounts saveAccount(
			@RequestBody ExclusionAccounts exclusionAccounts) {
		return accountRepo.save(exclusionAccounts);
	}

	/* Exclusion Account - end */

	/* User Request - start */
	@GetMapping("/getAllUserRequest")
	public List<UserRequest> getAllUserRequest(@RequestParam(value="role") String role) {
		if(role != "" && role.equals("admin")){
			return userReqRepo.findByStatusNot("cancelled");	
		}
		return userReqRepo.findAll();
	}

	@PostMapping("/saveUserExclAccount")
	public void saveUserRequest(@RequestBody UserRequest userRequest) {
		userRequest.setSubmittedDate(new Date(System.currentTimeMillis()));
		userReqRepo.save(userRequest);
	}
	
	@PostMapping("/accountAction")
	public void accountAction(@RequestBody UserRequest userRequest) {
		UserRequest userRequestEntity = userReqRepo.findByRequestId((Long)userRequest.getRequestId());
		userRequestEntity.setApprovalDate(new Date(System.currentTimeMillis()));
		userRequestEntity.setApprovedBy(userRequest.getApprovedBy());
		userRequestEntity.setStatus(userRequest.getStatus());
		userReqRepo.save(userRequestEntity);
	}

	@DeleteMapping("/deleteAccount")
	public void deleteAccount(@RequestParam(value = "id") long id) {
		userReqRepo.deleteById(id);
	}
	/* User Request - end */

}
