package com.ssoptimus.sos.controller;

import com.ssoptimus.sos.advice.exception.NoAuthException;
import com.ssoptimus.sos.models.response.CommonResult;
import com.ssoptimus.sos.service.ResponseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

// @RestControllerAdvice 전역(값으로 리턴 ) @ControllerAdvice 전역(뷰리졸버를 통해 화면으로 리턴)
// @ExceptionHandler, controller 내 예외처리
@RestControllerAdvice
public class ExceptionController {

    private final ResponseService responseService;

    @Autowired
    public ExceptionController(ResponseService responseService) {
        this.responseService = responseService;
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    private CommonResult IllegalArgumentException (){
        return responseService.getfailResult();
    }



    @ExceptionHandler(NullPointerException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    private CommonResult nullPointerException (){
        return responseService.getfailResult();
    }


    @ExceptionHandler(NoAuthException.class)
    private CommonResult NoAuthException(HttpRequest request,NoAuthException e){
        return responseService.getfailResult();
    }
}
