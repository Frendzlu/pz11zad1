import jdk.jfr.Description;
import java.lang.reflect.Method;

public class CommandHandler {
    @Description("Shows all available commands")
    public static void help(ConsoleWrapper csl, Hotel hotel) {
        csl.print(1, "Available commands:");
        csl.print(1, " - 'help'");
        csl.print(2, "Shows the list of commands you are currently seeing");
        csl.print(1, " - 'exit'");
        csl.print(2, "Exits the program without asking if you want to save");
        for (Method c : CommandHandler.class.getDeclaredMethods()) {
            csl.print(1, " - '%s'", c.getName());
            csl.print(2, "%s", c.getDeclaredAnnotation(Description.class).value());
        }
    }

    @Description("Saves hotel data to selected csv file")
    public static void save(ConsoleWrapper csl, Hotel hotel) {
        csl.print("inside save");
    }

    @Description("Loads hotel data from selected csv file")
    public static void load(ConsoleWrapper csl, Hotel hotel) {
        csl.print("inside load");
    }

    @Description("Shows hotel room prices")
    public static void prices(ConsoleWrapper csl, Hotel hotel) {
        csl.print("inside prices");
    }

    @Description("Shows description for selected room")
    public static void view(ConsoleWrapper csl, Hotel hotel) {
        csl.print("inside view");
    }

    @Description("Checks in one or multiple guests")
    public static void checkin(ConsoleWrapper csl, Hotel hotel) {
        csl.print("inside checkin");
    }

    @Description("Checks out a guest")
    public static void checkout(ConsoleWrapper csl, Hotel hotel) {
        csl.print("inside checkout");
    }

    @Description("Returns the information about rooms")
    public static void list(ConsoleWrapper csl, Hotel hotel) {
        if (hotel.getRooms() == null) {
            csl.print(1, "Hotel has no rooms");
            return;
        }
        for (Room room : hotel.getRooms()) {
            csl.print(1, "Room %s", room.getRoomName());
            csl.print(2, "Price: %f", room.getRoomPrice());
            csl.print(2, "%s", room.getRoomDescription());
            if (!room.getGuests().isEmpty()) {
                csl.print(2, "Check in date:  %s", room.getCheckInDate());
                csl.print(2, "Check out date: %s", room.getCheckOutDate());
            }
            for (Guest guest : room.getGuests()) {
                csl.print(2, "%s", guest.toString());
            }
        }
    }
    @Description("Creates a new hotel, either room-by-room, or automatically")
    public static void create(ConsoleWrapper csl, Hotel hotel) {
        csl.print(1, "Choose creation options:");
        csl.print(2, "B - Basic creator (floors, rooms per floor, hotel name)");
        csl.print(2, "A - Advanced creator (create hotel room by room)");
        csl.print(2, "Submit anything else to cancel");
        String x = csl.getString(0, ">>> ").toLowerCase();
        if (x.equals("b")) {
            hotel.hotelName = csl.getString(1, "Hotel name (currently: %s): ", hotel.hotelName);
            int numberOfFloors = csl.getInt(1, "Number of floors: ");
            int roomsPerFloor = csl.getInt(1, "Number of rooms per floor: ");
            hotel.setRooms(numberOfFloors, roomsPerFloor);
        } else if (x.equals("a")) {
            hotel.hotelName = csl.getString(1, "Hotel name (currently: %s): ", hotel.hotelName);
            boolean  hasEnded = false;
            while (!hasEnded) {
                int floor = csl.getInt(1, "Room floor: ");
                String roomName = "";
                boolean isRoomNumberValid = false;
                while (!isRoomNumberValid) {
                    roomName = csl.getString(1, "Room number (with the floor at the beginning): ").trim();
                    isRoomNumberValid = Room.isValidRoomName(floor, roomName);
                    if (!isRoomNumberValid) {
                        csl.print(1, "This room number does not belong to this floor, please try again.");
                    }
                }
                int capacity = csl.getInt(1, "Room capacity: ");
                double price = csl.getDouble(1, "Room price: ");
                String description = csl.getString(1, "Room description: ").trim();
                int roomNumber = Integer.parseInt(roomName.replaceFirst(String.valueOf(floor), ""));
                hotel.addRoom(new Room(roomName, description, price, floor, roomNumber, capacity));

                boolean isNotValid = true;
                while (isNotValid) {
                    isNotValid = false;
                    String y = csl.getString(1, "Do you want to add more rooms? (Y/n): ").toLowerCase();
                    if (y.equals("n")) {
                        hasEnded = true;
                    } else if (!y.equals("y")) {
                        isNotValid = true;
                    }
                }
            }
        }
    }
}
