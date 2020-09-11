package com.xkcoding.dynamic.datasource.controller;

import com.xkcoding.dynamic.datasource.model.User;
import com.xkcoding.dynamic.datasource.service.UserRoleService;
import com.xkcoding.dynamic.datasource.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 用户 Controller
 * </p>
 *
 * @author yangkai.shen
 * @date Created in 2019/9/4 16:40
 */
@RestController
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class UserController {
    private final UserService userService;
    private final UserRoleService userRoleService;

    /**
     * 获取用户列表
     */
    @GetMapping("/userRole")
    public List<User> getUserRoleList() throws InterruptedException {
        return userRoleService.selectAll();
    }

    /**
     * 获取用户列表
     */
    @GetMapping("/user")
    public List<User> getUserList() {
        return userService.selectAll();
    }


}
