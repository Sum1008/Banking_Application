package com.banking_application.serice;

import java.util.List;

import javax.security.auth.login.AccountNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banking_application.entity.Account;
import com.banking_application.repo.AccountRepository;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepository;

    
    @Override
    public Account createAccount(Account account) {

        Account savedAccount = accountRepository.save(account);
        return savedAccount;
    }

    public Account getAccountByAccountNumber(long accountNumber) {
        java.util.Optional<Account> account = accountRepository.findById(accountNumber);
        if (account.isEmpty()) {
            try {
                throw new AccountNotFoundException("Account not found");
            } catch (AccountNotFoundException e) {
               
                e.printStackTrace();
            }
        }
        Account account_found = account.get();
        return account_found;

    }

    @Override
    public List<Account> getAllAccounts() {

        List<Account> accounts = accountRepository.findAll();
        return accounts;
       
    }

    @Override
    public Account depositAmount(Long accountNumber, Double amount) {
        java.util.Optional<Account> account = accountRepository.findById(accountNumber);
        if (account.isEmpty()) {
            try {
                throw new AccountNotFoundException("Account not found");
            } catch (AccountNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        Account accountPresent = account.get();
        Double totalBalance = accountPresent.getAccount_balance() + amount;
        accountPresent.setAccount_balance(totalBalance);
        accountRepository.save(accountPresent);
        return accountPresent;

    }

    @Override
    public Account withdrawAmount(Long accountNumber, Double amount) {
      
        java.util.Optional<Account> account = accountRepository.findById(accountNumber);
        if (account.isEmpty()) {
            try {
                throw new AccountNotFoundException("Account not found");
            } catch (AccountNotFoundException e) {
                
                e.printStackTrace();
            }
        }
        Account accountPresent = account.get();
        Double accountBalance = accountPresent.getAccount_balance() - amount;
        accountPresent.setAccount_balance(accountBalance);
        accountRepository.save(accountPresent);
        return accountPresent;

    }

    @Override
    public void deleteAccount(Long accountNumber) {
        // first check account is present or not
        getAccountByAccountNumber(accountNumber);

        accountRepository.deleteById(accountNumber);

    }

}
