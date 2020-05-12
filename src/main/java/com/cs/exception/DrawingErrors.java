package com.cs.exception;

import com.cs.validators.CanvasConstraints;

/**
 * Error Messages
 *
 * @author anuja
 */
public class DrawingErrors {
    public static final String SEE_HELP = "Run 'H' command for details of supported commands.";
    public static final String ERR_PARSING_COMMAND = "Parse Error! " + SEE_HELP;
    public static final String ERR_INVALID_COMMAND = "Syntax Error! " + SEE_HELP;
    public static final String ERR_CANVAS_NULL = "Canvas not found! " + SEE_HELP;
    public static final String ERR_LINES_NOT_SUPPORTED = "Only horizontal or vertical lines are supported.";
    public static final String ERR_INVALID_CANVAS = "Improper layout of canvas!" + SEE_HELP;
    public static final String ERR_CANVAS_CONSTRAINTS_VIOLATION = "Invalid height or width! Constraints:" +
            CanvasConstraints.CANVAS_MIN_WIDTH + "<=w<=" + CanvasConstraints.CANVAS_MAX_WIDTH
            + "," + CanvasConstraints.CANVAS_MIN_HEIGHT + "<=h<="
            + CanvasConstraints.CANVAS_MAX_HEIGHT + ". " + SEE_HELP;
    public static final String ERR_CANVAS_CONSTRAINT_COLOR = "Invalid color! Only alphabets supported." + SEE_HELP;
    public static final String ERR_X_Y_CONSTRAINTS_VIOLATION = "Invalid x or y! Constraints:1<=x<=w, 1<=y<=h. "
            + SEE_HELP;
    public static final String ERR_UNKNOWN_COMMAND = "Unknown Command! " + SEE_HELP;

    private DrawingErrors() {

    }
}
