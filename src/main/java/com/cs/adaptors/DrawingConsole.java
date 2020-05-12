package com.cs.adaptors;

import com.cs.domains.Canvas;

/**
 * This class represents the console for displaying the {@link com.cs.domains.Canvas}.
 * In order to display canvas on different consoles, one needs to implement
 * this interface.
 *
 * @author anuja
 */
public interface DrawingConsole {
    void render(Canvas canvas);
}
