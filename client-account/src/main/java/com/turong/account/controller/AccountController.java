package com.turong.account.controller;

import com.turong.account.convert.AccountConvert;
import com.turong.account.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("accounts")
@Slf4j
public class AccountController {

    @Autowired
    private AccountService accountService;

    @Autowired
    private AccountValidator accountValidator;

    @Autowired
    private AccountConvert accountConvert;

    @GetMapping("/{id}")
    public ResponseEntity<AccountResponse> getAccount(@PathVariable final String id) {
        log.debug("Get account with id={}, tenant={}", id);
        return ResponseEntity.ok(accountConvert.toResponse(accountService.getAccount(id)));

    }

    @PostMapping
    public ResponseEntity<AccountResponse> createAccount(@RequestBody final AccountSaveRequest accountSaveRequest) {
        accountValidator.validate(accountSaveRequest);
        return ResponseEntity.ok(accountConvert.toResponse(
                accountService.create(accountConvert.toAccount(accountSaveRequest))));
    }

    @DeleteMapping
    public void deleteAccountByEmail(@RequestParam final String email) {
        if (StringUtils.isBlank(email)) {
            throw new IllegalArgumentException("Email to delete must be present!");
        }
        accountService.deleteByEmail(email);
    }

    @DeleteMapping("/{id}")
    public void deleteAccountById(@PathVariable final String id) {
        if (StringUtils.isBlank(id)) {
            throw new IllegalArgumentException("Id to delete must be present!");
        }
        accountService.deleteById(id);
    }

    @GetMapping("/email")
    public ResponseEntity<AccountResponse> getAccountByEmail(@RequestParam final String email) {
        log.debug("Get account with email={}, tenant={}", email);
        return ResponseEntity.ok(accountConvert.toResponse(accountService.getAccountByEmail(email)));

    }
}
