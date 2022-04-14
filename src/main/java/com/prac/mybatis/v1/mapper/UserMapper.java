package com.prac.mybatis.v1.mapper;

import com.prac.mybatis.v1.dto.UserDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
public interface UserMapper {

    List<UserDto> findAll();

    UserDto findById(Long id);

    void save(@Param("name") String name, @Param("age") int age);


}
