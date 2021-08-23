package com.turong.profile.service;

import com.turong.profile.controller.ProfileResponse;
import com.turong.profile.entity.Profile;
import com.turong.profile.feign.account.AccountClient;
import com.turong.profile.feign.account.AccountResponse;
import com.turong.profile.mapper.ProfileMapper;
import com.turong.profile.service.kafka.KafkaMessageSender;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
@Log4j2
public class ProfileServiceImpl implements ProfileService {

    private final ProfileMapper profileMapper;

    private final AccountClient accountClient;

    private final KafkaMessageSender kafkaSender;

    public ProfileServiceImpl(
            @Autowired final ProfileMapper profileMapper,
            @Autowired final AccountClient accountClient,
            @Autowired final KafkaMessageSender kafkaSender) {
        this.profileMapper = profileMapper;
        this.accountClient = accountClient;
        this.kafkaSender = kafkaSender;
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
        // validate email that exists in account-service
        final AccountResponse account = accountClient.getAccountByEmail(profileToCreate.getEmail());
        if (Objects.isNull(account)) {
            final String errorMsg = String.format("Account with email=%s must exist!", profileToCreate.getEmail());
            log.error(errorMsg);
            throw new IllegalArgumentException(errorMsg);
        }
        final int count = profileMapper.insert(profileToCreate);
        if (count == 0) {
            return null;
        }
        Optional<Profile> profile = profileMapper.findProfileByEmail(profileToCreate.getEmail());
        if (!profile.isPresent()) {
            return null;
        }
        Profile foundProfile = profile.get();
        // send mail to kafka
        log.info("Sending profile={} to kafka for sending mail", foundProfile);
        kafkaSender.send("profile-creation-sendmail", foundProfile);
        return foundProfile;
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
