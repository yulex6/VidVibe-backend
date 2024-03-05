package com.example.vidvibebackend.Entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.io.Serializable;

/**
 * @author Zhenliang Yu
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseResult<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    // 状态码，0通常表示成功，非0为错误代码
    private int code;

    // 提示信息或错误信息
    private String message;

    // 数据内容，根据实际需要设置具体的类型T
    private T data;

    public ResponseResult() {}

    // 成功时构造函数
    public ResponseResult(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    // 创建一个用于成功的默认实例
    public static <T> ResponseResult<T> success(T data) {
        return new ResponseResult<>(0, "操作成功", data);
    }

    // 创建一个失败的默认实例
    public static <T> ResponseResult<T> fail(int code, String message) {
        return new ResponseResult<>(code, message, null);
    }
}