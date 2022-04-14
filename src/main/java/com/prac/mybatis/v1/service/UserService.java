package com.prac.mybatis.v1.service;

import com.prac.mybatis.v1.dto.UserDto;
import com.prac.mybatis.v1.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
@Slf4j
public class UserService {

    private final UserMapper userMapper;

    @Transactional(readOnly = true)
    public List<UserDto> findAll() {
        return userMapper.findAll();
    }


    @Transactional(readOnly = true)
    public UserDto findById(Long id) {
        return userMapper.findById(id);
    }

    @Transactional
    public void save(UserDto userDto) {

        userMapper.save(userDto.getName(), userDto.getAge());

    }
}
