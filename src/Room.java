import java.util.ArrayList;
import java.util.Date;

public class Room {
    private final String roomName;
    private String roomDescription;
    private double roomPrice;
    private final int floor;
    private final int roomNumber;
    private final ArrayList<Guest> guests;
    private Date checkInDate;
    private Date checkOutDate;

    public Date getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(Date checkInDate) {
        this.checkInDate = checkInDate;
    }

    public Date getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(Date checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public String getRoomName() {
        return roomName;
    }

    public String getRoomDescription() {
        return roomDescription;
    }

    public void setRoomDescription(String roomDescription) {
        this.roomDescription = roomDescription;
    }

    public double getRoomPrice() {
        return roomPrice;
    }

    public void setRoomPrice(double roomPrice) {
        this.roomPrice = roomPrice;
    }

    public Room(String roomName, String roomDescription, double roomPrice, int floor, int roomNumber, ArrayList<Guest> guests, Date checkInDate, Date checkOutDate) {
        this.roomName = roomName;
        this.roomDescription = roomDescription;
        this.roomPrice = roomPrice;
        this.floor = floor;
        this.roomNumber = roomNumber;
        this.guests = guests;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
    }

    public Room(String roomName, int roomNumber, int floor) {
        this.roomName = roomName;
        this.roomNumber = roomNumber;
        this.floor = floor;
        this.guests = new ArrayList<>();
        this.roomPrice = 0.0;
        this.roomDescription = "This room has no description";
    }

    public void removeGuests() {
        this.guests.clear();
    }

    public void addGuest(Guest guest) {
        this.guests.add(guest);
    }

    public ArrayList<Guest> getGuests() {
        return guests;
    }
}
