package com.cs.adaptors;

import com.cs.domains.Canvas;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

class ConsoleAdaptorTest {

    @Mock
    private DrawingConsole console = new StandardIO();

    @InjectMocks
    private ConsoleAdaptor consoleAdaptor = new ConsoleAdaptor(console);

    @Test
    void shouldAccept() {
        Canvas canvas = new Canvas(4, 5);
        consoleAdaptor.accept(canvas);
    }
}