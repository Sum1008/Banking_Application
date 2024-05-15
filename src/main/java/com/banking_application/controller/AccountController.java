package com.banking_application.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.banking_application.entity.Account;
import com.banking_application.serice.AccountService;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    AccountService accountService;

    @PostMapping("/create")
    public Account createAccount(@RequestBody Account account) {

        Account createAccount = accountService.createAccount(account);
        System.out.println("Account created successfully");
        return createAccount;
    }

    @GetMapping("/getaccount/{accountNumber}")
    public Account getAccountByAccountNumber(@PathVariable Long accountNumber) {
        Account account = accountService.getAccountByAccountNumber(accountNumber);
        return account;

    }

    @GetMapping("/getallaccounts")
    public List<Account> getAllAccounts() {

        List<Account> allaccounts = accountService.getAllAccounts();
        return allaccounts;
    }

    @PutMapping("/deposit/{accountNumber}/{amount}")
    public Account depositAccount(@PathVariable Long accountNumber, @PathVariable Double amount) {

        Account account = accountService.depositAmount(accountNumber, amount);
        return account;
    }

    @PutMapping("/withdraw/{accountNumber}/{amount}")
    public Account withdrawAmount(@PathVariable Long accountNumber, @PathVariable Double amount) {

        Account account = accountService.withdrawAmount(accountNumber, amount);
        return account;

    }

    @DeleteMapping("/delete/{accountNumber}")
    public ResponseEntity deleteAccount(@PathVariable Long accountNumber) {
        accountService.deleteAccount(accountNumber);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("Account deleted successfully");

    }

}
