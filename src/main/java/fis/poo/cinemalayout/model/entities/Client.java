/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fis.poo.cinemalayout.model.entities;

/**
 *
 * @author jordy
 */
public class Client extends Person {

    private String email;
    private int id;

    public Client(String username, String namesP, String lastnamesP, String password, int id, String email) {
        super(username, namesP, lastnamesP, password);
        this.email = email;
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAge(int id) {
        this.id = id;
    }

    @Override
    public String toCSV() {
        return username + "," + namesP + "," + email + "," + Integer.toString(id) + "," + lastnamesP + "," + password;
    }

}
