package edu.learning.munish.web.errorHandler;

import edu.learning.munish.core.exception.DocuException;
import edu.learning.munish.web.dto.ErrorDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;

/**
 * Created by Munish Kumar on 07-12-2016.
 */
@ControllerAdvice
public class DocuExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<Object> handleMca2Exception(DocuException e, WebRequest request) throws NoSuchFieldException {
        ErrorDto errorDto = new ErrorDto(e.getMessage(), e.getCode());
        logger.error("Error in endpoint", e);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return handleExceptionInternal(e, errorDto, headers, getCode(e.getCode()), request);
    }

    @ExceptionHandler
    public ResponseEntity<Object> handleMca2Exception(Exception e, WebRequest request) throws NoSuchFieldException {
        ErrorDto errorDto = new ErrorDto(e.getMessage(), 500);
        errorDto.setTrace(getStackTrace(e));
        logger.error("Error in endpoint", e);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return handleExceptionInternal(e, errorDto, headers, getCode(500), request);
    }

    public static String getStackTrace(Throwable aThrowable) {
        Writer result = new StringWriter();
        PrintWriter printWriter = new PrintWriter(result);
        aThrowable.printStackTrace(printWriter);
        return result.toString();
    }

    public HttpStatus getCode(int code) {
        switch (code) {
            case 400:
                return HttpStatus.BAD_REQUEST;
            default:
                return HttpStatus.INTERNAL_SERVER_ERROR;
        }
    }
}
