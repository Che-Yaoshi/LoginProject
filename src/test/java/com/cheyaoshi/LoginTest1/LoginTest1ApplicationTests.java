package com.cheyaoshi.LoginTest1;

import com.cheyaoshi.LoginTest1.mapper.UserMapper;
import com.cheyaoshi.LoginTest1.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class LoginTest1ApplicationTests {
    @Autowired
    private UserMapper UserMapper;

    @Test
    void testSelect() {
        System.out.println(("----- selectAll method test ------"));
        // selectList(null) 表示查询所有，条件为 null
        List<User> userList = UserMapper.selectList(null);
        userList.forEach(System.out::println);
        // 如果控制台打印出了刚才插入的 admin 用户，说明持久层打通了！
    }
}
