package org.group1.models;

import java.time.Instant;

public class CustomErrorResponse {
    private final int status;
    private final String error;
    private final String message;
    private final Instant timestamp;

    public CustomErrorResponse(int status, String error, String message, Instant timestamp) {
        this.status = status;
        this.error = error;
        this.message = message;
        this.timestamp = timestamp;
    }

    public int getStatus() {
        return status;
    }

    public String getError() {
        return error;
    }

    public String getMessage() {
        return message;
    }

    public Instant getTimestamp() {
        return timestamp;
    }
}

