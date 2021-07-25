package com.turong.account.service;

import com.turong.account.entity.Account;
import com.turong.account.mapper.AccountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {

    private final AccountMapper accountMapper;

    public AccountServiceImpl(@Autowired final AccountMapper accountMapper) {
        this.accountMapper = accountMapper;
    }

    @Override
    public Account getAccount(String id) {
        Optional<Account> account = accountMapper.findAccount(id);
        if (!account.isPresent()) {
            return null;
        }
        return account.get();
    }

    @Override
    public Account create(Account accountToCreate) {
        final int count = accountMapper.insert(accountToCreate);
        if (count == 0) {
            return null;
        }
        Optional<Account> account = accountMapper.findAccountByEmail(accountToCreate.getEmail());
        if (!account.isPresent()) {
            return null;
        }
        return account.get();
    }

    @Override
    public int deleteByEmail(String email) {
        return accountMapper.deleteByEmail(email);
    }

    @Override
    public int deleteById(String id) {
        return accountMapper.deleteById(id);
    }

    @Override
    public Account getAccountByEmail(String email) {
        Optional<Account> account = accountMapper.findAccountByEmail(email);
        if (!account.isPresent()) {
            return null;
        }
        return account.get();
    }

}
