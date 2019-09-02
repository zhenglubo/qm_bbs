package com.bbs.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @description: 错误码
 * @author: zhenglubo
 * @create: 2019-05-16 09:57
 **/
@Getter
@AllArgsConstructor
public enum ErrorCode {

    SUCCESS_CODE(200, "Success","Response Ok"),
    FAIL_CODE(1, "Fail","Request fail"),
    BAD_REQUEST(400, "Bad Request","Bad Request"),
    NOT_AUTHORIZATION(401, "NotAuthorization","NotAuthorization"),
    NOT_FOUND_REQUEST(404, "Not Found Request Path","Not Found Request Path"),
    METHOD_NOT_ALLOWED(405, "Method Not Allowed","Method Not Allowed"),
    NOT_ACCEPTABLE(406, "Not Acceptable","Not Acceptable"),
    INTERNAL_SERVER_ERROR(500, "Internal Server Error","Internal Server Error"),

    LOGIN_FIRST(999, "Please Log In First","Please Log In First"),
    NUMBER_FORMAT_EXCEPTION(900,"Number Format Exception","Number Format Exception"),
    ARITHMETIC_EXCEPTION(901,"Arithmetic Exception","Arithmetic Exception"),
    ARRAY_INDEX_OUT_OF_BOUNDS_EXCEPTION(902,"Array IndexOutOfBounds Exception","Array IndexOutOfBounds Exception"),
    RUNTIME_EXCEPTION(1000, "Server RunTimeException","Server RunTimeException"),
    NULL_POINTER_EXCEPTION(1001, "Server NullPointerException","Server NullPointerException"),
    CLASS_CAST_EXCEPTION(1002, "Server ClassCastException","Server ClassCastException"),
    IO_EXCEPTION(1003, "Server IOException","Server IOException"),
    NO_SUCH_METHOD_EXCEPTION(1004, "Server NoSuchMethodException","Server NoSuchMethodException"),
    INDEX_OUT_OF_BOUNDS_EXCEPTION(1005, "Server IndexOutOfBoundsException","Server IndexOutOfBoundsException"),
    CONNECT_EXCEPTION(1006, "Server ConnectException","Server ConnectException"),
    ERROR_MEDIA_TYPE(1007, "Content-type Error","Content-type Error"),
    EMPTY_REQUEST_BOYD(1008, "Params Body Can Not Empty","Params Body Can Not Empty"),
    ERROR_REQUEST_BOYD(1009, "Params Body Error","Params Body Error"),
    ERROR_VERSION(2000, "Version Error","Version Error"),
    ERROR_FORMAT_PARAMETER(2001, "Parameter Format Error","Parameter Format Error"),
    FILE_NOT_FOUND_EXCEPTION(2002,"File Not Found Exception","文件未发现异常"),
    TIMEOUT_EXCEPTION(2003,"timeout exception","超时异常");
    private int code;
    private String msg;
    private String realMsg;
}
