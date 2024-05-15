package com.banking_application.serice;

import java.util.List;

import com.banking_application.entity.Account;

public interface AccountService {

    public Account createAccount(Account account);

    public Account getAccountByAccountNumber(long accountNumber);

    public List<Account> getAllAccounts();

    public Account depositAmount(Long accountNumber, Double amount);

    public Account withdrawAmount(Long accountNumber, Double amount);

    public void deleteAccount(Long accountNumber);

}
