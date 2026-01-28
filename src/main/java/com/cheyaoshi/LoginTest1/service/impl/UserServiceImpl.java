package com.cheyaoshi.LoginTest1.service.impl;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cheyaoshi.LoginTest1.common.BusinessException;
import com.cheyaoshi.LoginTest1.mapper.UserMapper;
import com.cheyaoshi.LoginTest1.pojo.User;
import com.cheyaoshi.LoginTest1.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserMapper userMapper;
    @Override
    public User userLogin(User user) {
        //1. 参数校验
        validateParam(user);
        String inputName = user.getName();
        String inputPwd = user.getPassword();
        //2 数据库查询
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("name", inputName); // 找name列等于inputName的那一行数据
        // 查询数据库
        User dbUser = userMapper.selectOne(wrapper);
        // 3 业务逻辑
        //用户不存在
        if (dbUser == null) {
            throw new BusinessException("用户不存在");
        }
        //密码错误
        //数据库里的密码(dbUser.getPassword())和用户输入的(inputPwd) 比对
        if (!dbUser.getPassword().equals(inputPwd)) {
            throw new BusinessException("密码错误");
        }
        //登录成功
        //返回给前端之前，把密码擦除(null)，防止泄露
        dbUser.setPassword(null);
        // 返回数据库里查出来的完整用户信息
        return dbUser;
    }
//    @Override
//    public User getUser(User user) {
//        // 校验用户名
//        // StringUtils.hasText(), 判断字符串是否为空
//        // 取反 (!)——如果没有文字，就报错
//        if (!StringUtils.hasText(user.getName())) {
//            throw new BusinessException("用户名不能为空");
//        }
//        // 校验密码
//        if (!StringUtils.hasText(user.getPassword())) {
//            throw new BusinessException("密码不能为空");
//        }
//        if (user.getName().equals("cheyaoshi") && user.getPassword().equals("123456")){
//            return user;
//        }
//        throw new BusinessException("用户名或密码错误");
//    }
    @Override
    public User userRegister(User user) {
        validateParam(user);
        // 2. 【关键逻辑修正】校验用户名是否已存在
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(User::getName, user.getName());
        Long count = userMapper.selectCount(wrapper);
        if (count > 0) {
            throw new BusinessException("用户名已存在，请更换");
        }
        userMapper.insert(user);
        user.setPassword(null);
        return user;
    }
    //参数校验
    private void validateParam(User user){
        if (!StringUtils.hasText(user.getName())) {
            throw new BusinessException("用户名不能为空");
        }
        if (!StringUtils.hasText(user.getPassword())) {
            throw new BusinessException("密码不能为空");
        }
    }
}
