package com.cs.adaptors;

import com.cs.domains.Canvas;
import com.cs.exception.DrawingErrors;
import com.cs.exception.DrawingException;

/**
 * The StandardIO is the default implementation of the CanvasConsole
 * to display canvas on the standard IO console.
 *
 * @author anuja
 */
public class StandardIO implements DrawingConsole {
    @Override
    public void render(Canvas canvas) {
        if (canvas == null) {
            throw new DrawingException(DrawingErrors.ERR_CANVAS_NULL);
        }

        if (canvas.description() != null && !canvas.description().isEmpty()) {
            System.out.println(canvas.description());
            canvas.withDescription(null);
        } else {
            char[][] canvasArr = canvas.blocks();
            if (canvasArr != null && canvasArr.length > 1) {
                for (int i = 0; i < canvasArr.length; i++) {
                    for (int j = 0; j < canvasArr[0].length; j++) {
                        System.out.print(canvasArr[i][j]);
                    }
                    System.out.print("\n");
                }
            }
        }
    }
}
