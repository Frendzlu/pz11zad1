import java.io.Console;

public class ConsoleWrapper {
    public Console csl;

    public ConsoleWrapper() {
        csl = System.console();
    }

    public int getInt(int indent, String message) {
        boolean isInt = false;
        int number = 0;
        while (!isInt) {
            try {
                number = Integer.parseInt(csl.readLine("\t".repeat(indent) + message));
            } catch (NumberFormatException e) {
                csl.printf("\t".repeat(indent) + "Please enter an integer.\n");
                continue;
            }
            isInt = true;
        }
        return number;
    }

    public double getDouble(int indent, String message) {
        boolean isDouble = false;
        double number = 0;
        while (!isDouble) {
            try {
                number = Double.parseDouble(csl.readLine("\t".repeat(indent) + message));
            } catch (NumberFormatException e) {
                csl.printf("\t".repeat(indent) + "Please enter a numeric value.\n");
                continue;
            }
            isDouble = true;
        }
        return number;
    }

    public String getString(int indent, String message) {
        return csl.readLine("\t".repeat(indent) + message);
    }

    public String getString(int indent, String format, Object... args) {
        return csl.readLine("\t".repeat(indent) + format, args);
    }

    public void print(int indent, String format, Object... args) {
        csl.printf("\t".repeat(indent) + format + "\n", args);
    }

    public void print(int indent, String message) {
        csl.printf("\t".repeat(indent) + message + "\n");
    }

    public void print(String message) {
        csl.printf(message + "\n");
    }
}
