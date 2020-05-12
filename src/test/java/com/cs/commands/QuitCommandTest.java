package com.cs.commands;

import com.cs.domains.*;
import com.cs.exception.DrawingException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class QuitCommandTest {

    @Test
    void shouldExecute_quit() {
        UserInput userInput = new UserInput(CommandName.Q, null);
        Canvas canvas = new Canvas(5, 4);
        QuitCommand quitCommand = new QuitCommand(canvas);

        //quitCommand.execute(userInput);
    }

    @Test
    void validate_whenUserInputNull() {
        Canvas canvas = new Canvas(5, 4);
        QuitCommand quitCommand = new QuitCommand(canvas);
        Assertions.assertThrows(DrawingException.class,
                () -> quitCommand.validate(null));

    }

    @Test
    void validate_whenInputParamsNotNull() {
        Point point = new Point(5, 4);
        List<Point> pointList = new ArrayList<>();
        pointList.add(point);
        InputParam inputParam = new InputParam(pointList);
        UserInput userInput = new UserInput(CommandName.Q, inputParam);

        Canvas canvas = new Canvas(5, 4);
        QuitCommand quitCommand = new QuitCommand(canvas);
        Assertions.assertThrows(DrawingException.class,
                () -> quitCommand.validate(userInput));

    }
}