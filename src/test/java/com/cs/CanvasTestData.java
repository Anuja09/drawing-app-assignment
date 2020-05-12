package com.cs;

public class CanvasTestData {
    public static char[][] VALID_CANVAS = {
            {'-', '-', '-', '-', '-', '-', '-'},
            {'|', 'x', ' ', ' ', ' ', ' ', '|'},
            {'|', 'x', ' ', 'x', 'x', 'x', '|'},
            {'|', 'x', 'x', 'x', ' ', 'x', '|'},
            {'|', 'o', 'o', 'x', 'x', 'x', '|'},
            {'-', '-', '-', '-', '-', '-', '-'}
    };

    public static char[][] NEW_CANVAS = {
            {'-', '-', '-', '-', '-', '-', '-'},
            {'|', ' ', ' ', ' ', ' ', ' ', '|'},
            {'|', ' ', ' ', ' ', ' ', ' ', '|'},
            {'|', ' ', ' ', ' ', ' ', ' ', '|'},
            {'|', ' ', ' ', ' ', ' ', ' ', '|'},
            {'-', '-', '-', '-', '-', '-', '-'}
    };

    public static char[][] EMPTY_CANVAS = {
            {'-', '-'},
            {'|', '|'},
            {'-', '-'}
    };

    public static char[][] CANVAS_WITH_INVALID_HEIGHT = {
            {'-', '-', '-', '-', '-', '-', '-'},
            {'-', '-', '-', '-', '-', '-', '-'}
    };

    public static char[][] CANVAS_WITH_INVALID_WIDTH = {
            {'-'},
            {'|'},
            {'|'},
            {'|'},
            {'|'},
            {'-'}
    };

    public static char[][] VALID_CANVAS_7X7 = {
            {'-', '-', '-', '-', '-', '-', '-', '-', '-'},
            {'|', 'x', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
            {'|', 'x', ' ', 'x', 'x', 'x', 'x', ' ', '|'},
            {'|', 'x', ' ', 'x', ' ', ' ', 'x', ' ', '|'},
            {'|', ' ', ' ', 'x', 'x', 'x', 'x', ' ', '|'},
            {'|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
            {'|', 'x', 'x', 'x', 'x', 'x', 'x', 'x', '|'},
            {'|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
            {'-', '-', '-', '-', '-', '-', '-', '-', '-'}
    };

    public static char[][] VALID_CANVAS_7X7_1 = {
            {'-', '-', '-', '-', '-', '-', '-', '-', '-'},
            {'|', 'x', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
            {'|', 'x', ' ', 'x', 'x', 'x', 'x', ' ', '|'},
            {'|', 'x', ' ', 'x', ' ', ' ', 'x', ' ', '|'},
            {'|', ' ', ' ', 'x', 'x', 'x', 'x', ' ', '|'},
            {'|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
            {'|', 'x', 'x', 'x', 'x', 'x', 'x', 'x', '|'},
            {'|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
            {'-', '-', '-', '-', '-', '-', '-', '-', '-'}
    };


    public static void printCanvas(char[][] canvas) {
        for (int i = 0; i < canvas.length; i++) {
            for (int j = 0; j < canvas[0].length; j++) {
                System.out.print(canvas[i][j]);
            }
            System.out.print("\n");
        }
    }

}