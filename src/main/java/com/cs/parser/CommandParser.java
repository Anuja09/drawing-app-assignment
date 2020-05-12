package com.cs.parser;

import com.cs.domains.CommandName;
import com.cs.domains.InputParam;
import com.cs.domains.Point;
import com.cs.domains.UserInput;
import com.cs.exception.DrawingErrors;
import com.cs.exception.DrawingException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * This class parses the command string input by user.
 * It parses the command and enrich the UserInput object
 * if the input data is the correct format.
 *
 * @author anuja
 */
public class CommandParser {
    public UserInput parse(String commandInput) {
        List<Point> points = null;
        String symbol = "";
        String commandName;
        try {
            String[] cmdArr = commandInput.split("\\ ");
            commandName = cmdArr[0];

            if (cmdArr.length > 1) {
                points = new ArrayList<>();
                int i = 1;
                for (; i < cmdArr.length - 1; i = i + 2) {
                    String x = cmdArr[i];
                    String y = cmdArr[i + 1];
                    points.add(new Point(Integer.parseInt(x), Integer.parseInt(y)));
                }

                if (cmdArr.length > i) {
                    symbol = cmdArr[cmdArr.length - 1].toLowerCase();
                }
            }
        } catch (ArrayIndexOutOfBoundsException | NumberFormatException e) {
            throw new DrawingException(DrawingErrors.ERR_PARSING_COMMAND);
        }

        InputParam inputParam = null;
        if (null != points)
            inputParam = new InputParam(points);
        if (inputParam != null && symbol != null && !symbol.isEmpty()) {
            inputParam.withSymbol(symbol.charAt(0));
        }
        Arrays.stream(CommandName.values())
                .filter(command -> command.name().equals(commandName))
                .findFirst().orElseThrow(() -> new DrawingException(DrawingErrors.ERR_UNKNOWN_COMMAND));

        UserInput command = new UserInput(CommandName.valueOf(commandName), inputParam);
        return command;
    }
}
