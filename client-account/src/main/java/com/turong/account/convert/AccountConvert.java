package com.turong.account.convert;

import com.turong.account.controller.AccountResponse;
import com.turong.account.controller.AccountSaveRequest;
import com.turong.account.entity.Account;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AccountConvert {

    Account toAccount(final AccountSaveRequest accountSaveRequest);

    AccountResponse toResponse(final Account account);

}
