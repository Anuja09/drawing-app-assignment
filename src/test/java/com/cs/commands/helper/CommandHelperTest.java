package com.cs.commands.helper;

import com.cs.CanvasTestData;
import com.cs.domains.DrawingSymbol;
import com.cs.exception.DrawingException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test class for CommandHelper class
 *
 * @author anuja
 */
class CommandHelperTest {
    char color = 'o';

    @Test
    void drawLine_validPointsForVLine() {
        int x1 = 1;
        int y1 = 1;
        int x2 = 1;
        int y2 = 4;
        char ch = DrawingSymbol.X.value();
        char[][] canvas = CanvasTestData.NEW_CANVAS;
        CommandHelper.drawLine(canvas, x1, y1, x2, y2, ch);

        assertEquals(ch, canvas[1][1]);
        assertEquals(ch, canvas[2][1]);
        assertEquals(ch, canvas[3][1]);
        assertEquals(ch, canvas[4][1]);
    }

    @Test
    void drawLine_validPointsForHLine() {
        int x1 = 2;
        int y1 = 3;
        int x2 = 5;
        int y2 = 3;
        char ch = DrawingSymbol.X.value();
        char[][] canvas = CanvasTestData.NEW_CANVAS;
        CommandHelper.drawLine(canvas, x1, y1, x2, y2, ch);

        assertEquals(ch, canvas[3][2]);
        assertEquals(ch, canvas[3][3]);
        assertEquals(ch, canvas[3][4]);
        assertEquals(ch, canvas[3][5]);
    }

    @Test
    void drawLine_canvasEmpty() {
        int x1 = 1;
        int y1 = 1;
        int x2 = 1;
        int y2 = 5;
        char ch = DrawingSymbol.X.value();
        char[][] canvas = CanvasTestData.EMPTY_CANVAS;
        Assertions.assertThrows(DrawingException.class,
                () -> CommandHelper.drawLine(canvas, x1, y1, x2, y2, ch));

    }

    @Test
    void drawLine_canvasInvalidHeight() {
        int x1 = 1;
        int y1 = 1;
        int x2 = 1;
        int y2 = 5;
        char ch = DrawingSymbol.X.value();
        char[][] canvas = CanvasTestData.CANVAS_WITH_INVALID_HEIGHT;
        Assertions.assertThrows(DrawingException.class,
                () -> CommandHelper.drawLine(canvas, x1, y1, x2, y2, ch));

    }

    @Test
    void drawLine_whenInvalidWidth() {
        int x1 = 1;
        int y1 = 1;
        int x2 = 1;
        int y2 = 5;
        char ch = DrawingSymbol.X.value();
        char[][] canvas = CanvasTestData.CANVAS_WITH_INVALID_WIDTH;
        Assertions.assertThrows(DrawingException.class,
                () -> CommandHelper.drawLine(canvas, x1, y1, x2, y2, ch));

    }

    @Test
    void drawLine_whenCanvasNull() {
        int x1 = 1;
        int y1 = 1;
        int x2 = 1;
        int y2 = 5;
        char ch = DrawingSymbol.X.value();
        Assertions.assertThrows(DrawingException.class,
                () -> CommandHelper.drawLine(null, x1, y1, x2, y2, ch));
    }

    @Test
    void drawLine_validPointsForSLine() {
        int x1 = 2;
        int y1 = 1;
        int x2 = 4;
        int y2 = 4;
        char ch = DrawingSymbol.X.value();
        char[][] canvas = CanvasTestData.NEW_CANVAS;
        Assertions.assertThrows(DrawingException.class,
                () -> CommandHelper.drawLine(canvas, x1, y1, x2, y2, ch));
    }

    @Test
    void drawLine_validPointsSame() {
        int x1 = 4;
        int y1 = 4;
        int x2 = 4;
        int y2 = 4;
        char ch = DrawingSymbol.X.value();
        char[][] canvas = CanvasTestData.NEW_CANVAS;
        CommandHelper.drawLine(canvas, x1, y1, x2, y2, ch);
        assertEquals(ch, canvas[4][4]);
    }

    @Test
    void bucketFill_valid() {
        int x = 2;
        int y = 4;
        char ch = color;
        char[][] canvas = CanvasTestData.VALID_CANVAS_7X7;
        CommandHelper.bucketFill(canvas, x, y, ch);
        assertEquals(ch, canvas[1][2]);
        assertEquals(ch, canvas[1][3]);
        assertEquals(ch, canvas[1][4]);
        assertEquals(ch, canvas[1][5]);
        assertEquals(ch, canvas[1][6]);
        assertEquals(ch, canvas[1][7]);
        assertEquals(ch, canvas[2][2]);
        assertEquals(ch, canvas[3][2]);
        assertEquals(ch, canvas[4][2]);
        assertEquals(ch, canvas[4][1]);
        assertEquals(ch, canvas[5][1]);
        assertEquals(ch, canvas[5][2]);
        assertEquals(ch, canvas[5][4]);
        assertEquals(ch, canvas[5][5]);
        assertEquals(ch, canvas[5][6]);
        assertEquals(ch, canvas[5][7]);
        assertEquals(ch, canvas[2][7]);
        assertEquals(ch, canvas[3][7]);
        assertEquals(ch, canvas[5][7]);
    }

    @Test
    void bucketFill_whenCanvasNull() {
        int x = 2;
        int y = 4;
        char ch = color;
        char[][] canvas = null;
        Assertions.assertThrows(DrawingException.class,
                () -> CommandHelper.bucketFill(canvas, x, y, ch));
    }

    @Test
    void bucketFill_whenCanvasWithInvalidWidth() {
        int x = 2;
        int y = 4;
        char ch = 'o';
        char[][] canvas = CanvasTestData.CANVAS_WITH_INVALID_WIDTH;
        Assertions.assertThrows(DrawingException.class,
                () -> CommandHelper.bucketFill(canvas, x, y, ch));
    }

    /* @Test
    void drawLine_canvasWithInvalidX() {
        int x1 = 100;
        int y1 = 5;
        int x2 = 4;
        int y2 = 1;
        char ch = DrawingSymbol.X.value();
        char[][] canvas = CanvasTestData.NEW_CANVAS;
        Assertions.assertThrows(InvalidCommandException.class,
                () -> CommandHelper.drawLine(canvas, x1, y1, x2, y2, ch));

    }


    @Test
    void drawLine_canvasWithInvalidY() {
        int x1 = 1;
        int y1 = 100;
        int x2 = 1;
        int y2 = 5;
        char ch = DrawingSymbol.X.value();
        char[][] canvas = CanvasTestData.NEW_CANVAS;
        Assertions.assertThrows(InvalidCommandException.class,
                () -> CommandHelper.drawLine(canvas, x1, y1, x2, y2, ch));

    }*/
}