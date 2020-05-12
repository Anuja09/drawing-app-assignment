package com.cs.commands;

import com.cs.CanvasTestData;
import com.cs.domains.*;
import com.cs.exception.DrawingException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RectangleTest {

    @Test
    void shouldExecute_withValidInput() {
        Point point1 = new Point(1, 1);
        Point point2 = new Point(3, 4);
        List<Point> pointList = new ArrayList<>();
        pointList.add(point1);
        pointList.add(point2);
        InputParam inputParam = new InputParam(pointList);
        UserInput userInput = new UserInput(CommandName.R, inputParam);

        Canvas canvas = new Canvas(5, 4);
        canvas.withBlocks(CanvasTestData.NEW_CANVAS);

        DrawRectangle drawRectangle = new DrawRectangle(canvas);
        drawRectangle.execute(userInput);
        char[][] blocks = drawRectangle.get().blocks();

        char ch = DrawingSymbol.X.value();

        assertEquals(ch, blocks[1][1]);
        assertEquals(ch, blocks[2][1]);
        assertEquals(ch, blocks[3][1]);
        assertEquals(ch, blocks[1][2]);
        assertEquals(ch, blocks[1][3]);
        assertEquals(ch, blocks[4][1]);
        assertEquals(ch, blocks[1][3]);
        assertEquals(ch, blocks[2][3]);
        assertEquals(ch, blocks[3][3]);
        assertEquals(ch, blocks[4][3]);
        assertEquals(ch, blocks[4][2]);
    }


    @Test
    void validate_withCanvasNull() {
        Point point1 = new Point(1, 1);
        Point point2 = new Point(1, 4);
        List<Point> pointList = new ArrayList<>();
        pointList.add(point1);
        pointList.add(point2);
        InputParam inputParam = new InputParam(pointList);
        UserInput userInput = new UserInput(CommandName.R, inputParam);
        DrawRectangle drawRectangle = new DrawRectangle(null);
        Assertions.assertThrows(DrawingException.class,
                () -> drawRectangle.validate(userInput));
    }


    @Test
    void validate_withInputCommandNull() {
        UserInput userInput = new UserInput(CommandName.R, null);

        Canvas canvas = new Canvas(5, 4);
        canvas.withBlocks(CanvasTestData.NEW_CANVAS);

        DrawRectangle drawRectangle = new DrawRectangle(canvas);
        Assertions.assertThrows(DrawingException.class,
                () -> drawRectangle.validate(userInput));
    }


    @Test
    void validate_withOnePoint() {
        Point point1 = new Point(1, 1);
        List<Point> pointList = new ArrayList<>();
        pointList.add(point1);
        InputParam inputParam = new InputParam(pointList);
        UserInput userInput = new UserInput(CommandName.R, inputParam);

        Canvas canvas = new Canvas(5, 4);
        canvas.withBlocks(CanvasTestData.NEW_CANVAS);

        DrawRectangle drawRectangle = new DrawRectangle(canvas);
        Assertions.assertThrows(DrawingException.class,
                () -> drawRectangle.validate(userInput));
    }
}