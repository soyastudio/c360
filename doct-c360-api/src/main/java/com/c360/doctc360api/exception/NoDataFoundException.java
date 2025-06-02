package com.c360.doctc360api.exception;

public class NoDataFoundException extends RuntimeException {

    public NoDataFoundException() {
        super("No data found");
    }

    public NoDataFoundException(String id) {
        super("No data found for given uuid ==> "+ id);
    }
}
