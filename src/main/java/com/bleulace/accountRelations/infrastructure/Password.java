package com.bleulace.accountRelations.infrastructure;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Payload;
import javax.validation.ReportAsSingleViolation;
import javax.validation.constraints.Size;

@Target({ ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
@ReportAsSingleViolation
@Size(min = Password.MIN_SIZE, max = Password.MAX_SIZE)
public @interface Password
{
	static final int MIN_SIZE = 8;
	static final int MAX_SIZE = 20;

	String message() default "com.bleulace.arm.infrastructure.Password.message";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}