package com.basecore.library.logger;

import android.content.Context;
import android.util.Log;

import com.basecore.library.BuildConfig;
import com.basecore.library.logger.source.Logger;

import java.util.HashMap;


public class LogUtil {

    private Context mContext;

    private static boolean isLogger = BuildConfig.DEBUG;    //是否打日志，默认debug模式下输出日志，release版本则默认关闭
    private static boolean isLoggerFormat = false;      //是否输出Logger格式的日志
    private static HashMap<String, Long> oldTimeMap = new HashMap<String, Long>();


    /**
     * 设置日志开关 测试状态为打开， 线上可以通过设置来打开log
     *
     * @param logger
     */
    public static void setLogger(boolean logger) {
        isLogger = logger;
    }

    /***
     * 设置开关，是否输出Logger格式的日志
     *
     * @param isLoggerFormat
     */
    public static void setLoggerFormat(boolean isLoggerFormat) {
        LogUtil.isLoggerFormat = isLoggerFormat;
    }

    /**
     * @param yourName 你的名字，避免与其他人统计区分
     * @param message
     */
    public static void d(String yourName, String message) {
        if (isLogger) {
            if (isLoggerFormat) {
                Logger.t(yourName).d(message);
            } else {
                Log.d(yourName, message + " - tag:" + yourName);
            }
        }
    }

    /**
     * @param yourName 你的名字，避免与其他人统计区分
     * @param message
     */
    public static void v(String yourName, String message) {
        if (isLogger) {
            if (isLoggerFormat) {
                Logger.t(yourName).v(message);
            } else {
                Log.v(yourName, message + " - tag:" + yourName);
            }
        }
    }

    /**
     * @param yourName 你的名字，避免与其他人统计区分
     * @param message
     */
    public static void e(String yourName, String message) {
        if (isLogger) {
            if (isLoggerFormat) {
                Logger.t(yourName).e(message);
            } else {
                Log.e(yourName, message + " - tag:" + yourName);
            }
        }
    }

    /**
     * @param yourName 你的名字，避免与其他人统计区分
     * @param message
     */
    public static void e(String yourName, Throwable throwable, String message) {
        if (isLogger) {
            if (isLoggerFormat) {
                Logger.t(yourName).e(throwable, message);
            } else {
                Log.e(yourName, message + " - tag:" + yourName, throwable);
            }
        }
    }


    /**
     * @param yourName 你的名字，避免与其他人统计区分
     * @param message
     */
    public static void w(String yourName, String message) {
        if (isLogger) {
            if (isLoggerFormat) {
                Logger.t(yourName).w(message);
            } else {
                Log.w(yourName, message + " - tag:" + yourName);
            }
        }
    }

    /**
     * @param yourName 你的名字，避免与其他人统计区分
     * @param message
     */
    public static void i(String yourName, String message) {
        if (isLogger) {
            if (isLoggerFormat) {
                Logger.t(yourName).i(message);
            } else {
                Log.i(yourName, message + " - tag:" + yourName);
            }
        }
    }

    /**
     * @param yourName 你的名字，避免与其他人统计区分
     * @param message
     */
    public static void wtf(String yourName, String message) {
        if (isLogger) {
            if (isLoggerFormat) {
                Logger.t(yourName).wtf(message);
            } else {
                Log.wtf(yourName, message + " - tag:" + yourName);
            }
        }
    }

    /**
     * @param yourName 你的名字，避免与其他人统计区分
     * @param message
     */
    public static void timePoint(String yourName, String message) {
        if (isLogger) {
            Long currentTime = System.currentTimeMillis();
            Long oldTimeTemp = oldTimeMap.get(yourName);
            if (oldTimeTemp == null) {
                oldTimeTemp = System.currentTimeMillis();
            }
            Long durationTime = currentTime - oldTimeTemp;
            if (isLoggerFormat) {
                Logger.t(yourName).v(message + " durationTime:" + durationTime);
            } else {
                Log.v(yourName, message + " durationTime:" + durationTime + " - tag:" + yourName);
            }
            oldTimeTemp = currentTime;
            oldTimeMap.put(yourName, oldTimeTemp);
        }
    }

    public static void json(String json) {
        if (isLogger && isLoggerFormat) {
            Logger.json(json);
        }
    }

    public static void xml(String xml) {
        if (isLogger && isLoggerFormat) {
            Logger.xml(xml);
        }
    }

}
