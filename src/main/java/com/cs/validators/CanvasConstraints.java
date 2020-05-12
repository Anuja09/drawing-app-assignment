package com.cs.validators;

import com.cs.domains.Canvas;

/**
 * This class represents the constraints of {@link Canvas} provided for drawing
 * e.g.
 * 1<=height<=50, 1<=width<=50
 * 1<=x<=width && 1<=y<=height
 *
 * @author anuja
 */
public class CanvasConstraints {
    /*1<=height<=50, 1<=width<=50*/
    public static final int CANVAS_MIN_HEIGHT = 1;
    public static final int CANVAS_MAX_HEIGHT = 200;
    public static final int CANVAS_MIN_WIDTH = 1;
    public static final int CANVAS_MAX_WIDTH = 200;

    private CanvasConstraints() {

    }
}
