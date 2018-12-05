package com.sant.account.controller;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sant.account.model.Account;

@RestController
public class AccountController {
    @Value("${message}")
    private String message;
    
    private List<Account> accounts;
 
    protected Logger logger = Logger.getLogger("com.sant.account");
 
    public AccountController() {
        accounts = new ArrayList<>();
        accounts.add(new Account("ac1", "111111", 100000));
        accounts.add(new Account("ac2", "222222", 200000));
        accounts.add(new Account("ac3", "333333", 300000));
        accounts.add(new Account("ac4", "222222", 400000));
        accounts.add(new Account("ac5", "555555", 500000));
    }
 
    @RequestMapping("/accounts/{number}")
    public Account findByAccountId(@PathVariable("number") String accountId) {
        logger.info(String.format("Account.findByNumber(%s)", accountId));
        return accounts.stream().filter(it -> it.getAccountId().equals(accountId)).findFirst().get();
    }
 
    @RequestMapping("/accounts/customer/{customer}")
    public List<Account> findByCustomer(@PathVariable("customer") String customerId) {
        logger.info(String.format("Account.findByCustomer(%s)", customerId));
        return accounts.stream().filter(it -> it.getCustId().equals(customerId)).collect(Collectors.toList());
    }
 
    @RequestMapping("/accounts")
    public List<Account> findAll() {
        logger.info("Account.findAll()");
        return accounts;
    }
    
    @RequestMapping("/accounts/greetings")
    public String welcome() {
        logger.info("Welcome to "+message);
        return "Welcome to "+message;
    }
}