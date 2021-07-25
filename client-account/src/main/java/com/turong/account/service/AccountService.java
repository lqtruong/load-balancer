package com.turong.account.service;

import com.turong.account.controller.AccountResponse;
import com.turong.account.entity.Account;

public interface AccountService {

    AccountResponse getAccount(String id);

    Account create(Account accountToCreate);

    int deleteByEmail(String email);

    int deleteById(String id);
}
