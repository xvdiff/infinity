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

import com.android.volley.Response;
import com.google.gson.reflect.TypeToken;
import com.xvdiff.infinity.net.MappedRequest;
import com.xvdiff.infinity.net.api.dto.Board;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Map;

public class BoardsRequest extends MappedRequest<ArrayList<Board>> {

    public BoardsRequest(Response.Listener<ArrayList<Board>> listener, Response.ErrorListener errorListener) {
        super(HostUrls.getBoardsUrl(), new TypeToken<ArrayList<Board>>(){}.getType(), null, listener, errorListener);
    }

}
