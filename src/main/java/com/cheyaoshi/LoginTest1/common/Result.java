package com.cheyaoshi.LoginTest1.common;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
public class Result<T> {
    //统一响应结果
    private Integer code;//1成功，0失败
    private String msg; //提不信息
    private T data; //数据 data

    private Result(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
    //成功
    public static <T> Result<T> success(T data) {
        return new Result<>(200, "操作成功", data);
    }
    public static <T> Result<T> success() {
        return success(null);
    }
    // 失败
    public static <T> Result<T> error(String msg) {
        return new Result<>(400, msg, null);
    }
//    public static Result success(Object data){
//        return new Result( 200,"success",data);
//    }
//    public static Result success() {
//        return new Result(200, "success", null);
//    }
//    public static Result error(String msg){
//        return new Result(400,msg,null);
//    }
}
