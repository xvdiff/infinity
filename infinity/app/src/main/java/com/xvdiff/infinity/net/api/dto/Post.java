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

public class Post {

    private int         _postNumber;
    private int         _replyTo;
    private boolean     _isStickied;
    private boolean     _isLocked;
    private boolean     _isClosed;
    private String      _subject;
    private String      _comment;
    private String      _name;
    private String      _captionCode;
    private String      _tripCode;
    private String      _posterId;
    private Date        _creationTime;
    private Date        _modificationTime;
    private int         _omittedPosts;
    private int         _omittedImages;
    private int         _totalReplies;
    private int         _totalImages;

    private Image       _image;

    public int getPostNumber() {
        return _postNumber;
    }

    public int getReplyTo() {
        return _replyTo;
    }

    public boolean getIsStickied() {
        return _isStickied;
    }

    public boolean getIsLocked() {
        return _isLocked;
    }

    public boolean getIsClosed() {
        return _isClosed;
    }

    public String getSubject() {
        return _subject;
    }

    public String getComment() {
        return _comment;
    }

    public String getCaptionCode() {
        return _captionCode;
    }

    public String getName() {
        return _name != null ? _name : "Anonymous";
    }

    public String getTripCode() {
        return _tripCode;
    }

    public String getPosterId() {
        return _posterId;
    }

    public Date getCreationTime() {
        return _creationTime;
    }

    public Date getModificationTime() {
        return _modificationTime;
    }

    public int getOmittedPosts() {
        return _omittedPosts;
    }

    public int getOmittedImages() {
        return _omittedImages;
    }

    public int getTotalReplies() {
        return _totalReplies;
    }

    public int getTotalImages() {
        return _totalImages;
    }

    public boolean getHasImage() {
        return _image != null;
    }

    public Image getImage() {
        return _image;
    }

}
