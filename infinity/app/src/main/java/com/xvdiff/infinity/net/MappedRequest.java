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
package com.xvdiff.infinity.net;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.JsonRequest;
import com.android.volley.Response.*;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.xvdiff.infinity.utils.Mapper;
import com.xvdiff.infinity.utils.Logger;

import java.io.UnsupportedEncodingException;
import java.util.Map;

public class MappedRequest<T> extends Request<T> {

    private static final String TAG = "MappedRequest{T}";

    private final Gson gson = new Gson();
    private final Class<T> clazz;
    private final Map<String, String> headers;
    private final Listener<T> listener;

    public MappedRequest(String url, Class<T> clazz, Map<String, String> headers,
                      Listener<T> listener, ErrorListener errorListener) {
        super(Method.GET, url, errorListener);

        Logger.debug(TAG, "Starting new request on %s for %s", url, clazz.getName());
        this.clazz = clazz;
        this.headers = headers;
        this.listener = listener;
    }

    @Override
    public Map<String, String> getHeaders() throws AuthFailureError {
        return headers != null ? headers : super.getHeaders();
    }

    @Override
    protected void deliverResponse(T response) {
        listener.onResponse(response);
    }

    @Override
    protected Response<T> parseNetworkResponse(NetworkResponse response) {
        try {
            Logger.debug(TAG, "Parse network response...");
            String json = new String(
                    response.data, HttpHeaderParser.parseCharset(response.headers));
            return Response.success(
                    gson.fromJson(json, clazz), HttpHeaderParser.parseCacheHeaders(response));
        } catch (UnsupportedEncodingException e) {
            Logger.error(TAG, "Parsing network response failed - unsupported encoding", e);
            return Response.error(new ParseError(e));
        } catch (JsonSyntaxException e) {
            Logger.error(TAG, "Parsing network response failed - invalid json syntax", e);
            return Response.error(new ParseError(e));
        }
    }

}
