package edu.learning.munish.core.exception;

/**
 * Created by Munish Kumar on 07-12-2016.
 */
public class DocuException extends RuntimeException {

    private int code = 500;

    private String message;

    public DocuException(String message) {
        super(message);
        this.message = message;
    }

    public DocuException(String message, int code) {
        super(message);
        this.message = message;
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
