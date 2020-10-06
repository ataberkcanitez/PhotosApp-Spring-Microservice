package com.aaberkcanitez.photoapp.api.users.PhotoAppApiUsers.Ui.Model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class CreateUserRequestModel {

    @NotNull(message = "First name cannot be null")
    @Size(min = 2, message = "First name must not be less than two characters")
    private String firstName;
    @NotNull(message = "Last name cannot be null")
    @Size(min = 2, message = "Last name must not be less than two characters")
    private String lastName;
    @NotNull(message = "Password cannot be null")
    @Size(min = 8, max = 16, message = "Password must be equal or grater than 8 characters and less than 16 characters")
    private String password;
    @NotNull(message = "E-mail cannot be null")
    @Email
    private String email;

    public CreateUserRequestModel() {
    }

    public CreateUserRequestModel(String firstName, String lastName, String password, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
