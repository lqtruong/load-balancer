package com.turong.account.controller;

public interface WebValidator<WebRequest> {

    boolean validate(final WebRequest request);

}
