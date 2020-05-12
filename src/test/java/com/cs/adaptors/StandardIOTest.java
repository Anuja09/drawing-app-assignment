package com.cs.adaptors;

import com.cs.CanvasTestData;
import com.cs.domains.Canvas;
import com.cs.exception.DrawingException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.doReturn;

@ExtendWith(MockitoExtension.class)
class StandardIOTest {
    @Mock
    private Canvas canvas;

    @InjectMocks
    private StandardIO standardIO;

    @Test
    void shouldRender() {
        doReturn(null).when(canvas).description();
        char[][] blocks = CanvasTestData.VALID_CANVAS;
        doReturn(blocks).when(canvas).blocks();
        doReturn(4).when(canvas).height();
        doReturn(5).when(canvas).width();
        standardIO.render(canvas);
        assertTrue(6 == canvas.blocks().length);
        assertTrue(7 == canvas.blocks()[0].length);
        assertTrue(4 == canvas.height());
        assertTrue(5 == canvas.width());
    }

    @Test
    void shouldRender_message_whenCanvasNULL() {
        Assertions.assertThrows(DrawingException.class, () -> {
            standardIO.render(null);
        });
    }

    @Test
    void shouldRender_description_whenDescrNotEmpty() {
        doReturn("Description on console").when(canvas).description();
        canvas.withDescription(null);
        standardIO.render(canvas);
        assertTrue("Description on console".equals(canvas.description()));
    }
}