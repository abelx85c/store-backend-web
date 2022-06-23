package com.store.service.ex;

/**
 * @檔案名稱: PasswordNotMatchException
 * @創建者:
 * @創建日期: 2022-06-23 16:28
 * @編輯器: IntelliJ IDEA
 * @用途: 密碼不符
 * @參數:
 * @回傳值:
 */
public class PasswordNotMatchException extends ServiceException{
    public PasswordNotMatchException() {
        super();
    }

    public PasswordNotMatchException(String message) {
        super(message);
    }

    public PasswordNotMatchException(String message, Throwable cause) {
        super(message, cause);
    }

    public PasswordNotMatchException(Throwable cause) {
        super(cause);
    }

    protected PasswordNotMatchException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
