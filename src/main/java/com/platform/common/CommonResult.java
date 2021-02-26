package com.platform.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> {

    private Integer code;

    private String message;

    private T data;

    public CommonResult(Integer code, String message) {
        this(code, message, null);
    }

    public static <T> CommonResult<T> success(T data) {
        return new <T>CommonResult(200, "成功", data);
    }

    public static CommonResult success() {
        return new CommonResult(200, "成功", null);
    }

}
