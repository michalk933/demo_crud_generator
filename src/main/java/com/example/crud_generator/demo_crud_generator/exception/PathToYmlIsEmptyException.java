package com.example.crud_generator.demo_crud_generator.exception;

/**
 * <h1>PathToYmlIsEmptyException.</h1>
 * <p>
 * Exception to throw when path to yml file is null or empty.
 *
 * @author michalkuchciak
 * @since 2019-08-10
 */
public class PathToYmlIsEmptyException extends RuntimeException {

    public PathToYmlIsEmptyException(String msg) {
        super(msg);
    }

    public PathToYmlIsEmptyException(String msg, Throwable throwable) {
        super(msg, throwable);
    }

}
