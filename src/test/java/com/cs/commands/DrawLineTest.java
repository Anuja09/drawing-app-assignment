package com.cs.commands;

import com.cs.CanvasTestData;
import com.cs.domains.*;
import com.cs.exception.DrawingException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DrawLineTest {

    @Test
    void execute_withValidInput() {

        Point point1 = new Point(1, 1);
        Point point2 = new Point(1, 4);
        List<Point> pointList = new ArrayList<>();
        pointList.add(point1);
        pointList.add(point2);
        InputParam inputParam = new InputParam(pointList);
        UserInput userInput = new UserInput(CommandName.L, inputParam);

        Canvas canvas = new Canvas(5, 4);
        canvas.withBlocks(CanvasTestData.NEW_CANVAS);

        DrawLine drawLineCommand = new DrawLine(canvas);
        drawLineCommand.execute(userInput);
        char[][] blocks = drawLineCommand.get().blocks();

        char ch = DrawingSymbol.X.value();

        assertEquals(ch, blocks[1][1]);
        assertEquals(ch, blocks[2][1]);
        assertEquals(ch, blocks[3][1]);
        assertEquals(ch, blocks[4][1]);
    }

    @Test
    void validate_withCanvasNull() {
        Point point1 = new Point(1, 1);
        Point point2 = new Point(1, 4);
        List<Point> pointList = new ArrayList<>();
        pointList.add(point1);
        pointList.add(point2);
        InputParam inputParam = new InputParam(pointList);
        UserInput userInput = new UserInput(CommandName.L, inputParam);
        DrawLine drawLineCommand = new DrawLine(null);
        Assertions.assertThrows(DrawingException.class,
                () -> drawLineCommand.validate(userInput));
    }

    @Test
    void validate_withInvalidParam() {
        Point point1 = new Point(1, 1);
        List<Point> pointList = new ArrayList<>();
        pointList.add(point1);
        InputParam inputParam = new InputParam(pointList);
        UserInput userInput = new UserInput(CommandName.L, inputParam);
        Canvas canvas = new Canvas(5, 4);
        canvas.withBlocks(CanvasTestData.NEW_CANVAS);
        DrawLine drawLineCommand = new DrawLine(canvas);
        Assertions.assertThrows(DrawingException.class,
                () -> drawLineCommand.validate(userInput));
    }

    @Test
    void validate_withConstraintViolation() {
        Point point1 = new Point(0, 1);
        List<Point> pointList = new ArrayList<>();
        pointList.add(point1);
        InputParam inputParam = new InputParam(pointList);
        UserInput userInput = new UserInput(CommandName.L, inputParam);
        Canvas canvas = new Canvas(5, 4);
        canvas.withBlocks(CanvasTestData.NEW_CANVAS);
        DrawLine drawLineCommand = new DrawLine(canvas);
        Assertions.assertThrows(DrawingException.class,
                () -> drawLineCommand.validate(userInput));
    }

    @Test
    void validate_withConstraintViolation_xGreater() {
        Point point1 = new Point(7, 1);
        Point point2 = new Point(5, 1);
        List<Point> pointList = new ArrayList<>();
        pointList.add(point1);
        pointList.add(point2);
        InputParam inputParam = new InputParam(pointList);
        UserInput userInput = new UserInput(CommandName.L, inputParam);
        Canvas canvas = new Canvas(5, 4);
        canvas.withBlocks(CanvasTestData.NEW_CANVAS);
        DrawLine drawLineCommand = new DrawLine(canvas);
        Assertions.assertThrows(DrawingException.class,
                () -> drawLineCommand.validate(userInput));
    }

    @Test
    void validate_withConstraintViolation_yGreater() {
        Point point1 = new Point(0, 1);
        Point point2 = new Point(6, 1);
        List<Point> pointList = new ArrayList<>();
        pointList.add(point1);
        pointList.add(point2);
        InputParam inputParam = new InputParam(pointList);
        UserInput userInput = new UserInput(CommandName.L, inputParam);
        Canvas canvas = new Canvas(5, 4);
        canvas.withBlocks(CanvasTestData.NEW_CANVAS);
        DrawLine drawLineCommand = new DrawLine(canvas);
        Assertions.assertThrows(DrawingException.class,
                () -> drawLineCommand.validate(userInput));
    }

    @Test
    void validate_withInvalidSyntax_withSymbol() {
        Point point1 = new Point(0, 1);
        Point point2 = new Point(4, 1);
        List<Point> pointList = new ArrayList<>();
        pointList.add(point1);
        pointList.add(point2);
        InputParam inputParam = new InputParam(pointList);
        inputParam.withSymbol('a');
        UserInput userInput = new UserInput(CommandName.L, inputParam);
        Canvas canvas = new Canvas(5, 4);
        canvas.withBlocks(CanvasTestData.NEW_CANVAS);
        DrawLine drawLineCommand = new DrawLine(canvas);
        Assertions.assertThrows(DrawingException.class,
                () -> drawLineCommand.validate(userInput));
    }
}