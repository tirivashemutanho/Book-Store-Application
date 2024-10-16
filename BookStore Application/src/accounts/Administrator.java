package accounts;

public class Administrator extends User {
    private String username;
    private String role;
    private String password;

    public Administrator(String firstName, String lastName, String address, String phone, String username, String role, String password) {
        super(firstName, lastName, address, phone);
        this.username = username;
        this.role = role;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getRole() {
        return role;
    }

    public boolean login(String username, String password) {
        return this.username.equals(username) && this.password.equals(password);
    }
}
