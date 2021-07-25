package com.turong.profile.controller;

public interface WebValidator<WebRequest> {

    boolean validate(final WebRequest request);

}
