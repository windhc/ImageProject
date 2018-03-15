package com.hc.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * @author windhc
 */
@ControllerAdvice(annotations = RestController.class)
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(RestExceptionHandler.class);

    /**
     * 方法参数无效
     */
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException e, HttpHeaders headers,
            HttpStatus status, WebRequest request) {

        BindingResult bindingResult = e.getBindingResult();
        String message = null;
        if (bindingResult.hasGlobalErrors()) {
            message = bindingResult.getGlobalError().getDefaultMessage();
        } else if (bindingResult.hasFieldErrors()) {
            message = bindingResult.getFieldError().getDefaultMessage();
        } else {
            throw new IllegalArgumentException("Can not find any errors of BindingResult " + bindingResult);
        }
        RestErrorResponse response = new RestErrorResponse(1000, message);
        return ResponseEntity.status(status).body(response);
    }

    /**
     * 键重复
     */
    @ExceptionHandler(DuplicateKeyException.class)
    public ResponseEntity<?> handleDuplicateKeyException(DuplicateKeyException e) {
        return handleRestException(new ServiceException(HttpStatus.CONFLICT, ErrorCode.DATA_EXIST, e.getMessage()));
    }

    /**
     * 处理ServiceException
     * @param e 处理ServiceException
     * @return ResponseEntity
     */
    @ExceptionHandler(ServiceException.class)
    public ResponseEntity<?> handleRestException(ServiceException e) {
        if (e.getCode() == null) {
            return ResponseEntity.status(e.getStatus()).build();
        } else {
            return RestErrorResponse.createErrorResponseEntity(e);
        }
    }

    /**
     * 用于处理所有4xx，5xx的HttpStatus Code
     * @param e HttpStatusCodeException
     * @return ResponseEntity<RestErrorResponse>
     */
    @ExceptionHandler(HttpStatusCodeException.class)
    public ResponseEntity<?> handleHttpErrorException(HttpStatusCodeException e) {
        String message = "服务器正在打瞌睡，请稍后再试";

        if (e.getStatusCode().is5xxServerError()) {
            LOGGER.error(message, e);
        } else if (!StringUtils.isEmpty(message)) {
            LOGGER.warn(message);
        }
        return RestErrorResponse.createErrorResponseEntity(0, message, e.getStatusCode());
    }
}
