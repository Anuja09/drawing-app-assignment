package com.cs.commands;

import com.cs.CanvasTestData;
import com.cs.domains.*;
import com.cs.exception.DrawingException;
import com.cs.validators.CanvasConstraints;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * This test class for CreateCanvas
 *
 * @author anuja
 */
class CreateCanvasTest {

    @Test
    void execute() {
        Point point = new Point(5, 4);
        List<Point> pointList = new ArrayList<>();
        pointList.add(point);
        InputParam inputParam = new InputParam(pointList);
        UserInput userInput = new UserInput(CommandName.C, inputParam);

        CreateCanvas createCanvasCommand = new CreateCanvas(null);
        createCanvasCommand.execute(userInput);

        char[][] canvasAfterCreate = createCanvasCommand.get().blocks();
        char[][] blocks = CanvasTestData.NEW_CANVAS;

        //Verify all indices of block
        for (int i = 0; i < blocks.length; i++) {
            for (int j = 0; j < blocks[0].length; j++) {
                assertEquals(blocks[i][j], canvasAfterCreate[i][j]);
            }
        }
    }

    @Test
    void validate_withCanvasConstraintsViolations_height() {
        Point point = new Point(1, CanvasConstraints.CANVAS_MAX_HEIGHT + 1);
        List<Point> pointList = new ArrayList<>();
        pointList.add(point);
        InputParam inputParam = new InputParam(pointList);
        UserInput userInput = new UserInput(CommandName.C, inputParam);

        CreateCanvas createCanvasCommand = new CreateCanvas(null);

        Assertions.assertThrows(DrawingException.class,
                () -> createCanvasCommand.validate(userInput));


    }

    @Test
    void validate_withCanvasConstraintViolations_width() {
        Point point = new Point(CanvasConstraints.CANVAS_MAX_WIDTH + 1, 3);
        List<Point> pointList = new ArrayList<>();
        pointList.add(point);
        InputParam inputParam = new InputParam(pointList);
        UserInput userInput = new UserInput(CommandName.C, inputParam);

        CreateCanvas createCanvasCommand = new CreateCanvas(null);

        Assertions.assertThrows(DrawingException.class,
                () -> createCanvasCommand.validate(userInput));

    }

    @Test
    void validate_withMorePoints() {
        Point point1 = new Point(4, 5);
        Point point2 = new Point(5, 5);
        List<Point> pointList = new ArrayList<>();
        pointList.add(point1);
        pointList.add(point2);
        InputParam inputParam = new InputParam(pointList);
        UserInput userInput = new UserInput(CommandName.C, inputParam);

        CreateCanvas createCanvasCommand = new CreateCanvas(null);

        Assertions.assertThrows(DrawingException.class,
                () -> createCanvasCommand.validate(userInput));
    }

    @Test
    void validate_withNonEmptyCanvas() {
        Point point1 = new Point(4, 5);
        Point point2 = new Point(5, 5);
        List<Point> pointList = new ArrayList<>();
        pointList.add(point1);
        pointList.add(point2);
        InputParam inputParam = new InputParam(pointList);
        UserInput userInput = new UserInput(CommandName.C, inputParam);

        Canvas canvas = new Canvas(7, 7);
        canvas.withBlocks(CanvasTestData.NEW_CANVAS);
        CreateCanvas createCanvasCommand = new CreateCanvas(canvas);

        Assertions.assertThrows(DrawingException.class,
                () -> createCanvasCommand.validate(userInput));
    }
}