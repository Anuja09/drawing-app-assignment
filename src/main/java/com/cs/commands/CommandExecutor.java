package com.cs.commands;

import com.cs.domains.UserInput;

/**
 * Thus class delegates to appropriate command execution.
 *
 * @author anuja
 */
public class CommandExecutor {
    private ICommand command;

    public CommandExecutor() {
    }

    public CommandExecutor withCommand(ICommand command) {
        this.command = command;
        return this;
    }

    public void submit(UserInput inputCommand) {
        command.execute(inputCommand);
    }
}
