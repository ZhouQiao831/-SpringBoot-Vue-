package com.example.jsfspringboot.mapper;

import com.example.jsfspringboot.dao.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Mapper
public interface UserMapper {
  @Select("select * from user where username=#{username} and password=#{password}")
    List<User> select(String username,String password);

}
