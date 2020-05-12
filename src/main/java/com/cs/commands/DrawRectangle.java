package com.cs.commands;

import com.cs.commands.helper.CommandHelper;
import com.cs.domains.Canvas;
import com.cs.domains.DrawingSymbol;
import com.cs.domains.UserInput;
import com.cs.validators.ValidationHelper;

/**
 * This class represents the draw rectangle command and performs validations.
 * R x1 y1 x2 y2 -
 * It creates a new rectangle, whose upper left corner is (x1,y1)
 * and lower right corner is (x2,y2). Horizontal and vertical lines
 * will be drawn using the 'x' character.
 *
 * @author anuja
 */
public class DrawRectangle implements ICommand {
    private Canvas canvas;

    public DrawRectangle(Canvas canvas) {
        this.canvas = canvas;
    }

    @Override
    public void execute(UserInput command) {
        int x1 = command.inputParams().points().get(0).getX();
        int y1 = command.inputParams().points().get(0).getY();
        int x2 = command.inputParams().points().get(1).getX();
        int y2 = command.inputParams().points().get(1).getY();
        char symbol = DrawingSymbol.X.value();
        char[][] canvasArr = this.canvas.blocks();
        CommandHelper.drawLine(canvasArr, x1, y1, x2, y1, symbol);
        CommandHelper.drawLine(canvasArr, x1, y1, x1, y2, symbol);
        CommandHelper.drawLine(canvasArr, x2, y1, x2, y2, symbol);
        CommandHelper.drawLine(canvasArr, x1, y2, x2, y2, symbol);
        this.canvas.withBlocks(canvasArr);
    }

    @Override
    public Canvas get() {
        return this.canvas;
    }

    @Override
    public void validate(UserInput inputCommand) {
        ValidationHelper.validateLineConstraints(inputCommand, canvas);
    }
}
