package com.lsdd.exception;

import com.lsdd.entity.ResultCode;
import com.lsdd.entity.ResultVO;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * 全局异常处理 异常返回统一影响体
 */
@ControllerAdvice
public class DefaultExceptionHandler {

/*
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResultVO<String> defalut(Exception e) {
        //传递响应码枚举
        return new ResultVO<>(ResultCode.FAILED, e.getMessage());
    }*/

    @ExceptionHandler(Exception.class)
    public ModelAndView  defalut(Exception e) {
        ModelAndView modelAndView=new ModelAndView("status/404");
        //传递响应码枚举
        ResultVO<String> resultVO=new ResultVO<>(ResultCode.FAILED, e.getMessage());
        modelAndView.addObject("resultVO",resultVO);
        return modelAndView;
    }



    /*@ExceptionHandler(MethodArgumentNotValidException.class)
    public ResultVO<String> MethodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e){
        //从异常对象中拿到ObjectError对象
        ObjectError objectError=e.getBindingResult().getAllErrors().get(0);
        //提取错误信息进行返回
        //传递响应码枚举
        return new ResultVO<>(ResultCode.VALIDATE_FAILED,objectError.getDefaultMessage());
    }*/

}
