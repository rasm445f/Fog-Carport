package dat.startcode.model.entities;

import java.util.Objects;

public class User {
    private int user_id;
    private String email;
    private String password;
    private String role;
    private int balance;
    private String name;
    private String address;
    private String city;
    private int zipcode;
    private int phoneNumber;

    public User(int user_id,String email, String password, String role, int balance, String name, String address, String city, int zipcode, int phoneNumber) {
        this.user_id = user_id;
        this.email = email;
        this.password = password;
        this.role = role;
        this.balance = balance;
        this.name = name;
        this.address = address;
        this.city = city;
        this.zipcode = zipcode;
        this.phoneNumber = phoneNumber;
    }

    public User(String email, String password, String name, String address, String city, int zipcode, int phoneNumber) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.address = address;
        this.city = city;
        this.zipcode = zipcode;
        this.phoneNumber = phoneNumber;
    }

    public User(String email, String password, String role) {
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public int getUser_id() {
        return user_id;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }

    public int getBalance() {
        return balance;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public int getZipcode() {
        return zipcode;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return getEmail().equals(user.getEmail()) && getPassword().equals(user.getPassword()) &&
                getRole().equals(user.getRole());
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(getEmail(), getPassword(), getRole());
    }
}
