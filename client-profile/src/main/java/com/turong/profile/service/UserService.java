package com.turong.profile.service;

import com.turong.profile.controller.UserResponse;
import com.turong.profile.entity.User;

public interface UserService {

    UserResponse getUser(String id);

    User create(User userToCreate);

    int deleteByEmail(String email);

    int deleteById(String id);
}
