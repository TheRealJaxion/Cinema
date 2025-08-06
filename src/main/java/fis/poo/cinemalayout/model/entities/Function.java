/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fis.poo.cinemalayout.model.entities;

import fis.poo.cinemalayout.model.services.CinemaManager;
import java.util.ArrayList;

/**
 *
 * @author jordy
 */
public class Function {
    private CinemaManager cnm = new CinemaManager();
    private Movie movie;
    private String nameF;
    private char hall;
    private int nhall;
    private String schedule;

    public Function(Movie movie, String schedule, char hall, int nhall) {
        this.movie = movie;
        this.hall = hall;
        this.nhall = nhall;
        this.schedule = schedule;
        this.nameF = movie.getNameM();
    }

    public Function(char hall, int nhall, String schedule) {
        this.schedule = schedule;
        this.hall = hall;
        this.nhall = nhall;
    }
    
    public String mName(){
        return movie.getNameM();
    }
    
    public String getFunctionId(){
        return schedule+" : "+hall +" "+nhall; 
    }

    public char getHall() {
        return hall;
    }

    public void setNameF(String nameF) {
        this.nameF = nameF;
    }

    public int getNhall() {
        return nhall;
    }

    public String getSchedule() {
        return schedule;
    }
    
    
    
    public String toCSV(){
        return hall+","+nhall+","+schedule+"\n";
    }
}
