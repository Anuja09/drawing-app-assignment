package com.cs.commands.factory;

import com.cs.commands.*;
import com.cs.domains.Canvas;
import com.cs.domains.UserInput;
import com.cs.exception.DrawingErrors;
import com.cs.exception.DrawingException;

import java.util.Scanner;

/**
 * This is commands factory
 *
 * @author anuja
 */
public class CommandFactory {

    public static ICommand getInstance(UserInput command, Canvas canvas) {
        switch (command.name().value()) {
            case "C":
              return new CreateCanvas(canvas);
            case "L":
                return new DrawLine(canvas);
            case "R":
                return new DrawRectangle(canvas);
            case "B":
                return new DoBucketFill(canvas);
            case "Q":
                return new QuitCommand(canvas);
            case "H":
                return new HelpCommand(canvas);
            default:
                throw new DrawingException(DrawingErrors.ERR_UNKNOWN_COMMAND);
        }
    }
}
