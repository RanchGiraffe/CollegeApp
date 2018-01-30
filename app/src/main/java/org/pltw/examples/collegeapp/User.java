package org.pltw.examples.collegeapp;

public class User
{

    String username;
    String password;
    Profile profile = new Profile();
    Guardian guardian1 = new Guardian();
    Guardian guardian2 = new Guardian();

    public User(String username, String password, Profile profile, Guardian guardian1, Guardian guardian2){
        this.username = username;
        this.password = password;
        this.profile = profile;
        this.guardian1 = guardian1;
        this.guardian2 = guardian2;

    }

    public Guardian getGuardian1() {
        return guardian1;
    }

    public Guardian getGuardian2() {
        return guardian2;
    }

    public String getPassword() {
        return password;
    }

    public Profile getProfile() {
        return profile;
    }

    public String getUsername() {
        return username;
    }

    public void setGuardian1(Guardian guardian1) {
        this.guardian1 = guardian1;
    }

    public void setGuardian2(Guardian guardian2) {
        this.guardian2 = guardian2;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
