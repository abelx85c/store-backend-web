package com.store.mapper;

import com.store.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;

@Mapper
public interface UserMapper {

  Integer insert(User user);

  User findByUsername(String username);

  Integer updatePasswordByUid(
          @Param("uid") Integer uid,
          @Param("password") String password,
          @Param("modifiedUser") String modifiedUser,
          @Param("modifiedTime") Date modifiedTime
  );

  User findByUid(Integer uid);
}
