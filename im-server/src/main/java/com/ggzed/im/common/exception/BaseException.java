package com.ggzed.im.common.exception;

/**
 * @author: ggzed
 * @date: 2024/2/21 15:35
 * @description: 账户不存在异常
 */
import com.ggzed.im.common.result.ResultEnum;
import lombok.Getter;

@Getter
public class BaseException extends RuntimeException {
    private final ResultEnum resultEnum;

    public BaseException(ResultEnum resultEnum) {
        this.resultEnum = resultEnum;
    }
}
