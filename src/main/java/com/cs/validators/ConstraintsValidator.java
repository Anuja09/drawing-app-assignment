package com.cs.validators;

/**
 * This class validates canvas constraints;
 *
 * @author anuja
 */
public class ConstraintsValidator {
    private ConstraintsValidator() {
    }

    public static boolean isValidCanvasConstraints(int width, int height) {
        return isValidCanvasHeight(height) && isValidCanvasWidth(width);
    }

    public static boolean isValidCanvasHeight(int height) {
        return Math.max(CanvasConstraints.CANVAS_MIN_HEIGHT, height)
                == Math.min(height, CanvasConstraints.CANVAS_MAX_HEIGHT);
    }

    public static boolean isValidCanvasWidth(int width) {
        return Math.max(CanvasConstraints.CANVAS_MIN_WIDTH, width)
                == Math.min(width, CanvasConstraints.CANVAS_MAX_WIDTH);
    }

    public static boolean isValidX(int x, int width) {
        return Math.max(1, x) == Math.min(x, width);
    }

    public static boolean isValidY(int y, int height) {
        return Math.max(1, y) == Math.min(y, height);
    }

    public static boolean isValidSymbol(char symbol) {
        return Character.isUpperCase(symbol) || Character.isLowerCase(symbol);
    }
}
