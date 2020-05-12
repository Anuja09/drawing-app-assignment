package com.cs.validators;

import com.cs.domains.UserInput;

/**
 * This is validator for validating user input command
 * To add validation, one need to implement the validate
 * method in the respective command class.
 *
 * @author anuja
 */
public interface IValidator {
    default void validate(UserInput userInput) {
        ValidationHelper.checkForNull(userInput);
    }
}
