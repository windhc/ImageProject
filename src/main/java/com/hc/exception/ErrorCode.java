package com.hc.exception;


/**
 * @author windhc
 */
public enum ErrorCode {

    NO_DATA_FOUND(1001, "数据未找到"),
    DATA_EXIST(1002, "数据已存在"),
    DATA_MODIFIED(1003, "数据已被修改"),
    DATA_REMOVED(1004, "数据已被移除"),
    DATA_ADD_FAILED(1005, "数据添加失败"),
    DATA_UPDATE_FAILED(1006, "数据更新失败"),
    DATA_DELETE_FORBID(1007, "数据禁止删除");

    private Integer code;

    private String message;

    ErrorCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public Integer getCode() {
        return code;
    }
}
