package com.turong.account.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class AccountValidator implements WebValidator<AccountSaveRequest> {

    @Override
    public boolean validate(final AccountSaveRequest request) {
        if (!request.valid()) {
            log.debug("Validated request={}", request);
            throw new IllegalArgumentException("The request is not valid.");
        }
        return true;
    }
}
