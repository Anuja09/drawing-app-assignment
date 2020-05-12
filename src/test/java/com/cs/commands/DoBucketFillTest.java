package com.cs.commands;

import com.cs.CanvasTestData;
import com.cs.domains.*;
import com.cs.exception.DrawingException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * The test class for DoBucketFill
 *
 * @author anuja
 */
class DoBucketFillTest {

    @Test
    void shouldExecute_withValidInput() {
        Point point = new Point(2, 4);
        List<Point> pointList = new ArrayList<>();
        pointList.add(point);
        InputParam inputParam = new InputParam(pointList);
        inputParam.withSymbol('o');
        UserInput userInput = new UserInput(CommandName.B, inputParam);

        char[][] blocks1 = CanvasTestData.VALID_CANVAS_7X7_1;
        Canvas canvas = new Canvas(7, 7);
        canvas.withBlocks(blocks1);

        DoBucketFill doBucketFill = new DoBucketFill(canvas);

        doBucketFill.execute(userInput);
        Canvas output = doBucketFill.get();
        char[][] blocks = output.blocks();
        //CanvasTestData.printCanvas(blocks);
        char drawingColor = 'o';
        assertEquals(drawingColor, blocks[1][2]);
        assertEquals(drawingColor, blocks[1][3]);
        assertEquals(drawingColor, blocks[1][4]);
        assertEquals(drawingColor, blocks[1][5]);
        assertEquals(drawingColor, blocks[1][6]);
        assertEquals(drawingColor, blocks[1][7]);
        assertEquals(drawingColor, blocks[2][2]);
        assertEquals(drawingColor, blocks[3][2]);
        assertEquals(drawingColor, blocks[4][2]);
        assertEquals(drawingColor, blocks[4][1]);
        assertEquals(drawingColor, blocks[5][1]);
        assertEquals(drawingColor, blocks[5][2]);
        assertEquals(drawingColor, blocks[5][4]);
        assertEquals(drawingColor, blocks[5][5]);
        assertEquals(drawingColor, blocks[5][6]);
        assertEquals(drawingColor, blocks[5][7]);
        assertEquals(drawingColor, blocks[2][7]);
        assertEquals(drawingColor, blocks[3][7]);
        assertEquals(drawingColor, blocks[5][7]);
    }

    @Test
    void shouldValidate_NotAlphabeticSymbol() {
        Point point = new Point(2, 4);
        List<Point> pointList = new ArrayList<>();
        pointList.add(point);
        InputParam inputParam = new InputParam(pointList);
        inputParam.withSymbol('1');
        UserInput userInput = new UserInput(CommandName.L, inputParam);

        char[][] blocks = CanvasTestData.VALID_CANVAS_7X7;
        Canvas canvas = new Canvas(7, 7);
        canvas.withBlocks(blocks);

        DoBucketFill doBucketFill = new DoBucketFill(canvas);
        Assertions.assertThrows(DrawingException.class,
                () -> doBucketFill.validate(userInput));

    }

    @Test
    void shouldValidate_withCanvasNull() {
        Point point = new Point(2, 4);
        List<Point> pointList = new ArrayList<>();
        pointList.add(point);
        InputParam inputParam = new InputParam(pointList);
        inputParam.withSymbol('1');
        UserInput userInput = new UserInput(CommandName.L, inputParam);

        DoBucketFill doBucketFill = new DoBucketFill(null);
        Assertions.assertThrows(DrawingException.class,
                () -> doBucketFill.validate(userInput));

    }
}