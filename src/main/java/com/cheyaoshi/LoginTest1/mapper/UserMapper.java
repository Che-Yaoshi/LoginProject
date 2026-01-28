package com.cheyaoshi.LoginTest1.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cheyaoshi.LoginTest1.pojo.User;

@org.apache.ibatis.annotations.Mapper
public interface UserMapper extends BaseMapper<User> {
        // 继承BaseMapper后，这里暂时不需要写任何代码
        // 已经自动拥有了对User表的CRUD能力
}
