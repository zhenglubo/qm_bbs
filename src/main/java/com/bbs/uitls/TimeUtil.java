package com.bbs.uitls;

import com.bbs.constant.Number;

/**
 * @description: 时间工具类
 * @author: zhenglubo
 * @create: 2019-09-06 09:20
 **/

public class TimeUtil {

    /**计算时间差，用中文表示
     * @param hours
     * @return
     */
    public static String calculateTimeDiff(long hours) {
        String timeDiff;
        if (hours < 1) {
            timeDiff = "刚刚";
        } else if (hours < Number.ONE_DAY.getValue()) {
            timeDiff = hours + "小时前";
        } else if ((hours / Number.ONE_DAY.getValue()) >= 1 && ((hours / Number.ONE_DAY.getValue()) <= Number.ON_MONTH.getValue())) {
            return (hours / Number.ONE_DAY.getValue()) + "天前";
        } else if ((hours / (Number.ONE_DAY.getValue() * Number.ON_MONTH.getValue())) >= 1 && (hours / (Number.ONE_DAY.getValue() * Number.ON_MONTH.getValue())) < Number.ONE_YEAR.getValue()) {
            return (hours / (24 * 30)) + "个月前";
        } else {
            return (hours / (24 * 30 * 12)) + "年前";
        }
        return timeDiff;
    }
}
