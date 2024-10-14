package com.nocountry.nocountry.exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NotFoundException extends RuntimeException  {
    private  final  Integer statusCode = 404;
    public NotFoundException (String message){
        super(message);
    }
}