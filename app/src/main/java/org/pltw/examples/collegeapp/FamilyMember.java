package org.pltw.examples.collegeapp;


public abstract class FamilyMember {
    String firstName;
    String lastName;

    public FamilyMember(String firstName, String lastName) {
        firstName = firstName;
        lastName = lastName;
    }

    public FamilyMember(){
        this.firstName = "Ada";
        this.lastName = "Lovelace";
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        lastName = lastName;
    }

    public void setFirstName(String firstName) {
        firstName = firstName;
    }
}
