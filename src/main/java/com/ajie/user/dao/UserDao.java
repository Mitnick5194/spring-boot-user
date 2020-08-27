package com.ajie.user.dao;

import com.ajie.user.dao.po.UserPO;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserDao {
    @Select("select * from test")
    List<UserPO> listUser();

    @Insert("insert into  test values( #{user.id},#{user.name})")
    @Options(useGeneratedKeys=true, keyProperty="user.id")
    int insert(@Param("user") UserPO user);

    @Update("update test set name=#{user.name} where id=#{user.id}")
    @ResultType(UserPO.class)
    UserPO update(@Param("user") UserPO user);
}
