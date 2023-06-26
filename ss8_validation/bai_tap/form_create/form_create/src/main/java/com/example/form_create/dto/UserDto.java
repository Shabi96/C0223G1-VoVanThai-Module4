package com.example.form_create.dto;

import javax.validation.constraints.*;

public class UserDto {

    @Size(min = 5, max = 45, message = "Name's size min is 5 character and max is 45 character!!")
    private String firstName;

    @Size(min = 5, max = 45, message = "Name's size min is 5 character and max is 45 character!!")
    private String lastName;

    @Pattern(regexp = "^(0)\\d{9}$", message = "Phone number format is correct!!! [0xxx-xxx-xxx]")
    private String phoneNumber;
    @NotNull(message = "Can't not empty!!!!")
    @Min( value = 18, message = "Age must be greater than 0!!!!")
    private Integer age;
    @Pattern(regexp = "^\\w+(@)\\w+(.)\\w+$", message = "Email format is correct!!! [xxx@xxx.xxx]")
    private String email;

    public UserDto() {
    }

    public UserDto( String firstName, String lastName, String phoneNumber, Integer age, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.age = age;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
