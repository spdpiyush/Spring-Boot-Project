package com.piyush.demo.modelVO;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * Created By : Piyush Kumar
 */

@Component
public class Status {

    private Integer errorCodes;
    private String message;

    public Status() {
    }

    public Status(Integer errorCodes, String message) {
        this.errorCodes = errorCodes;
        this.message = message;
    }

    public Integer getErrorCodes() {
        return errorCodes;
    }

    public void setErrorCodes(Integer errorCodes) {
        this.errorCodes = errorCodes;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Status{" +
                "errorCodes=" + errorCodes +
                ", message='" + message + '\'' +
                '}';
    }
}
