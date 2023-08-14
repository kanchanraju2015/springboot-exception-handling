package com.briz.myexcep;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Target(ElementType.FIELD)  // must for field type
@Retention(RetentionPolicy.RUNTIME)  // during the runtime
@Documented  // must be used
@Constraint(validatedBy= {AddressValidator.class})  // code is into addressvalidator 

public @interface AddressValidation 
{
	String message() default "fill the corect city name";
	
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};
}
