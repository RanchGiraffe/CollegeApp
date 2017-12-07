package org.pltw.examples.collegeapp;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class Profile {
    String firstName;
    String lastName;
    Calendar dob;

    public Calendar getDob() {
        return dob;
    }

    public void setDob(int year, int month, int day) {
        dob.set(year, month, day);
    }

    public Profile(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = Calendar.getInstance();
        dob.set(1999, 00, 01);
    }

    public Profile() {
        this.firstName = "Alan";
        this.lastName = "Turing";
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }




}
