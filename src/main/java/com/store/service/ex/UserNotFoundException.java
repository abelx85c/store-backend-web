package com.store.service.ex;

/**
 * @檔案名稱: UserNotFoundException
 * @創建者:
 * @創建日期: 2022-06-23 16:29
 * @編輯器: IntelliJ IDEA
 * @用途: 使用者不存在
 * @參數:
 * @回傳值:
 */
public class UserNotFoundException extends ServiceException{
    public UserNotFoundException() {
        super();
    }

    public UserNotFoundException(String message) {
        super(message);
    }

    public UserNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserNotFoundException(Throwable cause) {
        super(cause);
    }

    protected UserNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
