package com.cs.domains;

/**
 * List of allowed commands
 * C - create canvas
 * L - draw line
 * R - draw rectangle
 * B - bucket fill
 * Q - Quit
 * H - help to see list of commands supported
 *
 * @author anuja
 */
public enum CommandName {
    C("C"), L("L"), R("R"), B("B"), Q("Q"), H("H");

    String value;

    CommandName(String value) {
        this.value = value;
    }

    public String value() {
        return this.value;
    }
}
