import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) {
        ConsoleWrapper cw = new ConsoleWrapper();
        Hotel hotel = new Hotel();
        cw.print("Welcome to HotelManager version 0.2");
        cw.print("To learn about available commands, type 'help'");
        cw.print("To exit the system, type 'exit'. Be sure to save the data beforehand!");
        while (true) {
            String command = cw.getString(0, ">>> ");
            Method[] commands = CommandHandler.class.getDeclaredMethods();
            if (command.equalsIgnoreCase("exit")) {
                break;
            }
            matchCommand : {
                for (Method c : commands) {
                    if (command.equalsIgnoreCase(c.getName())) {
                        try {
                            c.invoke(null, cw, hotel);
                        } catch (IllegalAccessException | InvocationTargetException e) {
                            cw.print(1, "%s", e.getMessage());
                        }
                        break matchCommand;
                    }
                }
                cw.print(1, "No matching action for command with name '%s'", command);
            }
        }
    }
}