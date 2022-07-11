package ru.skillbox.diplom.alpha.microservice.country.exception;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import ru.skillbox.diplom.alpha.microservice.country.response.ErrorRs;

/**
 * GeoException
 *
 * @author Olga Samoylova
 */
@ControllerAdvice
public class GeoException {

    @ExceptionHandler({NullPointerException.class})
    public final ResponseEntity<ErrorRs> nullPointerException(Exception ex, WebRequest request) {
        ErrorRs errorRs = new ErrorRs();
        errorRs.setError("NullPointer");
        errorRs.setErrorDescription("Сountry is not found by id");
        return ResponseEntity.badRequest().body(errorRs);
    }
}
