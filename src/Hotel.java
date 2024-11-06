import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Hotel {
    public String hotelName;
    private MyMap<String, Room> rooms = new MyMap<String, Room>();

    public Hotel(String name, Room[] loadedRooms) {
        this.hotelName = name;
        for (Room room : loadedRooms) {
            this.rooms.put(room.getRoomName(), room);
        }
    }

    public Hotel(String name, int floors, int roomsPerFloor) {
        hotelName = name;
        for (int i = 1; i <= floors; i++) {
            for (int j = 1; j <= roomsPerFloor; j++) {
                int padding = (int) (Math.log10(roomsPerFloor)+1);
                String roomName = i + String.format("%" + padding + "s", j).replace(' ', '0');
                rooms.put(roomName, new Room(roomName, j, i));
            }
        }
    }

    public Hotel() {
        hotelName = "new_hotel_" + new SimpleDateFormat("yyyy-MM-dd_HHmmss").format(new Date());
    }

    public void loadFromFile() {

    }

    public void saveToFile() {

    }

    public ArrayList<Room> getRooms() {
        return (ArrayList<Room>) this.rooms.values();
    }
}
