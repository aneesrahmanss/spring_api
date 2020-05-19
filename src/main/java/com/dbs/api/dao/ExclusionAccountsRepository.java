package com.dbs.api.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dbs.api.entity.ExclusionAccounts;

@Repository
public interface ExclusionAccountsRepository extends
		JpaRepository<ExclusionAccounts, Long> {

}
