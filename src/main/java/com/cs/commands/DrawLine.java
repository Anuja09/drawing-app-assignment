package com.cs.commands;

import com.cs.commands.helper.CommandHelper;
import com.cs.domains.Canvas;
import com.cs.domains.DrawingSymbol;
import com.cs.domains.UserInput;
import com.cs.validators.ValidationHelper;

/**
 * This class represents line command and performs validations.
 * L x1 y1 x2 y2 -
 * It creates a new line from (x1,y1) to (x2,y2).
 * Currently only horizontal or vertical lines are supported.
 * Horizontal and vertical lines will be drawn using the 'x' character.
 *
 * @author anuja
 */
public class DrawLine implements ICommand {
    private Canvas canvas;

    public DrawLine(Canvas canvas) {
        this.canvas = canvas;
    }

    @Override
    public void execute(UserInput command) {
        int x1 = command.inputParams().points().get(0).getX();
        int y1 = command.inputParams().points().get(0).getY();
        int x2 = command.inputParams().points().get(1).getX();
        int y2 = command.inputParams().points().get(1).getY();
        char symbol = DrawingSymbol.X.value();
        char[][] canvasArr = canvas.blocks();
        CommandHelper.drawLine(canvasArr, x1, y1, x2, y2, symbol);
        canvas.withBlocks(canvasArr);
    }

    @Override
    public Canvas get() {
        return canvas;
    }

    @Override
    public void validate(UserInput inputCommand) {
        ValidationHelper.validateLineConstraints(inputCommand, canvas);
    }


}
