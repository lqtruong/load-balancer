package com.turong.account.service;

import com.turong.account.entity.Account;

public interface AccountService {

    Account getAccount(String id);

    Account create(Account accountToCreate);

    int deleteByEmail(String email);

    int deleteById(String id);

    Account getAccountByEmail(final String email);
}
