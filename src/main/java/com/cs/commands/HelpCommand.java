package com.cs.commands;

import com.cs.domains.Canvas;
import com.cs.domains.UserInput;
import com.cs.validators.CanvasConstraints;
import com.cs.validators.ValidationHelper;

/**
 * This class represents help command and performs validations.
 * H - It list all supported commands to canvas.
 *
 * @author anuja
 */
public class HelpCommand implements ICommand {
    private Canvas canvas;

    public HelpCommand(Canvas canvas) {
        this.canvas = canvas;
    }

    @Override
    public void execute(UserInput command) {
        StringBuilder helpStr = new StringBuilder();
        helpStr.append("C w h\t").append("-It create a new canvas of width w and height h.")
                .append("Constraints:1)" + CanvasConstraints.CANVAS_MIN_WIDTH + "<=w<=" + CanvasConstraints.CANVAS_MAX_WIDTH)
                .append("," + CanvasConstraints.CANVAS_MIN_HEIGHT + "<=h<=" + CanvasConstraints.CANVAS_MAX_HEIGHT +
                        "\t2)1<=x<=w, 1<=y<=h for any x,y on canvas.\n")
                .append("L x1 y1 x2 y2\t").append("-It creates a new line from (x1,y1) to (x2,y2). " +
                "Currently only horizontal or vertical lines are supported. " +
                "Horizontal and vertical lines will be drawn using the 'x' character.\n")
                .append("R x1 y1 x2 y2\t").append("-It creates a new rectangle, whose upper left corner is " +
                "(x1,y1) and lower right corner is (x2,y2). Horizontal and vertical lines" +
                " will be drawn using the 'x' character.\n")
                .append("B x y c\t").append("-It fill the entire area connected to (x,y) with colour c. The " +
                "behaviour of this is the same as that of the 'bucket fill' tool in paint" +
                " programs.\n")
                .append("Q\t").append("-It quits the program.\n")
                .append("H\t").append("-It list all supported commands.\n");
        this.canvas.withDescription("Supported Commands are \n" + helpStr);
    }

    @Override
    public Canvas get() {
        return this.canvas;
    }

    @Override
    public void validate(UserInput inputCommand) {
        ValidationHelper.checkForNull(inputCommand);
        ValidationHelper.checkForNotNull(inputCommand.inputParams());
    }
}
