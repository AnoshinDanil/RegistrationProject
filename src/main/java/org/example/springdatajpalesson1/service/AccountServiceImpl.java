package org.example.springdatajpalesson1.service;

import org.example.springdatajpalesson1.entity.Account;
import org.example.springdatajpalesson1.repository.AccountRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService{
    AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public void addAccount(Account account) {
        accountRepository.save(account);
    }

    @Override
    public Account getAccount(long accountId) {
       return accountRepository.findById(accountId).orElse(null);
    }

    @Override
    public List<Account> getAccounts() {
        return accountRepository.findAll();
    }

    @Override
    public void deleteAccount(long accountId) {
        accountRepository.deleteById(accountId);
    }
}
