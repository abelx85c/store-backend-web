package com.store.mapper;

import com.store.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
  Integer insert(User user);

  User findByUsername(String username);
}
