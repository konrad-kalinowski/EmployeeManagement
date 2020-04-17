package Model;

public class Department {

    private final String name;
    private final String location;
    private final int phoneNumber;

    public Department(String name, String location, int phoneNumber) {
        this.name = name;
        this.location = location;
        this.phoneNumber = phoneNumber;
    }

    public Department(String name, String location) {
        this(name, location, 0);
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public String getDepartmentDescription() {
        return name + " " + location + " " + phoneNumber;
    }
}
