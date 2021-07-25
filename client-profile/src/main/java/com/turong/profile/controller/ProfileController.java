package com.turong.profile.controller;

import com.turong.profile.convert.ProfileConvert;
import com.turong.profile.service.ProfileService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("profiles")
@Slf4j
public class ProfileController {

    @Autowired
    private ProfileService profileService;

    @Autowired
    private ProfileValidator profileValidator;

    @Autowired
    private ProfileConvert profileConvert;

    @GetMapping("/{id}")
    public ResponseEntity<ProfileResponse> getProfile(@PathVariable final String id) {
        log.debug("Get Profile with id={}", id);
        return ResponseEntity.ok(profileService.getProfile(id));

    }

    @PostMapping
    public ResponseEntity<ProfileResponse> createProfile(@RequestBody final ProfileSaveRequest profileSaveRequest) {
        profileValidator.validate(profileSaveRequest);
        return ResponseEntity.ok(profileConvert.toResponse(
                profileService.create(profileConvert.toProfile(profileSaveRequest))));
    }

    @DeleteMapping
    public void deleteProfileByEmail(@RequestParam final String email) {
        if (StringUtils.isBlank(email)) {
            throw new IllegalArgumentException("Email to delete must be present!");
        }
        profileService.deleteByEmail(email);
    }

    @DeleteMapping("/{id}")
    public void deleteProfileById(@PathVariable final String id) {
        if (StringUtils.isBlank(id)) {
            throw new IllegalArgumentException("Id to delete must be present!");
        }
        profileService.deleteById(id);
    }
}
