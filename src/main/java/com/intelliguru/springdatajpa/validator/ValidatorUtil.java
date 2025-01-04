package com.intelliguru.springdatajpa.validator;

import org.hibernate.validator.messageinterpolation.ResourceBundleMessageInterpolator;
import org.hibernate.validator.resourceloading.AggregateResourceBundleLocator;

import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Collections;

public class ValidatorUtil {
    private ValidatorUtil(){}

    public static Validator getValidator(){
        return Validation.byDefaultProvider()
                .configure()
                .messageInterpolator(
                        new ResourceBundleMessageInterpolator(
                                new AggregateResourceBundleLocator(
                                        Collections.singletonList(
                                                "messages"
                                        )
                                )
                        )
                )
                .buildValidatorFactory()
                .getValidator();
    }
}
