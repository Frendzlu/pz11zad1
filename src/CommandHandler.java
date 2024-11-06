import jdk.jfr.Description;

import java.io.Console;

public class CommandHandler {
    @Description("Saves hotel data to selected csv file")
    public static void save(Console csl, Hotel hotel) {
        csl.printf("inside save\n");
    }
    @Description("Loads hotel data from selected csv file")
    public static void load(Console csl, Hotel hotel) {

        csl.printf("inside load\n");
    }
    @Description("Shows hotel room prices")
    public static void prices(Console csl, Hotel hotel) {
        csl.printf("inside prices\n");
    }
    @Description("Shows description for selected room")
    public static void view(Console csl, Hotel hotel) {
        csl.printf("inside view\n");
    }
    @Description("Checks in one or multiple guests")
    public static void checkin(Console csl, Hotel hotel) {
        csl.printf("inside checkin\n");
    }
    @Description("Checks out a guest")
    public static void checkout(Console csl, Hotel hotel) {
        csl.printf("inside checkout\n");
    }
    @Description("Returns the information about rooms")
    public static void list(Console csl, Hotel hotel) {
        for (Room room : hotel.getRooms()) {
            csl.printf("\tRoom %s\n", room.getRoomName());
            csl.printf("\t\tPrice: %f\n", room.getRoomPrice());
            csl.printf("\t\t%s\n", room.getRoomDescription());
            if (!room.getGuests().isEmpty()) {
                csl.printf("\t\tCheck in date:  %s\n", room.getCheckInDate());
                csl.printf("\t\tCheck out date: %s\n", room.getCheckOutDate());
            }
            for (Guest guest : room.getGuests()) {
                csl.printf("\t\t%s\n", guest.toString());
            }
        }
    }
    @Description("Creates a new hotel, either room-by-room, or automatically")
    public static void create(Console csl, Hotel hotel) {
        csl.printf("\tChoose creation options:\n");
        csl.printf("\t\tB - Basic creator (floors, rooms per floor, hotel name)\n");
        csl.printf("\t\tA - Advanced creator (create hotel room by room)\n");
        csl.printf("\t\tSubmit anything else to cancel\n");
        String x = csl.readLine().toLowerCase();
        if (x.equals("b")) {
            String hotelName;
            int numberOfFloors = 0;
            int roomsPerFloor = 0;
            csl.printf("\tNumber of floors: ");

        } else if (x.equals("a")) {

        }
    }
}
