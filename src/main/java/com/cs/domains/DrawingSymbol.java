package com.cs.domains;

/**
 * Drawing symbols used for drawing on canvas
 * E.g.
 * X is used to draw line an rectangle.
 * ORANGE is used to apply bucket fill on canvas.
 *
 * @author anuja
 */
public enum DrawingSymbol {
    BLANK(' '), HYPHEN('-'), PIPE('|'), X('x');
    char symbol;

    DrawingSymbol(char symbol) {
        this.symbol = symbol;
    }

    public char value() {
        return symbol;
    }
}
