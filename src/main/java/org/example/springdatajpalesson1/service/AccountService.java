package org.example.springdatajpalesson1.service;

import org.example.springdatajpalesson1.entity.Account;

import java.util.List;

public interface AccountService {
    void addAccount(Account account);
    Account getAccount(long id);
    List<Account> getAccounts();
    void deleteAccount(long id);
}
