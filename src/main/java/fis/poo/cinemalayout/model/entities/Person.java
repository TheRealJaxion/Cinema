/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fis.poo.cinemalayout.model.entities;

/**
 *
 * @author jordy
 */
public abstract class Person {
    protected String username;
    protected String namesP;
    protected String lastnamesP; 
    protected String password;

    public Person(String username, String namesP, String lastnamesP, String password) {
        this.username = username;
        this.namesP = namesP;
        this.lastnamesP = lastnamesP;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getNamesP() {
        return namesP;
    }

    public String getLastnamesP() {
        return lastnamesP;
    }

    public String getPassword() {
        return password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setNamesP(String namesP) {
        this.namesP = namesP;
    }

    public void setLastnamesP(String lastnamesP) {
        this.lastnamesP = lastnamesP;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public abstract String toCSV();
    
}
