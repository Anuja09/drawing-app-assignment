package com.cs.commands;

import com.cs.domains.Canvas;
import com.cs.domains.UserInput;
import com.cs.validators.ValidationHelper;

/**
 * This class represents quit command and performs validations.
 * Q - It quits the program.
 *
 * @author anuja
 */
public class QuitCommand implements ICommand {
    private Canvas canvas;

    public QuitCommand(Canvas canvas) {
        this.canvas = canvas;
    }

    @Override
    public void execute(UserInput command) {
        System.out.println("log:Application is terminated successfully.");
        System.exit(0);

        /*Scanner scanner = new Scanner(System.in);
        String yORn = "";
        while (!(yORn.equalsIgnoreCase("n") || yORn.equalsIgnoreCase("y"))) {
            System.out.println("Do you want to quit, y/n?");
            yORn = scanner.next();
            if ("n".equalsIgnoreCase(yORn)) {
                break;
            } else if ("y".equalsIgnoreCase(yORn)) {
                System.out.println("log:Application is terminated successfully.");
                System.exit(0);
            }
        }*/

    }

    @Override
    public Canvas get() {
        return canvas;
    }

    @Override
    public void validate(UserInput inputCommand) {
        ValidationHelper.checkForNull(inputCommand);
        ValidationHelper.checkForNotNull(inputCommand.inputParams());
    }
}
