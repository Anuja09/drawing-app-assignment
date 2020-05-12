package com.cs;

import com.cs.config.Configuration;
import com.cs.domains.CommandName;
import com.cs.drawing.manager.DrawingManager;

import java.util.Scanner;

/**
 * The main class running drawing program on console
 *
 * @author anuja
 */
public class DrawingApplication {

    public static void main(String[] args) {
        runApplication();
    }

    public static void runApplication() {
        Configuration.getInstance().initialize();

        Scanner scanner = new Scanner(System.in);
        String commandStr = "";

        while (!CommandName.Q.name().equalsIgnoreCase(commandStr)) {
            System.out.println("\nEnter command: ");
            commandStr = scanner.nextLine();
            if (!commandStr.trim().isEmpty()) {
                if (commandStr.equalsIgnoreCase(CommandName.Q.value()) && !ensureQuit()) {
                    commandStr = "";
                } else {
                    DrawingManager.getInstance().handle(commandStr);
                }
            }
        }

    }

    private static boolean ensureQuit() {
        boolean quit = true;
        Scanner scanner = new Scanner(System.in);
        String yORn = "";
        while (!(yORn.equalsIgnoreCase("n") || yORn.equalsIgnoreCase("y"))) {
            System.out.println("Do you want to quit, y/n?");
            yORn = scanner.next();
            if ("N".equalsIgnoreCase(yORn)) {
                quit = false;
                break;
            }
        }
        return quit;
    }
}
