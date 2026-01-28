package com.cheyaoshi.LoginTest1.controller;
import com.cheyaoshi.LoginTest1.common.BusinessException;
import com.cheyaoshi.LoginTest1.common.Result;
import com.cheyaoshi.LoginTest1.pojo.User;
import com.cheyaoshi.LoginTest1.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j // 1. 启用日志工具
@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "*") // 允许前端域名
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping("/login")
    public Result login(@RequestBody User user) {
        //如果在Controller里手动捕获异常，异常就不会到达GlobalExceptionHandler
        //应该让Controller 只管调业务，不做任何异常捕获，有异常就直接到GlobalExceptionHandler
        User loginUser = userService.userLogin(user);
        return Result.success(loginUser);
    }
    @PostMapping("/register")
    public Result register(@RequestBody User user) {
        return Result.success(userService.userRegister(user));
    }
}
