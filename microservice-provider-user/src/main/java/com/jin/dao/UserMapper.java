package com.jin.dao;


import com.jin.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    User Sel(int id);
}
