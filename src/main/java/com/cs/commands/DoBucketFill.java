package com.cs.commands;

import com.cs.commands.helper.CommandHelper;
import com.cs.domains.Canvas;
import com.cs.domains.UserInput;
import com.cs.validators.ValidationHelper;

/**
 * This class represents the bucket fill command and perform validations.
 * B x y c - It fill the entire area connected to (x,y) with colour c.
 * The behaviour of this is the same as that of the 'bucket fill' tool in paint programs.
 *
 * @author anuja
 */
public class DoBucketFill implements ICommand {
    private Canvas canvas;

    public DoBucketFill(Canvas canvas) {
        this.canvas = canvas;
    }


    @Override
    public void execute(UserInput command) {
        char[][] canvasArr = this.canvas.blocks();
        CommandHelper.bucketFill(canvasArr, command.inputParams().points().get(0).getX(),
                command.inputParams().points().get(0).getY(),
                command.inputParams().symbol());

        this.canvas.withBlocks(canvasArr);

    }

    @Override
    public Canvas get() {
        return canvas;
    }

    @Override
    public void validate(UserInput inputCommand) {
        ValidationHelper.checkForNull(inputCommand);
        ValidationHelper.checkForNull(inputCommand.inputParams());
        ValidationHelper.checkForValidPointsCount(inputCommand.inputParams().points(), 1);
        ValidationHelper.checkForValidPoint(canvas, inputCommand.inputParams().points().get(0));
        ValidationHelper.checkForValidColorSymbol(inputCommand);
        ValidationHelper.checkForNull(canvas);

    }
}
