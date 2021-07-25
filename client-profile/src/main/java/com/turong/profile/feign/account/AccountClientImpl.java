package com.turong.profile.feign.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountClientImpl implements AccountClient {

    @Autowired
    private AccountApi accountApi;

    @Override
    public AccountResponse getAccountByEmail(String email) {
        return accountApi.getAccountByEmail(email).getBody();
    }

}
