import jdk.jfr.Description;

import java.io.Console;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Console csl = System.console();
        csl.printf("Welcome to HotelManager version 0.1\n");
        csl.printf("To learn about available commands, type 'help'\n");
        csl.printf("To exit the system, type 'exit'. Be sure to save the data beforehand!\n");
        while (true) {
            csl.printf(">>> ");
            String command = csl.readLine();
            Method[] commands = CommandHandler.class.getDeclaredMethods();
            if (command.equalsIgnoreCase("exit")) {
                break;
            }
            if (command.equalsIgnoreCase("help")) {
                csl.printf("\tAvailable commands:\n");
                csl.printf("\t - 'help'\n");
                csl.printf("\t\tShows the list of commands you are currently seeing\n");
                csl.printf("\t - 'exit'\n");
                csl.printf("\t\tExits the program without asking if you want to save\n");
                for (Method c : commands) {
                    csl.printf("\t - '%s'\n", c.getName());
                    csl.printf("\t\t%s\n", c.getDeclaredAnnotation(Description.class).value());
                }
                continue;
            }
            matchCommand : {
                for (Method c : commands) {
                    if (command.equalsIgnoreCase(c.getName())) {
                        try {
                            c.invoke(null, csl);
                        } catch (IllegalAccessException | InvocationTargetException e) {
                            csl.printf("\t%s\n", e.getMessage());
                        }
                        break matchCommand;
                    }
                }
                csl.printf("\tNo matching action for command with name '%s'\n", command);
            }
        }
    }
}