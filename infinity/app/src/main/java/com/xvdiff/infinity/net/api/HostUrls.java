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
package com.xvdiff.infinity.net.api;

import com.xvdiff.infinity.utils.StringUtils;

public final class HostUrls {

    private static final String URI_DELIMITER   = "/";

    private static final String HOST            =   "8chan.co";
    private static final String EXT_JSON        =   "json";
    private static final String EXT_PHP         =   "php";
    private static final String EXT_PNG         =   "png";
    private static final String EXT_HTML        =   "html";

    private static final String KEY_RESOURCE    =   "res";
    private static final String KEY_CATALOG     =   "catalog";
    private static final String KEY_BOARDS      =   "boards";
    private static final String KEY_THREADS     =   "threads";
    private static final String KEY_SOURCE      =   "src";
    private static final String KEY_CREATE      =   "create";
    private static final String KEY_THUMBNAIL   =   "thumb";
    private static final String KEY_STATIC      =   "static";
    private static final String KEY_SPOILER     =   "spoiler";
    private static final String KEY_DELETED     =   "deleted";
    private static final String KEY_FLAGS       =   "flags";

    private static String _scheme;

    public static void setUseSsl(boolean useSsl) {
        _scheme = useSsl ? "https://" : "http://";
    }

    public static String getSpoilerImageUrl() {
        return getApiResource(EXT_PNG, KEY_STATIC, KEY_SPOILER);
    }

    public static String getDeletedImageUrl() {
        return getApiResource(EXT_PNG, KEY_STATIC, KEY_DELETED);
    }

    public static String getCountryFlagUrl(String country) {
        return getApiResource(EXT_PNG, KEY_STATIC, KEY_FLAGS, country);
    }

    public static String getImageUrl(String board, int imageId, String extension) {
        return getApiResource(extension, board, KEY_SOURCE, Integer.toString(imageId));
    }

    public static String getThumbnailUrl(String board, int imageId, String extension) {
        return getApiResource(extension, board, KEY_THUMBNAIL);
    }

    public static String getBoardCreateUrl() {
        return getApiResource(EXT_PHP, KEY_CREATE);
    }

    public static String getThreadsByPageUrl(String board, int pageNumber) {
        return getApiJsonResource(board, Integer.toString(pageNumber));
    }

    public static String getCatalogUrl(String board) {
        return getApiJsonResource(board, KEY_CATALOG);
    }

    public static String getThreadsUrl(String board) {
        return getApiJsonResource(board, KEY_THREADS);
    }

    public static String getBoardsUrl() {
        return getApiJsonResource(KEY_BOARDS);
    }

    public static String getThreadUrl(String board, int threadNumber) {
        return getApiJsonResource(board, KEY_RESOURCE,
            Integer.toString(threadNumber));
    }

    private static String getApiJsonResource(String ...values) {
        return getApiResource(EXT_JSON, values);
    }

    private static String getApiResource(String extension, String ...values) {
        return _scheme + HOST + StringUtils.join(URI_DELIMITER, values) + "." + extension;
    }

}
