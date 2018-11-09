package com.zr.common;

import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.UnauthorizedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.UnsatisfiedServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;


@RestControllerAdvice
public class ExceptionHandlerAdvice {

    private static final Logger log = LoggerFactory.getLogger("adminLogger");

    @ExceptionHandler({IllegalArgumentException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseBean badRequestException(IllegalArgumentException exception) {
        log.error(exception.getMessage());
        return new ResponseBean(HttpStatus.BAD_REQUEST.value() + "", exception.getMessage());
    }

    @ExceptionHandler({UnknownAccountException.class, IncorrectCredentialsException.class})
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public ResponseBean loginException(Exception exception) {
        log.error(exception.getMessage());
        return new ResponseBean(HttpStatus.UNAUTHORIZED.value() + "", exception.getMessage());
    }

    @ExceptionHandler({UnauthorizedException.class})
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public ResponseBean forbidden(Exception exception) {
        log.error(exception.getMessage());
        return new ResponseBean(HttpStatus.FORBIDDEN.value() + "", exception.getMessage());
    }

    @ExceptionHandler({MissingServletRequestParameterException.class, HttpMessageNotReadableException.class,
            UnsatisfiedServletRequestParameterException.class, MethodArgumentTypeMismatchException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseBean badRequestException(Exception exception) {
        log.error(exception.getMessage());
        return new ResponseBean(HttpStatus.BAD_REQUEST.value() + "", exception.getMessage());
    }

    @ExceptionHandler(Throwable.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseBean exception(Throwable throwable) {
        throwable.printStackTrace();
        log.error("系统异常", throwable);
        return new ResponseBean(HttpStatus.INTERNAL_SERVER_ERROR.value() + "", throwable.getMessage() == null ? "空指针异常" : throwable.getMessage());
    }

}
