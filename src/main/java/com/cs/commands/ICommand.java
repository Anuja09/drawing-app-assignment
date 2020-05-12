package com.cs.commands;

import com.cs.domains.ICanvas;
import com.cs.domains.UserInput;
import com.cs.validators.IValidator;

/**
 * This is interface to different commands like C, L etc.
 * To introduce new command, one has to implement this interface
 * and provide implementation for execute() method.
 *
 * @author anuja
 */
public interface ICommand extends ICanvas, IValidator {
    void execute(UserInput command);
}
