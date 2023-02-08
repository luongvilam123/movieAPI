package com.lamluong.movieapi.exception;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum ErrorCode {

    GET_ALL_MOVIE_ERROR("001"),

    GET_BY_ID_ERROR("002");
    private final String value;

    @Override
    public String toString() {
        return value;
    }
}
