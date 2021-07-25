package com.turong.profile.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ProfileValidator implements WebValidator<ProfileSaveRequest> {

    @Override
    public boolean validate(final ProfileSaveRequest request) {
        if (!request.valid()) {
            log.debug("Validated request={}", request);
            throw new IllegalArgumentException("The request is not valid.");
        }
        return true;
    }
}
