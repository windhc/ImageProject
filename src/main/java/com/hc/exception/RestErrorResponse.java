package com.hc.exception;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 * rest错误消息
 * @author windhc
 * @date 2017/5/6
 */
public class RestErrorResponse {

    private final int code;

    private final String message;

    @JsonCreator
    public RestErrorResponse(@JsonProperty("code") int code, @JsonProperty("message") String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public static ResponseEntity<RestErrorResponse> createErrorResponseEntity(ServiceException e) {
        return createErrorResponseEntity(e.getCode(), e.getMessage(), e.getStatus());
    }

    public static ResponseEntity<RestErrorResponse> createErrorResponseEntity(int code, String message, HttpStatus statusCode) {
        return new ResponseEntity<>(new RestErrorResponse(code, message), statusCode);
    }
}
