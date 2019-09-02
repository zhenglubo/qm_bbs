package com.bbs.result;

/**
 * @description: DataResultBuild
 * @author: zhenglubo
 * @create: 2019-05-16 10:50
 **/

public class DataResultBuild<T> {

    public static <T> DataResult<T> success() {

        return new DataResult<T>().success();

    }

    public static <T> DataResult<T> success(T data) {
        return new DataResult<T>().success(data);

    }

    public static <T> DataResult<T> fail(String message) {
        return new DataResult<T>().fail(message);

    }

    public static <T> DataResult<T> fail(int status, String info, String message) {
        return new DataResult<T>().fail(status, info, message);

    }
}
