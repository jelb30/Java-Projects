package com.ltp.contacts.Exception;

import java.time.LocalDateTime;
import java.util.List;

public class ErrorResponse {

    private List<String> message;
    private LocalDateTime timestamp;

    public ErrorResponse(List<String> message) {
        this.message = message;
        this.timestamp = LocalDateTime.now();
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public List<String> getMessage() {
        return message;
    }

    public void setMessage(List<String> message) {
        this.message = message;
    }
}
