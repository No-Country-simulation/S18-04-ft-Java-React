package com.nocountry.nocountry.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
// @NoArgsConstructor
@AllArgsConstructor
public class ErrorResponse {
    private String details;
    private Integer statusCode;
    private String message;
}
