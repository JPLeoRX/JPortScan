package com.tekleo.jportscan.scan;

/**
 * The exception to throw if something weird happens during scan
 *
 * @author Leo Ertuna
 * @since 18.05.2018 00:10
 */
public class ScanOperationException extends RuntimeException {
    public ScanOperationException() {

    }

    public ScanOperationException(String message) {
        super(message);
    }

    public ScanOperationException(String message, Throwable cause) {
        super(message, cause);
    }

    public ScanOperationException(Throwable cause) {
        super(cause);
    }

    public ScanOperationException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}