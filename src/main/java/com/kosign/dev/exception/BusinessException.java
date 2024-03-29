package com.kosign.dev.exception;

import com.kosign.dev.common.api.StatusCode;
import lombok.Getter;

/**
 * Handle exception for Business Exception
 */
@Getter
public class BusinessException extends RuntimeException {

    private final StatusCode errorCode;

    public BusinessException(StatusCode errorCode, String message) {

        super(message);
        this.errorCode = errorCode;

    }
    public BusinessException(StatusCode errorCode) {

        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }
    public BusinessException(StatusCode errorCode, Throwable e) {
        this(errorCode);
//        AppLogManager.error(e);

    }


}