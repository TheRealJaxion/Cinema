/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fis.poo.cinemalayout.model.entities;

/**
 *
 * @author jordy
 */
public class Function {
    private Movie movieD; 
    private String movieName;
    private int movieDuration;
    private String restriction;
    private String functionId;
    private String schedule; 
    private char hall;
    private int nHall;

    public Function(Movie movieD, String schedule, char hall, int nHall) {
        this.movieD = movieD;
        this.movieName = movieD.getNameM();
        this.movieDuration = movieD.getDuration();
        this.restriction = movieD.getRestriction(); 
        this.schedule = schedule;
        this.hall = hall;
        this.nHall = nHall;
        this.functionId = movieName + schedule + hall;
    }

    public Function(String movieName, int movieDuration, String schedule, char hall, int nHall) {
        this.movieName = movieName;
        this.movieDuration = movieDuration;
        this.schedule = schedule;
        this.hall = hall;
        this.nHall = nHall; 
        this.restriction = restriction;
    }

    public String getFunctionId() {
        return functionId;
    }
    
    public Movie getMovieD() {
        return movieD;
    }
    
    public String getDescription(){
        return movieD.getDescription();
    }
    
    public String getSchedule() {
        return schedule;
    }

    public char getHall() {
        return hall;
    }

    public void setMovieD(Movie movieD) {
        this.movieD = movieD;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    public void setHall(char hall) {
        this.hall = hall;
    }
    public void setNHall(int nHall){
        this.nHall = nHall; 
    }

    public String getMovieName() {
        return movieName;
    }

    public int getMovieDuration() {
        return movieDuration;
    }

    public String getRestriction() {
        return restriction;
    }

    public int getnHall() {
        return nHall;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public void setMovieDuration(int movieDuration) {
        this.movieDuration = movieDuration;
    }

    public void setRestriction(String restriction) {
        this.restriction = restriction;
    }

    public void setnHall(int nHall) {
        this.nHall = nHall;
    }
    
    
    
    public String toCSV() {
        return functionId+","+movieName+","+Integer.toString(movieDuration)+","+schedule+","+hall+","+Integer.toString(nHall)+","+restriction;
    }    
    
}
