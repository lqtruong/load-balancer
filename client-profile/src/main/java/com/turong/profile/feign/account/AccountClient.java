package com.turong.profile.feign.account;

public interface AccountClient {

    AccountResponse getAccountByEmail(final String email);

}
