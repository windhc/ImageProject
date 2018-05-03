package com.windhc.exception;

import org.springframework.http.HttpStatus;

/**
 * @author Administrator
 * @date 2015/9/22
 */
public class ServiceException extends RuntimeException {

    private final HttpStatus status;
    private Integer code;

    public ServiceException() {
        this.status = HttpStatus.INTERNAL_SERVER_ERROR;
        this.code=5000;
    }

    public ServiceException(String message) {
        super(message);
        this.status = HttpStatus.INTERNAL_SERVER_ERROR;
        this.code = 1000;
    }

    public ServiceException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.status = HttpStatus.INTERNAL_SERVER_ERROR;
        this.code = errorCode.getCode();
    }

    public ServiceException(HttpStatus status, ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.status = status;
        this.code = errorCode.getCode();
    }

    public ServiceException(HttpStatus status, ErrorCode errorCode, String message) {
        super(message);
        this.status = status;
        this.code = errorCode.getCode();
    }

    public HttpStatus getStatus() {
        return status;
    }

    public Integer getCode() {
        return code;
    }
}
