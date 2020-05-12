package com.cs.commands;

import com.cs.domains.*;
import com.cs.exception.DrawingException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)
class HelpCommandTest {

    @Test
    void shouldExecute() {
        UserInput userInput = new UserInput(CommandName.H, null);
        Canvas canvas = new Canvas(5, 4);
        HelpCommand helpCommand = new HelpCommand(canvas);
        helpCommand.execute(userInput);
        assertTrue(null != helpCommand.get().description());
    }

    @Test
    void validate_whenUserInputNull() {
        Canvas canvas = new Canvas(5, 4);
        HelpCommand helpCommand = new HelpCommand(canvas);
        Assertions.assertThrows(DrawingException.class,
                () -> helpCommand.validate(null));

    }

    @Test
    void validate_whenInputParamsNotNull() {
        Point point = new Point(5, 4);
        List<Point> pointList = new ArrayList<>();
        pointList.add(point);
        InputParam inputParam = new InputParam(pointList);
        UserInput userInput = new UserInput(CommandName.H, inputParam);

        Canvas canvas = new Canvas(5, 4);
        HelpCommand helpCommand = new HelpCommand(canvas);
        Assertions.assertThrows(DrawingException.class,
                () -> helpCommand.validate(userInput));

    }
}