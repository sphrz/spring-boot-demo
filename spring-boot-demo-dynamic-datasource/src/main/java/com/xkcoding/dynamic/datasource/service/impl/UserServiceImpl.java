package com.xkcoding.dynamic.datasource.service.impl;

import com.xkcoding.dynamic.datasource.mapper.UserMapper;
import com.xkcoding.dynamic.datasource.model.User;
import com.xkcoding.dynamic.datasource.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class UserServiceImpl implements UserService {
    private final UserMapper userMapper;

    @Override
    public int save(User u) {
        return userMapper.insert(u);
    }

    @Override
    public int delete(User u) {
        return userMapper.delete(u);
    }

    @Override
    public int update(User u) {
        return userMapper.updateByPrimaryKeySelective(u);
    }

    @Override
    public List<User> selectAll() {
        return userMapper.selectAll();
    }
}
