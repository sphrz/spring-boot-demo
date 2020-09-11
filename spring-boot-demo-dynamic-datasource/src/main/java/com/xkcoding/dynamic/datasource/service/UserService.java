package com.xkcoding.dynamic.datasource.service;

import com.xkcoding.dynamic.datasource.model.User;

import java.util.List;

/**
 * @author shenpeng
 */
public interface UserService {

    int save(User u);
    int delete(User u);
    int update(User u);
    List<User> selectAll();
}
