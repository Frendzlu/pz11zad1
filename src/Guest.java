public class Guest {
    String name = "";
    String surname = "";
    //add other fields if necessary

    public Guest(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    @Override
    public String toString() {
        return name + " " + surname;
    }
}
