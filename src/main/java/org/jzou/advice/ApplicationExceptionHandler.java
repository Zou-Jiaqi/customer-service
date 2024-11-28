package org.jzou.advice;

import org.jzou.exception.CustomerNotFoundException;
import org.springframework.beans.factory.parsing.Problem;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ApplicationExceptionHandler {

    @ExceptionHandler(CustomerNotFoundException.class)
    public ProblemDetail handlerException(CustomerNotFoundException ex) {
        var problem = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, ex.getMessage());
        problem.setTitle("Customer Not Found");
        return problem;
    }
}
