package com.kputimcevs.insurance.common.errors;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.context.request.WebRequest;

import java.util.List;

import static com.kputimcevs.insurance.TestUtils.assertReflEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class RestExceptionHandlerTest {
    @InjectMocks
    private RestExceptionHandler handler;

    @Test
    public void mapsMethodArgumentNotValidExceptionToResponseEntityAsExpected() {
        MethodParameter methodParameter = mock(MethodParameter.class);
        BindingResult bindingResult = mock(BindingResult.class);
        FieldError fieldError = mock(FieldError.class);
        FieldError fieldError2 = mock(FieldError.class);
        List<FieldError> fieldErrors = List.of(fieldError, fieldError2);
        HttpStatus status = HttpStatus.BAD_REQUEST;
        MethodArgumentNotValidException exception = new MethodArgumentNotValidException(methodParameter, bindingResult);

        when(bindingResult.getFieldErrors()).thenReturn(fieldErrors);
        when(fieldError.getField()).thenReturn("object.field");
        when(fieldError2.getField()).thenReturn("object.otherField");
        when(fieldError.getDefaultMessage()).thenReturn("field should be positive");
        when(fieldError2.getDefaultMessage()).thenReturn("field null, but should be present");

        ResponseEntity<Object> response = handler.handleMethodArgumentNotValid(
                exception, mock(HttpHeaders.class), status, mock(WebRequest.class)
        );

        ResponseEntity<Object> expectedResult = new ResponseEntity<>(
                new ValidationErrorResponse(List.of(
                        "object.field field should be positive", "object.otherField field null, but should be present"
                )), status
        );

        assertReflEquals(response, expectedResult);
    }
}