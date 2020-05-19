package com.dbs.api.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dbs.api.entity.UserRequest;
import com.dbs.api.entity.Users;

@Repository
public interface UserRequestRepository extends JpaRepository<UserRequest, Long> {
	UserRequest findByRequestId(Long key);
	List<UserRequest> findByStatusNot(String status);
}
