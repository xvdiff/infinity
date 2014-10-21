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

public final class Guard {

    public static void againstNullArgument(Object argument, String argumentName)
        throws IllegalArgumentException
    {
        if(argument == null)
            throw new IllegalArgumentException("Argument " + argumentName + " cannot be null.");
    }

}
