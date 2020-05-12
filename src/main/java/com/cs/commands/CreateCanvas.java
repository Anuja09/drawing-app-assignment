package com.cs.commands;

import com.cs.commands.helper.CommandHelper;
import com.cs.domains.Canvas;
import com.cs.domains.DrawingSymbol;
import com.cs.domains.UserInput;
import com.cs.validators.ValidationHelper;

/**
 * This class represents the create canvas command and performs validations.
 * C w h - It create a new canvas of width w and height h.
 *
 * @author anuja
 */
public class CreateCanvas implements ICommand {
    private Canvas canvas;

    public CreateCanvas(Canvas canvas) {
        this.canvas = canvas;
    }

    @Override
    public void execute(UserInput command) {
        int width = command.inputParams().points().get(0).getX();
        int height = command.inputParams().points().get(0).getY();
        this.canvas = new Canvas(height, width);
        char[][] canvasArr = this.canvas.blocks();

        //draw top and bottom horizontal lines
        line(canvasArr, 0, 0, width + 1, 0, DrawingSymbol.HYPHEN.value());
        line(canvasArr, 0, height + 1, width + 1, height + 1, DrawingSymbol.HYPHEN.value());

        //draw left and right vertical line
        line(canvasArr, 0, 1, 0, height, DrawingSymbol.PIPE.value());
        line(canvasArr, width + 1, 1, width + 1, height, DrawingSymbol.PIPE.value());

        //draw spaces for rest of indices
        for (int i = 1; i <= height; i++) {
            line(canvasArr, 1, i, width, i, DrawingSymbol.BLANK.value());
        }
        this.canvas.withBlocks(canvasArr);
    }

    private void line(char[][] canvasArr, int x1, int y1, int x2, int y2, char symbol) {
        CommandHelper.drawLine(canvasArr, x1, y1, x2, y2, symbol);
    }

    @Override
    public Canvas get() {
        return this.canvas;
    }

    @Override
    public void validate(UserInput inputCommand) {
        ValidationHelper.checkForNull(inputCommand);
        ValidationHelper.checkForNull(inputCommand.inputParams());
        ValidationHelper.checkForValidPointsCount(inputCommand.inputParams().points(), 1);
        ValidationHelper.checkForNullSymbol(inputCommand.inputParams().symbol());
        ValidationHelper.checkForValidCanvasDimensions(inputCommand);
    }

}
