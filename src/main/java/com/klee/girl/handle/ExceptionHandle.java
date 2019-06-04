package com.klee.girl.handle;

import com.klee.girl.domain.Result;
import com.klee.girl.exception.GirlException;
import com.klee.girl.utils.ResultUtil;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.valueextraction.ExtractedValue;

@ControllerAdvice
public class ExceptionHandle {

    //要捕获的异常类
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result handle(Exception e) {

        if (e instanceof GirlException) {
            GirlException girlException = (GirlException) e;
            return ResultUtil.error(girlException.getCode(), girlException.getMessage());
        }
        return ResultUtil.error(-1, "未知错误");
    }

}
