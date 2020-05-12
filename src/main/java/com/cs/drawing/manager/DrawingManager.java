package com.cs.drawing.manager;

import com.cs.adaptors.ConsoleAdaptor;
import com.cs.adaptors.DrawingConsole;
import com.cs.adaptors.Output;
import com.cs.adaptors.OutputFactory;
import com.cs.commands.CommandExecutor;
import com.cs.commands.ICommand;
import com.cs.commands.factory.CommandFactory;
import com.cs.config.Configuration;
import com.cs.config.Property;
import com.cs.domains.Canvas;
import com.cs.domains.UserInput;
import com.cs.exception.DrawingException;
import com.cs.parser.CommandParser;

import java.util.Arrays;

/**
 * This class controls calls to parser,
 * factory for retrieving appropriate Command instance,
 * invoking respective validator implementation,
 * delegates the execution to command executor
 * and output to the selected console adaptor to render canvas.
 *
 * @author anuja
 */
public final class DrawingManager {
    private Canvas canvas = new Canvas();
    private CommandParser commandParser;
    private CommandExecutor commandExecutor;
    private DrawingConsole console;
    private static DrawingManager drawingManager = null;

    public static DrawingManager getInstance() {
        if (drawingManager == null) {
            drawingManager = new DrawingManager();

        }
        return drawingManager;
    }

    private DrawingManager() {
        commandParser = new CommandParser();
        console = getConsoleInstance();
        commandExecutor = new CommandExecutor();
    }

    /**
     * This method invokes the parser, validator, command executor
     * and output console adaptor to draw shape on canvas.
     *
     * @param commandStr
     */
    public void handle(String commandStr) {
        try {
            commandStr = commandStr.toUpperCase();
            UserInput inputCommand = commandParser.parse(commandStr);
            ICommand command = CommandFactory.getInstance(inputCommand, canvas);
            command.validate(inputCommand);
            commandExecutor.withCommand(command).submit(inputCommand);
            canvas = command.get();
            //Send output to console for rendering
            new ConsoleAdaptor(console).accept(canvas);
        } catch (DrawingException e) {
            canvas.withDescription(e.getMessage());
            //Send output to console for rendering
            new ConsoleAdaptor(console).accept(canvas);
        } catch (Exception e) {
            System.out.println("log:ERROR Something went wrong with reason:" + e.getMessage());
            e.printStackTrace();
        }
    }

    private DrawingConsole getConsoleInstance() {
        Output output = null;
        String outputType = Configuration.getInstance().getProperty(Property.OUTPUT);
        if (null != outputType) {
            output = Arrays.stream(Output.values())
                    .filter(outputVal -> outputVal.name().equals(outputType))
                    .findFirst()
                    .orElseThrow(() -> new IllegalArgumentException("Invalid Output Console : " + outputType));
        }
        return OutputFactory.getInstance().getOuputWindow(output);
    }

    public Canvas canvas() {
        return this.canvas;
    }
}
