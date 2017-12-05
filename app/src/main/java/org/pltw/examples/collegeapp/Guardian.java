package org.pltw.examples.collegeapp;

public class Guardian extends FamilyMember{

    private String occupation = "";

    public Guardian(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Guardian() {
        firstName = "Ham";
        lastName = "Burglar";
    }

}
