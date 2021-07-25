package com.turong.profile.mapper;

import com.turong.profile.entity.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.Optional;

public interface UserMapper {

    @Select("select * from profiles where id = #{id}")
    Optional<User> findUser(final String id);

    @Insert("insert into profiles(username,email,app) values(#{username},#{email},#{app})")
    int insert(final User userToCreate);

    @Select("select * from profiles where email = #{email}")
    Optional<User> findUserByEmail(final String email);

    @Delete("delete from profiles where email = #{email}")
    int deleteByEmail(final String email);

    @Delete("delete from profiles where id = #{id}")
    int deleteById(String id);
}
