package com.cheyaoshi.LoginTest1.pojo;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("user")   //指定数据库中的表名为 "user"
public class User {
    // 指定主键为id，type = IdType.AUTO 代表数据库自增
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    private String name;
    private String password;
}

