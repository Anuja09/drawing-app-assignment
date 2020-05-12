package com.cs.parser;

import com.cs.domains.CommandName;
import com.cs.domains.InputParam;
import com.cs.domains.Point;
import com.cs.domains.UserInput;
import com.cs.exception.DrawingException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test class for CommandParser
 */
@ExtendWith(MockitoExtension.class)
class CommandParserTest {

    @InjectMocks
    private CommandParser commandParser;

    @Test
    void parse_CreateCanvas() {
        String commandStr = "C 5 6";
        Point point = new Point(5, 6);
        List<Point> pointList = new ArrayList<>();
        pointList.add(point);
        InputParam inputParam = new InputParam(pointList);
        UserInput expectedCommand = new UserInput(CommandName.C, inputParam);

        UserInput actualCommand = commandParser.parse(commandStr);

        assertEquals(expectedCommand.name(), actualCommand.name());
        assertEquals(expectedCommand.inputParams().points().size()
                , actualCommand.inputParams().points().size());
        assertEquals(expectedCommand.inputParams().symbol()
                , actualCommand.inputParams().symbol());
        assertEquals(expectedCommand.inputParams().points().get(0).getX()
                , actualCommand.inputParams().points().get(0).getX());
        assertEquals(expectedCommand.inputParams().points().get(0).getY()
                , actualCommand.inputParams().points().get(0).getY());


    }

    @Test
    void parse_DrawLine() {
        String commandStr = "L 1 1 1 4";
        Point point1 = new Point(1, 1);
        Point point2 = new Point(1, 4);
        List<Point> pointList = new ArrayList<>();
        pointList.add(point1);
        pointList.add(point2);
        InputParam inputParam = new InputParam(pointList);
        UserInput expectedCommand = new UserInput(CommandName.L, inputParam);
        UserInput actualCommand = commandParser.parse(commandStr);

        assertEquals(expectedCommand.name(), actualCommand.name());
        assertEquals(expectedCommand.inputParams().points().size()
                , actualCommand.inputParams().points().size());
        assertEquals(expectedCommand.inputParams().symbol()
                , actualCommand.inputParams().symbol());
        assertEquals(expectedCommand.inputParams().points().get(0).getX()
                , actualCommand.inputParams().points().get(0).getX());
        assertEquals(expectedCommand.inputParams().points().get(0).getY()
                , actualCommand.inputParams().points().get(0).getY());
        assertEquals(expectedCommand.inputParams().points().get(1).getX()
                , actualCommand.inputParams().points().get(1).getX());
        assertEquals(expectedCommand.inputParams().points().get(1).getY()
                , actualCommand.inputParams().points().get(1).getY());
    }

    @Test
    void parse_DrawRectangle() {
        String commandStr = "R 1 1 3 4";
        Point point1 = new Point(1, 1);
        Point point2 = new Point(3, 4);
        List<Point> pointList = new ArrayList<>();
        pointList.add(point1);
        pointList.add(point2);
        InputParam inputParam = new InputParam(pointList);
        UserInput expectedCommand = new UserInput(CommandName.R, inputParam);
        UserInput actualCommand = commandParser.parse(commandStr);

        assertEquals(expectedCommand.name(), actualCommand.name());
        assertEquals(expectedCommand.inputParams().points().size()
                , actualCommand.inputParams().points().size());
        assertEquals(expectedCommand.inputParams().symbol()
                , actualCommand.inputParams().symbol());
        assertEquals(expectedCommand.inputParams().points().get(0).getX()
                , actualCommand.inputParams().points().get(0).getX());
        assertEquals(expectedCommand.inputParams().points().get(0).getY()
                , actualCommand.inputParams().points().get(0).getY());
        assertEquals(expectedCommand.inputParams().points().get(1).getX()
                , actualCommand.inputParams().points().get(1).getX());
        assertEquals(expectedCommand.inputParams().points().get(1).getY()
                , actualCommand.inputParams().points().get(1).getY());
    }

    @Test
    void parse_BucketFill() {
        String commandStr = "B 2 4 o";
        Point point = new Point(2, 4);
        List<Point> pointList = new ArrayList<>();
        pointList.add(point);
        InputParam inputParam = new InputParam(pointList);
        inputParam.withSymbol('o');
        UserInput expectedCommand = new UserInput(CommandName.B, inputParam);
        UserInput actualCommand = commandParser.parse(commandStr);

        assertEquals(expectedCommand.name(), actualCommand.name());
        assertEquals(expectedCommand.inputParams().points().size()
                , actualCommand.inputParams().points().size());
        assertEquals(expectedCommand.inputParams().symbol()
                , actualCommand.inputParams().symbol());
        assertEquals(expectedCommand.inputParams().points().get(0).getX()
                , actualCommand.inputParams().points().get(0).getX());
        assertEquals(expectedCommand.inputParams().points().get(0).getY()
                , actualCommand.inputParams().points().get(0).getY());

    }

    @Test
    void parse_Help() {
        String commandStr = "H";
        UserInput expectedCommand = new UserInput(CommandName.H, null);
        UserInput actualCommand = commandParser.parse(commandStr);

        assertEquals(expectedCommand.name(), actualCommand.name());
        assertEquals(expectedCommand.inputParams(), actualCommand.inputParams());

    }

    @Test
    void parse_Quit() {

        String commandStr = "Q";
        UserInput expectedCommand = new UserInput(CommandName.Q, null);
        UserInput actualCommand = commandParser.parse(commandStr);

        assertEquals(expectedCommand.name(), actualCommand.name());
        assertEquals(expectedCommand.inputParams(), actualCommand.inputParams());

    }

    @Test
    void parse_InvalidCreateCommand() {
        String commandStr = "C a b";
        Assertions.assertThrows(DrawingException.class,
                () -> commandParser.parse(commandStr));
    }
}