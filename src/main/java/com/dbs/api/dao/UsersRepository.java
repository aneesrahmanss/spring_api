package com.dbs.api.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dbs.api.entity.Users;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {

	List<Users> findByUsernameAndPassword(String username, String password);
	
	Users findByKey(String key);

}
