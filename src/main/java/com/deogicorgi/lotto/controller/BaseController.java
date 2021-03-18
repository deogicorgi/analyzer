package com.deogicorgi.lotto.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;

@Slf4j
public abstract class BaseController {

    public void error(BindingResult result, Object... parameters) {
        for (Object parameter : parameters) {
            log.error("[{}] Parameter binding error occurred. -> Binding parameter : [{}]", getClass().getSimpleName(), parameter);
        }
        result.getFieldErrors()
                .forEach(fieldError -> log.error("[{}] Parameter binding error occurred. -> Object : [{}], Field : [{}], Code : [{}], Binding value : [{}]",
                        getClass().getSimpleName(), fieldError.getObjectName(), fieldError.getField(), fieldError.getCode(), fieldError.getRejectedValue()));
    }
}
