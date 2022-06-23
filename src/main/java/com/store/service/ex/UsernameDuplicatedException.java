package com.store.service.ex;


/**
 * @檔案名稱: UsernameDuplicatedException
 * @創建者:
 * @創建日期: 2022-06-23 16:29
 * @編輯器: IntelliJ IDEA
 * @用途: 使用者名稱已存在
 * @參數:
 * @回傳值:
 */
public class UsernameDuplicatedException extends ServiceException{

//	private static final long serialVersionUID = 1L;
    
	public UsernameDuplicatedException() {
		super();
	}
	public UsernameDuplicatedException(String message) {
		super(message);
	}
	public UsernameDuplicatedException(String message, Throwable cause) {
		super(message, cause);
	}
	public UsernameDuplicatedException(Throwable cause) {
		super(cause);
	}
	protected UsernameDuplicatedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}
