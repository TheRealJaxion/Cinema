/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fis.poo.cinemalayout.model.services;

import fis.poo.cinemalayout.model.entities.Function;
import fis.poo.cinemalayout.model.entities.Movie;
import java.awt.Component;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author jordy
 */
public class CinemaManager {

    String fileNameM = "movieReg.txt";
    File fileM = new File(fileNameM);
    
    public void setMovies(Component fr, String nameM, int duration, String restriction){
        Movie movie = new Movie(nameM, duration, restriction);
        String content = movie.toCSV();
        
        try{
            if(fileM.exists()){
                fileM.createNewFile();   
            }
            FileWriter fw = new FileWriter(fileM.getAbsoluteFile(), true); 
            fw.write(content);
            fw.close(); 
            JOptionPane.showMessageDialog(fr, "Movie saved succesfully!", "Policinema", JOptionPane.DEFAULT_OPTION);
        }catch(IOException e){
            JOptionPane.showMessageDialog(fr,"There was an exception at FileWritter.(cn.fw.mv)", "WARNING!", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace(); 
        } 
    }
    
    public void setDesc(Component fr, String description, String movieName){
        char[] fileinit = movieName.toCharArray();
        String fileNameD = fileinit[3] + fileinit[4] +".txt";
        File fileD = new File(fileNameD);
        String content = description; 
        
        try{
            if(fileD.exists()){
                fileD.createNewFile();   
            }
            FileWriter fw = new FileWriter(fileD.getAbsoluteFile(), true); 
            fw.write(content);
            fw.write("\n");
            fw.close(); 
            JOptionPane.showMessageDialog(fr, "Movie saved succesfully!", "Policinema", JOptionPane.DEFAULT_OPTION);
        }catch(IOException e){
            JOptionPane.showMessageDialog(fr,"There was an exception at FileWritter.(cn.fw.mv)", "WARNING!", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace(); 
        } 
    }
    
    public void setFunction(Component fr, Movie movieD, String schedule, char hall, int nHall){
        char[] fileinit = movieD.getNameM().toCharArray();
        String fileNameF = fileinit[0]+fileinit[1]+".txt";
        System.out.println(fileNameF);
        File fileF = new File(fileNameF);
        Function func = new Function(movieD, schedule, hall, nHall);
        String content = func.toCSV(); 
        try{
            if(!fileF.exists()){
                fileF.createNewFile();   
            }
            FileWriter fw = new FileWriter(fileF.getAbsoluteFile(), true); 
            fw.write(content);
            fw.close(); 
            JOptionPane.showMessageDialog(fr, "Function saved succesfully!", "Policinema", JOptionPane.DEFAULT_OPTION);
        }catch(IOException e){
            JOptionPane.showMessageDialog(fr,"There was an exception at FileWritter.(cnm.fw.fc)", "WARNING!", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace(); 
        }         
    }
    
    public ArrayList<Movie> movies(Component fr){
        String line; 
        String csvSeparator = ","; 
        ArrayList<Movie> movies = new ArrayList<>();
        
        try(BufferedReader br = new BufferedReader(new FileReader(fileNameM))){
                        
            while((line = br.readLine()) != null){
                String[] data = line.split(csvSeparator);
                Movie movie = new Movie(data[0], Integer.parseInt(data[1]), data[2]);
                movies.add(movie); 
            }
            
        }catch(IOException e){
            JOptionPane.showMessageDialog(fr,"There was an exception at FileReader.(cnm.fr.mvA)", "WARNING!", JOptionPane.ERROR_MESSAGE);
            movies.clear(); 
        }
        
        return movies; 
    }
    
    public String descriptions(Component fr, String movieName){
        char[] fileinit = movieName.toCharArray();
        String fileNameD = fileinit[3] + fileinit[4] +".txt";
        String line;
        String description = ""; 
        try(BufferedReader br = new BufferedReader(new FileReader(fileNameD))){
                        
            while((line = br.readLine()) != null){
                description = line; 
            }
            
        }catch(IOException e){
            JOptionPane.showMessageDialog(fr,"There was an exception at FileReader.(cnm.fr.fcA)", "WARNING!", JOptionPane.ERROR_MESSAGE);
        }       
        return description;         
    }
    
    public ArrayList<Function> functions(Component fr, String movieName){
        char[] fileinit = movieName.toCharArray();
        String fileNameF = fileinit[0]+fileinit[1]+".txt";
        String line; 
        String csvSeparator = ","; 
        ArrayList<Function> functions = new ArrayList<>();
        
        try(BufferedReader br = new BufferedReader(new FileReader(fileNameF))){
            
            while((line = br.readLine()) != null){
                String[] data = line.split(csvSeparator);
                Function function = new Function(data[0].charAt(0), Integer.parseInt(data[1]), data[2]);
                functions.add(function); 
            }
            
        }catch(IOException e){
            JOptionPane.showMessageDialog(fr,"There was an exception at FileReader.(cnm.fr.fcA)", "WARNING!", JOptionPane.ERROR_MESSAGE);
            functions.clear(); 
        }       
        return functions;         
    }        
}
