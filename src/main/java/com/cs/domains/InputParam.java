package com.cs.domains;

import java.util.ArrayList;
import java.util.List;

/**
 * The class represents the input parameters provided in {@link UserInput}
 *
 * @author anuja
 */
public final class InputParam {
    private List<Point> points;
    private char symbol;

    public InputParam(List<Point> points) {
        this.points = new ArrayList<>();
        points.forEach(value -> this.points.add(value));
    }

    public void withSymbol(char symbol) {
        this.symbol = symbol;
    }

    public List<Point> points() {
        return points;
    }

    public char symbol() {
        return symbol;
    }

    @Override
    public String toString() {
        return "InputParam{" +
                "points=" + points +
                ", symbol=" + symbol +
                '}';
    }
}
