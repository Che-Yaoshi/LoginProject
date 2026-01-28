package com.cheyaoshi.LoginTest1.common;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
@RestControllerAdvice
@Slf4j
    public class GlobalExceptionHandler {
        // 处理业务异常 → 400
//        @ExceptionHandler(BusinessException.class)
//        public ResponseEntity<Result> handleBusiness(BusinessException e) {
//            log.warn("业务异常: {}", e.getMessage());
//            return ResponseEntity.badRequest().body(Result.error(e.getMessage()));
//        }
        @ExceptionHandler(BusinessException.class)
        public Result<?> handleBusinessException(BusinessException e) {
            log.warn("业务拦截: {}", e.getMessage());
            // 直接返回错误信息，HTTP状态码依然是 200 (由前端判断 code=400)
            return Result.error(e.getMessage());
        }
        // 兜底处理其他异常 → 500
//        @ExceptionHandler(Exception.class)
//        public ResponseEntity<Result> handleUnexpected(Exception e) {
//            log.error("系统异常", e);
//            return ResponseEntity.status(500).body(Result.error("系统繁忙，请稍后再试"));
//        }
//    }
        @ExceptionHandler(Exception.class)
        public Result<?> handleException(Exception e) {
            log.error("系统异常: ", e); // 打印完整堆栈信息到控制台，方便排错
            return Result.error("系统繁忙，请联系管理员"); // 给用户看友好的提示，不要把报错细节暴露给用户
        }
}
