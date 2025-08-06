/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fis.poo.cinemalayout.model.entities;

/**
 *
 * @author jordy
 */
public class Movie {
    private String nameM;
    private String description;
    private int duration;
    private String restriction; 

    public Movie(String nameM, String description, int duration, String restriction) {
        this.nameM = nameM;
        this.description = description;
        this.duration = duration;
        this.restriction = restriction;
    }

    public Movie(String nameM, int duration, String restriction) {
        this.nameM = nameM;
        this.duration = duration;
        this.restriction = restriction;
    }

    public Movie() {
    }
    
    public String getNameM() {
        return nameM;
    }

    public String getDescription() {
        return description;
    }

    public int getDuration() {
        return duration;
    }

    public String getRestriction() {
        return restriction;
    }

    public void setNameM(String nameM) {
        this.nameM = nameM;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void setRestriction(String restriction) {
        this.restriction = restriction;
    }
    
    public String toCSV(){
        return nameM +","+ Integer.toString(duration) +","+ restriction+"\n";
    }
}
