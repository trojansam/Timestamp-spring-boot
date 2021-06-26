package com.syedsamiuddin.Timestamp.error;

public class TimestampInvalid extends Exception {
    public TimestampInvalid() {
        super();
    }

    public TimestampInvalid(String message) {
        super(message);
    }

    public TimestampInvalid(String message, Throwable cause) {
        super(message, cause);
    }

    public TimestampInvalid(Throwable cause) {
        super(cause);
    }

    protected TimestampInvalid(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
