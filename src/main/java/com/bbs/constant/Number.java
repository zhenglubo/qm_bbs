package com.bbs.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @description: 数字常量
 * @author: zhenglubo
 * @create: 2019-09-03 17:10
 **/

@Getter
@AllArgsConstructor
public enum Number {

    ONE_YEAR(12),
    ON_MONTH(30),
    ONE_DAY(24),
    ONE_HOUR(60),
    ;

    private int value;

}
