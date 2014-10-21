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

public class Image {

    private String  _fileName;
    private String  _extension;
    private int     _fileSize;
    private String  _md5;
    private int     _width;
    private int     _height;
    private int     _thumbnailWidth;
    private int     _thumbnailHeight;
    private int     _renamedFilename; // timestamp + microseconds
    private boolean _isSpoiler;
    private boolean _isDeleted;

    public String getFilename() {
        return _fileName;
    }

    public String getExtension() {
        return _extension;
    }

    public int getFileSize() {
        return _fileSize;
    }

    public int getWidth() {
        return _width;
    }

    public int getHeight() {
        return _height;
    }

    public int getThumbnailWidth() {
        return _thumbnailWidth;
    }

    public int getThumbnailHeight() {
        return _thumbnailHeight;
    }

    public String getMd5() {
        return _md5;
    }

    public int getRenamedFilename() {
        return _renamedFilename;
    }

    public boolean getIsSpoiler() {
        return _isSpoiler;
    }

    public boolean getIsDeleted() {
        return _isDeleted;
    }

}
