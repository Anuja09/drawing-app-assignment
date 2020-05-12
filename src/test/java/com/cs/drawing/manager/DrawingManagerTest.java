package com.cs.drawing.manager;

import com.cs.adaptors.DrawingConsole;
import com.cs.commands.CommandExecutor;
import com.cs.domains.*;
import com.cs.exception.DrawingErrors;
import com.cs.exception.DrawingException;
import com.cs.parser.CommandParser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

/**
 * The test class for DrawingManager
 *
 * @author anuja
 */
@ExtendWith(MockitoExtension.class)
class DrawingManagerTest {
    @Mock
    private CommandParser commandParser;

    @Mock
    private DrawingConsole console;

    @InjectMocks
    private DrawingManager drawingManager;

    @Test
    void shouldHandle_createCanvasCommand() {
        String commandStr = "C 5 6";
        Point point = new Point(5, 6);
        List<Point> pointList = new ArrayList<>();
        pointList.add(point);
        InputParam inputParam = new InputParam(pointList);
        UserInput userInput = new UserInput(CommandName.C, inputParam);

        when(commandParser.parse(commandStr)).thenReturn(userInput);
        drawingManager.handle(commandStr);
        Canvas output = drawingManager.canvas();

        assertTrue(null != output);

        Mockito.verify(commandParser).parse(commandStr);
    }

    @Test
    void shouldHandle_createCanvasCommand_drawingexception() {
        String commandStr = "C 5 10 R";
        when(commandParser.parse(commandStr)).thenThrow(DrawingException.class);
        drawingManager.handle(commandStr);
    }
}