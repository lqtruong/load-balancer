package com.turong.profile.convert;

import com.turong.profile.controller.UserResponse;
import com.turong.profile.controller.UserSaveRequest;
import com.turong.profile.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserConvert {

    User toUser(final UserSaveRequest userSaveRequest);

    UserResponse toResponse(final User user);

}
