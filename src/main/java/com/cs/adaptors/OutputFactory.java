package com.cs.adaptors;

/**
 * This class return the instance of the OutputConsole based on configuration
 * e.g. OUTPUT=CONSOLE
 * CONSOLE is default and can be configured with different implementation of
 * {@link DrawingConsole}
 *
 * @author anuja
 */
public class OutputFactory {

    private static OutputFactory outputFactory = new OutputFactory();

    public static OutputFactory getInstance() {
        return outputFactory;
    }

    private OutputFactory() {

    }

    public DrawingConsole getOuputWindow(Output output) {
        if (Output.CONSOLE == output) {
            return new StandardIO();
        }
        return null;
    }
}
