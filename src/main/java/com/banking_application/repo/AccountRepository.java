package com.banking_application.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.banking_application.entity.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

}
