package com.turong.profile.convert;

import com.turong.profile.controller.ProfileResponse;
import com.turong.profile.controller.ProfileSaveRequest;
import com.turong.profile.entity.Profile;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProfileConvert {

    Profile toProfile(final ProfileSaveRequest profileSaveRequest);

    ProfileResponse toResponse(final Profile profile);

}
