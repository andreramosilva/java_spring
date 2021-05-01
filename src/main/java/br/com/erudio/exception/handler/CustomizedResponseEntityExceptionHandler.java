package br.com.erudio.exception.handler;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import br.com.erudio.exception.UnsuportedMathOperationException;
import br.com.erudio.exception.exceptionResponse;

@RestController
@ControllerAdvice
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<exceptionResponse> handleAllExceptions(Exception ex, WebRequest request){
		exceptionResponse exceptionResponse = new exceptionResponse((java.sql.Date) new Date(),ex.getMessage(),request.getDescription(false));
		return new ResponseEntity<>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	
//	@ExceptionHandler(UnsuportedMathOperationException.class)
//	public final ResponseEntity<exceptionResponse> UnsuportedMathOperationException(Exception ex, WebRequest request){
//		exceptionResponse exceptionResponse = new exceptionResponse((java.sql.Date) new Date(),ex.getMessage(),request.getDescription(false));
//		return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
//	}
}
