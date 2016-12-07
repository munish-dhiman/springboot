package edu.learning.munish.web.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * This data transfer object is responsible for sending the error response back to a http request
 * Created by Munish Kumar on 07-12-2016.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorDto {

    /**
     * Message if there is any
     */
    private String message;

    /**
     * Error code if there is any
     */
    private int code;

    /**
     * Trace if error code is unknown
     */
    private String trace;

    public ErrorDto() {
    }

    public ErrorDto(String message, int code) {
        this.message = message;
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getTrace() {
        return trace;
    }

    public void setTrace(String trace) {
        this.trace = trace;
    }
}
