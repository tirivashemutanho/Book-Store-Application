package accounts;

import java.util.UUID;

public class User {
    private String userId;
    private String firstName;
    private String lastName;
    private String address;
    private String phone;

    public User(String firstName, String lastName, String address, String phone) {
        this.userId = UUID.randomUUID().toString();
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phone = phone;
    }

    public String getUserId() {
        return userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }
}
