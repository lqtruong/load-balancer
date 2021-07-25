package com.turong.profile.mapper;

import com.turong.profile.entity.Profile;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.Optional;

public interface ProfileMapper {

    @Select("select * from profiles where id = #{id}")
    Optional<Profile> findProfile(final String id);

    @Insert("insert into profiles(username,email,app) values(#{username},#{email},#{app})")
    int insert(final Profile profileToCreate);

    @Select("select * from profiles where email = #{email}")
    Optional<Profile> findProfileByEmail(final String email);

    @Delete("delete from profiles where email = #{email}")
    int deleteByEmail(final String email);

    @Delete("delete from profiles where id = #{id}")
    int deleteById(String id);
}
