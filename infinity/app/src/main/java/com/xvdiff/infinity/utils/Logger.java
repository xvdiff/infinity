/*
 * ∞ (infinity) - 8chan browser for Android - https://github.com/xvdiff/infinity
 * Copyright (c) 2014 xvdiff
 *
 * This program is distributed as free software: You are free to redistribute
 * and/or modify it under the terms of the Apache License v2.0
 *
 * You should have received a copy of the Apache License Version 2.0, January 2004
 * along with this program.  If not, see <http://www.apache.org/licenses/LICENSE-2.0/>.
 *
 */

package com.xvdiff.infinity.utils;

import android.util.Log;

import com.xvdiff.infinity.BuildConfig;


public final class Logger {

    public static void error(String tag, String message) {
        Log.e(tag, message);
    }

    public static void error(String tag, String format, Object ...objects) {
        error(tag, String.format(format, objects));
    }

    public static void error(String tag, String message, Throwable throwable) {
        error(tag, String.format("[%s] %s: %s", throwable.getClass().getName(),
                message, throwable.getMessage()));
    }

    public static void info(String tag, String message) {
        Log.i(tag, message);
    }

    public static void info(String tag, String format, Object ...objects) {
        info(tag, String.format(format, objects));
    }

    public static void debug(String tag, String message) {
        if(BuildConfig.DEBUG)
            Log.d(tag, message);
    }

    public static void debug(String tag, String format, Object ...objects) {
        debug(tag, String.format(format, objects));
    }

}
