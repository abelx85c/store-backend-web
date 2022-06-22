package com.store.controller;

import com.store.service.ex.InsertException;
import com.store.service.ex.ServiceException;
import com.store.service.ex.UsernameDuplicatedException;
import com.store.util.JsonResult;
import org.springframework.web.bind.annotation.ExceptionHandler;


public class BaseController {
    public static final int ok = 200;

    @ExceptionHandler(ServiceException.class)
    public JsonResult<Void> handleException(Throwable e){
        JsonResult<Void> result = new JsonResult<>(e);
        if(e instanceof UsernameDuplicatedException){
            result.setState(4000);
            result.setMessage("使用者名稱已註冊");
        } else if(e instanceof InsertException){
            result.setState(5000);
            result.setMessage("寫入資料庫異常");
        }
        return result;
    }
}
