package com.verapipe.exceptions;

import com.verapipe.dto.ErrorBean;
import com.verapipe.enums.ErrorType;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletResponse;


@RestControllerAdvice
public class ExceptionsHandler {

    @ExceptionHandler
    public ErrorBean toResponse(Throwable throwable, HttpServletResponse httpServletResponse) {
        if (throwable instanceof ApplicationException) {
            ApplicationException appException = (ApplicationException) throwable;
            if (appException.getErrorType().isShowStackTrace()) {
                appException.printStackTrace();
            }

            ErrorType errorType = appException.getErrorType();
            int errorNumber = errorType.getErrorNum();
            String errorMessage = errorType.getErrorMessage();
            ErrorBean errorBean = new ErrorBean(errorNumber, errorMessage);
            httpServletResponse.setStatus(500);
            return errorBean;
        }

        throwable.printStackTrace();

        ErrorBean errorBean = new ErrorBean(ErrorType.GENERAL_ERROR);
        return errorBean;
    }
}

