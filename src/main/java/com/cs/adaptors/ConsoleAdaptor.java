package com.cs.adaptors;

import com.cs.domains.Canvas;

import java.util.function.Consumer;

/**
 * The adaptor class delegates to appropriate console to display the {@link Canvas}
 *
 * @author anuja
 */
public class ConsoleAdaptor implements Consumer<Canvas> {
    private DrawingConsole console;

    public ConsoleAdaptor(DrawingConsole console) {
        this.console = console;
    }

    @Override
    public void accept(Canvas canvas) {
        console.render(canvas);
    }
}
