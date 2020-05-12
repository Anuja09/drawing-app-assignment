package com.cs.domains;

import java.util.Arrays;

/**
 * This class represents the canvas for drawing or the description provided.
 * <p>
 * The {{@link #blocks}} is of dimensions {{@link #height}} and {{@link #width}} for drawing
 * <p>
 * The {{@link #description}} is the description provided.
 *
 * @author anuja
 */
public class Canvas {
    private int height;
    private int width;
    private char[][] blocks;
    private String description;

    public Canvas(int height, int width) {
        this.height = height;
        this.width = width;
        this.blocks = new char[height + 2][width + 2];
    }

    public Canvas() {
        this.height = -1;
        this.width = -1;
    }

    public boolean isEmpty() {
        if (this.height <= 0 || this.width <= 0) {
            return true;
        }
        return false;
    }

    public int height() {
        return height;
    }

    public int width() {
        return width;
    }

    public char[][] blocks() {
        return this.blocks;
    }

    public void withBlocks(char[][] blocks) {
        this.blocks = blocks;
    }

    public void withDescription(String description) {
        this.description = description;
    }

    public String description() {
        return this.description;
    }

    @Override
    public String toString() {
        return "Canvas{" +
                "height=" + height +
                ", width=" + width +
                ", blocks=" + Arrays.toString(blocks) +
                ", description='" + description + '\'' +
                '}';
    }
}
