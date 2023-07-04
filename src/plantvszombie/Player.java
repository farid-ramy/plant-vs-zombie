/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package plantvszombie;

import java.io.Serializable;
import java.time.LocalDate;


/**
 *
 * @author DELL
 */
public class Player implements Serializable{
    private String firstName ;
    private String middleName ;
    private String lastName ;
    private LocalDate date ;
    private boolean gender;
    private String email ;
    private String userName ;
    private String password ;
    private int LevelsUnlocked;

    public Player(String firstName, String middleName, String lastName, LocalDate date, boolean gender, String email, String userName, String password) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.date = date;
        this.gender = gender;
        this.email = email;
        this.userName = userName;
        this.password = password;
        LevelsUnlocked =1;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getLevelsUnlocked() {
        return LevelsUnlocked;
    }

    public void setLevelsUnlocked(int LevelsUnlocked) {
        this.LevelsUnlocked = LevelsUnlocked;
    }

    @Override
    public String toString() {
        return "Player{" + "firstName=" + firstName + ", middleName=" + middleName + ", lastName=" + lastName + ", date=" + date + ", gender=" + gender + ", email=" + email + ", userName=" + userName + ", password=" + password + ", LevelsUnlocked=" + LevelsUnlocked + '}';
    }

}
