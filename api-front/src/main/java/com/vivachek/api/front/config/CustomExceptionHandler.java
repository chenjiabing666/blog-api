package com.vivachek.api.front.config;

import com.vivachek.core.domain.rs.ResultResponse;
import com.vivachek.core.exception.ServiceException;
import com.vivachek.core.utils.ResultResponseUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @Description TODO
 * @Author CJB
 * @Date 2020/3/9 23:23
 */
@RestControllerAdvice
@Slf4j
public class CustomExceptionHandler {

    @ExceptionHandler(value = {ServiceException.class})
    public ResultResponse onException(ServiceException ex){
      log.error(ex.getMessage());
      return ResultResponseUtils.resultSucess(ex.getCode(),ex.getMessage());
    }

    @ExceptionHandler(value = {Exception.class})
    public ResultResponse onException(Exception ex){
        log.error(ex.getMessage());
        return ResultResponseUtils.resultSucess(ex.getMessage());
    }

}