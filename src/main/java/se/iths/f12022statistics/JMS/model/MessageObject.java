package se.iths.f12022statistics.JMS.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;
import java.util.UUID;

public class MessageObject {
    private UUID ud;
    private String message;
    @JsonFormat(pattern = "yyyy-MM-dd HH-mm:ss")
    private LocalDateTime localDateTime;

    public MessageObject(UUID ud, String message, LocalDateTime localDateTime) {
        this.ud = ud;
        this.message = message;
        this.localDateTime = localDateTime;
    }

    public MessageObject() {
    }

    public UUID getUd() {
        return ud;
    }

    public String getMessage() {
        return message;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    @Override
    public String toString() {
        return "MessageObject{" +
                "ud=" + ud +
                ", message='" + message + '\'' +
                ", localDateTime=" + localDateTime +
                '}';
    }
}
