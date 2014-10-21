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
package com.xvdiff.infinity.net.api.dto;

import java.util.Date;

public class Board {

    private String      _uri;
    private String      _title;
    private String      _subtitle;
    private Date        _creationTime;
    private boolean     _isIndexed;
    private int         _postsPerHour;
    private int         _postsPerDay;
    private int         _totalPosts;
    private int         _uniqueIps;
    private String      _imgUrl;

    public String getUri() {
        return _uri;
    }

    public String getTitle() {
        return _title;
    }

    public String getSubtitle() {
        return _subtitle;
    }

    public Date getCreationTime() {
        return _creationTime;
    }

    public boolean getIsIndexed() {
        return _isIndexed;
    }

    public int getPostsPerHour() {
        return _postsPerHour;
    }

    public int getPostsPerDay() {
        return _postsPerDay;
    }

    public int getUniqueIps() {
        return _uniqueIps;
    }

    public int getTotalPosts() {
        return _totalPosts;
    }

    public String getImageUrl() {
        return _imgUrl;
    }

}
