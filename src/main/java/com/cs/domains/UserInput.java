package com.cs.domains;

/**
 * This class represents the command provided in the input for execution
 * e.g. command to create canvas = C 5 6
 * where name = 'C', inputParam = 5 6
 *
 * @author anuja
 */
public class UserInput {
    private CommandName name;
    private InputParam inputParam;

    public UserInput(CommandName command, InputParam inputParams) {
        this.name = command;
        this.inputParam = inputParams;


    }

    public CommandName name() {
        return this.name;
    }

    public InputParam inputParams() {
        return this.inputParam;
    }

    @Override
    public String toString() {
        return "Command{" +
                "name='" + name + '\'' +
                ", inputParam=" + inputParam +
                '}';
    }
}
