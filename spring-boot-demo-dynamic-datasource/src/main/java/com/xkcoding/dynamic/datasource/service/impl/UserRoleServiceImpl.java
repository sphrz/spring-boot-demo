package com.xkcoding.dynamic.datasource.service.impl;

import com.xkcoding.dynamic.datasource.mapper.UserMapper;
import com.xkcoding.dynamic.datasource.model.User;
import com.xkcoding.dynamic.datasource.service.UserRoleService;
import com.xkcoding.dynamic.datasource.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class UserRoleServiceImpl implements UserRoleService {
    private final UserService userService;

    @Override
    public int save(User u) {
        return userService.save(u);
    }

    @Override
    public int delete(User u) {
        return userService.delete(u);
    }

    @Override
    public int update(User u) {
        return userService.update(u);
    }

    @Override
    public List<User> selectAll() {
        User u = new User ();
        u.setName("数据库用户");
        userService.save(u);


        return userService.selectAll();
    }
}
