package com.cs.validators;

import com.cs.domains.Canvas;
import com.cs.domains.InputParam;
import com.cs.domains.Point;
import com.cs.domains.UserInput;
import com.cs.exception.DrawingErrors;
import com.cs.exception.DrawingException;

import java.util.List;

/**
 * ValidationHelper - the class is helper for validations of user input commands.
 *
 * @author anuja
 */
public class ValidationHelper {
    private ValidationHelper() {

    }

    public static void checkForNull(Canvas canvas) {
        if (null == canvas || canvas.isEmpty()) {
            throw new DrawingException(DrawingErrors.ERR_CANVAS_NULL);
        }
    }

    public static void checkForNull(InputParam inputParam) {
        if (null == inputParam) {
            throw new DrawingException(DrawingErrors.ERR_INVALID_COMMAND);
        }
    }

    public static void checkForNotNull(InputParam inputParam) {
        if (null != inputParam) {
            throw new DrawingException(DrawingErrors.ERR_INVALID_COMMAND);
        }
    }

    public static void checkForValidPoint(Canvas canvas, Point point) {
        if (null != canvas && !(ConstraintsValidator.isValidX(point.getX(), canvas.width())
                && ConstraintsValidator.isValidY(point.getY(), canvas.height()))) {
            throw new DrawingException(DrawingErrors.ERR_X_Y_CONSTRAINTS_VIOLATION);
        }
    }

    public static void checkForNull(UserInput inputCommand) {
        if (null == inputCommand) {
            throw new DrawingException(DrawingErrors.ERR_INVALID_COMMAND);
        }
    }

    public static void checkForValidPointsCount(List<Point> points, int count) {
        if (null != points && points.size() != count) {
            throw new DrawingException(DrawingErrors.ERR_INVALID_COMMAND);
        }
    }

    public static void checkForValidColorSymbol(UserInput inputCommand) {
        if (!(ConstraintsValidator.isValidSymbol(inputCommand.inputParams().symbol()))) {
            throw new DrawingException(DrawingErrors.ERR_CANVAS_CONSTRAINT_COLOR);
        }
    }

    public static void checkForValidCanvasDimensions(UserInput inputCommand) {
        List<Point> points = inputCommand.inputParams().points();
        if (!(ConstraintsValidator
                .isValidCanvasConstraints(points.get(0).getX()
                        , points.get(0).getY()))) {
            throw new DrawingException(
                    DrawingErrors.ERR_CANVAS_CONSTRAINTS_VIOLATION);
        }
    }

    public static void checkForNullSymbol(char symbol) {
        if (0 != symbol) {
            throw new DrawingException(
                    DrawingErrors.ERR_INVALID_COMMAND);
        }
    }

    /*
    Note:this method has all input validations common to draw line and draw rectangle commands.
    and if any validation not common to both line and rectangle, then it should not be added in this method.
     */
    public static void validateLineConstraints(UserInput inputCommand, Canvas canvas) {
        checkForNull(inputCommand);
        checkForNull(inputCommand.inputParams());
        checkForNullSymbol(inputCommand.inputParams().symbol());
        checkForValidPointsCount(inputCommand.inputParams().points(), 2);
        checkForNull(canvas);
        checkForValidPoint(canvas, inputCommand.inputParams().points().get(0));
        checkForValidPoint(canvas, inputCommand.inputParams().points().get(1));
    }


}
