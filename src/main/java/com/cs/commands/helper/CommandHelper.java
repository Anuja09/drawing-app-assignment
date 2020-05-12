package com.cs.commands.helper;

import com.cs.domains.DrawingSymbol;
import com.cs.domains.Point;
import com.cs.exception.DrawingErrors;
import com.cs.exception.DrawingException;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * This is the helper class for drawing commands and provides core apis for drawing on canvas.
 *
 * @author anuja
 */
public class CommandHelper {

    private CommandHelper() {

    }

    /**
     * This method takes (x1,y1) and (x2,y2) coordinates and draws line
     * on {@link com.cs.domains.Canvas}
     *
     * @param canvas
     * @param x1
     * @param y1
     * @param x2
     * @param y2
     * @param ch
     */
    public static void drawLine(char[][] canvas, int x1, int y1, int x2, int y2, char ch) {
        checkForNull(canvas);

        checkForCanvasDimensions(canvas.length, canvas[0].length);

        //If line is vertical
        if (x1 == x2) {
            drawVerticalLine(x1, y1, y2, ch, canvas);
        }//else if line is horizontal
        else if (y1 == y2) {
            drawHorizontalLine(x1, y1, x2, ch, canvas);
        } else {
            throw new DrawingException(DrawingErrors.ERR_LINES_NOT_SUPPORTED);
            //E.g. 1) L 1 1 1 3
            //2) L 1 5 4 5
        }
    }

    private static void checkForNull(char[][] canvas) {
        if (null == canvas) {
            throw new DrawingException(DrawingErrors.ERR_CANVAS_NULL);
        }
    }

    /**
     * This method draws horizontal line.
     *
     * @param x1
     * @param y1
     * @param x2
     * @param ch
     * @param canvas
     */
    private static void drawHorizontalLine(int x1, int y1, int x2, char ch,
                                           char[][] canvas) {
        if (x1 > x2) return;
        canvas[y1][x1] = ch;
        drawHorizontalLine(x1 + 1, y1, x2, ch, canvas);
    }

    /**
     * This method draws vertical line.
     *
     * @param x1
     * @param y1
     * @param y2
     * @param ch
     * @param canvas
     */
    private static void drawVerticalLine(int x1, int y1,
                                         int y2, char ch, char[][] canvas) {
        if (y1 > y2) return;
        canvas[y1][x1] = ch;
        drawVerticalLine(x1, y1 + 1, y2, ch, canvas);
    }

    /**
     * This method performs bucket fill the entire area connected to (x,y)
     * with provided color symbol.
     *
     * @param canvas
     * @param x
     * @param y
     * @param ch
     */
    public static void bucketFill(char[][] canvas, int x, int y, char ch) {
        checkForNull(canvas);

        checkForCanvasDimensions(canvas.length, canvas[0].length);

        bucketFillInner(canvas, x, y, ch, canvas[y][x]);
    }

    private static void bucketFillInner(char[][] canvas, int x, int y, char ch, char prevCh) {
        Set<Point> visited = new HashSet<>();
        Queue<Point> points = new LinkedList<>();
        points.add(new Point(x, y));

        while (!points.isEmpty()) {
            Point currentPoint = points.poll();
            if (!visited.add(currentPoint)) {
                /*if already visited*/
            } else if (prevCh != canvas[currentPoint.getY()][currentPoint.getX()]) {
                /*if the current block is not having the prev color*/
            } else if ((currentPoint.getY() > canvas.length || currentPoint.getY() < 1)) {
                /*if y of current point is not outside the canvas*/
            } else if ((currentPoint.getX() > canvas[0].length || currentPoint.getX() < 1)) {
                /*if x of current point is not outside the canvas*/
            } else {
                //fill color
                canvas[currentPoint.getY()][currentPoint.getX()] = ch;
                //visit left
                points.add(new Point(currentPoint.getX() - 1, currentPoint.getY()));
                //visit right
                points.add(new Point(currentPoint.getX() + 1, currentPoint.getY()));
                //visit up
                points.add(new Point(currentPoint.getX(), currentPoint.getY() - 1));
                //visit down
                points.add(new Point(currentPoint.getX(), currentPoint.getY() + 1));
            }
        }
    }

    public static void bucketFill_old(char[][] canvas, int x, int y, char ch) {
        checkForNull(canvas);

        checkForCanvasDimensions(canvas.length, canvas[0].length);

        bucketFillInner_old(canvas, x, y, ch);
    }

    private static void bucketFillInner_old(char[][] canvas, int x, int y, char ch) {
        if (DrawingSymbol.BLANK.value() != canvas[y][x]) return;
        if (x > canvas[0].length || x < 1) return;
        if (y > canvas.length || y < 1) return;

        canvas[y][x] = ch;

        bucketFillInner_old(canvas, x - 1, y, ch);
        bucketFillInner_old(canvas, x + 1, y, ch);
        bucketFillInner_old(canvas, x, y - 1, ch);
        bucketFillInner_old(canvas, x, y + 1, ch);
    }

    private static void checkForCanvasDimensions(int height, int width) {
        if ((height - 2) < 1 || (width - 2) < 1) {
            throw new DrawingException(DrawingErrors.ERR_INVALID_CANVAS);
        }
    }
}
