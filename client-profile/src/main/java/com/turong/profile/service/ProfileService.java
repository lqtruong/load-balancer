package com.turong.profile.service;

import com.turong.profile.controller.ProfileResponse;
import com.turong.profile.entity.Profile;

public interface ProfileService {

    ProfileResponse getProfile(String id);

    Profile create(Profile profileToCreate);

    int deleteByEmail(String email);

    int deleteById(String id);
}
