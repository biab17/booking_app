package User;

import Exceptions.AuthenticationError;

public class User
{
    private String email;
    private String password;
    private String fullName;
    private String phoneNumber;

    public User(String email, String password, String fullName, String phoneNumber) {
        this.email = email;
        this.password = password;
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFull_name() {
        return fullName;
    }

    public void setFull_name(String fullName) {
        this.fullName = fullName;
    }

    public String getPhone_number() {
        return phoneNumber;
    }

    public void setPhone_number(String phone_number) {
        this.phoneNumber = phone_number;
    }

    public boolean register() {
        System.out.println("Registering user: " + this.email);
        //linking to the database needed here
        return true;
    }

    public boolean login(String email, String password) throws AuthenticationError {
        System.out.println("Attempting login for: " + email);
        if (this.email.equals(email) && this.password.equals(password)) {
            System.out.println("Login successful!");
            return true;
        }
        else {
            throw new AuthenticationError("Invalid email or password!");
        }
    }
}
