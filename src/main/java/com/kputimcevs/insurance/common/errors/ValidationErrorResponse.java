package com.kputimcevs.insurance.common.errors;

import java.util.List;

public class ValidationErrorResponse {
    public final String message = "Request entity did not pass validation. Please check validation errors";
    public final List<String> validationErrors;

    public ValidationErrorResponse(List<String> validationErrors) {
        this.validationErrors = validationErrors;
    }
}
