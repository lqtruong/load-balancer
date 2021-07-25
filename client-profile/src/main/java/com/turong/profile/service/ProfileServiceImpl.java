package com.turong.profile.service;

import com.turong.profile.controller.ProfileResponse;
import com.turong.profile.entity.Profile;
import com.turong.profile.mapper.ProfileMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProfileServiceImpl implements ProfileService {

    private final ProfileMapper profileMapper;

    public ProfileServiceImpl(@Autowired final ProfileMapper profileMapper) {
        this.profileMapper = profileMapper;
    }

    @Override
    public ProfileResponse getProfile(String id) {
        Optional<Profile> profile = profileMapper.findProfile(id);
        if (!profile.isPresent()) {
            return null;
        }
        Profile foundProfile = profile.get();
        return ProfileResponse.builder()
                .id(foundProfile.getId())
                .username(foundProfile.getUsername())
                .email(foundProfile.getEmail())
                .app(foundProfile.getApp())
                .build();
    }

    @Override
    public Profile create(Profile profileToCreate) {
        final int count = profileMapper.insert(profileToCreate);
        if (count == 0) {
            return null;
        }
        return profileMapper.findProfileByEmail(profileToCreate.getEmail()).orElseThrow(IllegalArgumentException::new);
    }

    @Override
    public int deleteByEmail(String email) {
        return profileMapper.deleteByEmail(email);
    }

    @Override
    public int deleteById(String id) {
        return profileMapper.deleteById(id);
    }

}
