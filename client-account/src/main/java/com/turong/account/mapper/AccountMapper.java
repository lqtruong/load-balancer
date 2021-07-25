package com.turong.account.mapper;

import com.turong.account.entity.Account;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.Optional;

public interface AccountMapper {

    @Select("select * from accounts where id = #{id}")
    Optional<Account> findAccount(final String id);

    @Insert("insert into accounts(fullname,email,dob) values(#{fullname},#{email},#{dob})")
    int insert(final Account accountToCreate);

    @Select("select * from accounts where email = #{email}")
    Optional<Account> findAccountByEmail(final String email);

    @Delete("delete from accounts where email = #{email}")
    int deleteByEmail(final String email);

    @Delete("delete from accounts where id = #{id}")
    int deleteById(String id);
}
