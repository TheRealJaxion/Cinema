/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fis.poo.cinemalayout.controller;

import fis.poo.cinemalayout.model.entities.Client;
import fis.poo.cinemalayout.model.entities.Function;
import fis.poo.cinemalayout.model.entities.Movie;
import fis.poo.cinemalayout.model.entities.Reservation;
import fis.poo.cinemalayout.model.services.CinemaManager;
import fis.poo.cinemalayout.model.entities.Recipe;
import fis.poo.cinemalayout.view.Loginoptions;
import fis.poo.cinemalayout.view.MainLayout;
import fis.poo.cinemalayout.view.SeatsSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author jordy
 */
public class MLController implements ActionListener{
    
    private MainLayout ml;
    private Loginoptions logn; 
    private boolean isLoged = false; 
    private Recipe rcp; 
    private Reservation rs;
    private ArrayList<Function> fns = new ArrayList<>();
    private Movie mv;
    private Client cln; 
    private Function fn; 
    private ArrayList<Movie> movies = new ArrayList<>();
    private CinemaManager cnm = new CinemaManager();
    private SSController ssc;
    //private SeatManager smn;

    public void setIsLoged(boolean isLoged) {
        this.isLoged = isLoged;
    }
    
    
    public MLController(MainLayout ml, Loginoptions logn, ArrayList<Movie> movies) {
        this.ml = ml;
        this.logn = logn;
        this.movies = movies; 
        if(!cnm.movies(null).isEmpty() && cnm.movies(null).size() == 4){
            this.ml.movieT1.setText(movies.get(0).getNameM());
            this.ml.movieT2.setText(movies.get(1).getNameM());
            this.ml.movieT3.setText(movies.get(2).getNameM());
            this.ml.movieT4.setText(movies.get(3).getNameM());
            File im1 = new File("C:\\Users\\jordy\\Documents\\NetBeansProjects\\CinemaLayout\\src\\main\\resources\\mainl\\img1.png");
            File im2 = new File("C:\\Users\\jordy\\Documents\\NetBeansProjects\\CinemaLayout\\src\\main\\resources\\mainl\\img2.png");
            File im3 = new File("C:\\Users\\jordy\\Documents\\NetBeansProjects\\CinemaLayout\\src\\main\\resources\\mainl\\img3.png");
            File im4 = new File("C:\\Users\\jordy\\Documents\\NetBeansProjects\\CinemaLayout\\src\\main\\resources\\mainl\\img4.png");
            
            ImageIcon ic1 = new ImageIcon(im1.getAbsolutePath());
            ImageIcon ic2 = new ImageIcon(im2.getAbsolutePath());
            ImageIcon ic3 = new ImageIcon(im3.getAbsolutePath());
            ImageIcon ic4 = new ImageIcon(im4.getAbsolutePath());
            
            this.ml.movie1B.setIcon(ic1);
            this.ml.movie2B.setIcon(ic2);
            this.ml.movie3B.setIcon(ic3);
            this.ml.movie4B.setIcon(ic4);
            
            ml.setVisible(true);
            ml.setLocationRelativeTo(null);
        } else{
            JOptionPane.showMessageDialog(ml, "Movies are not loaded yet, you'll be redirected to login panel.", "Policinema", JOptionPane.ERROR_MESSAGE);
            logn.setVisible(true);
            logn.setLocationRelativeTo(null);
        }
        this.ml.signB.addActionListener(this); 
        this.ml.movie1B.addActionListener(this);
        this.ml.movie2B.addActionListener(this);
        this.ml.movie3B.addActionListener(this);
        this.ml.movie4B.addActionListener(this);
        this.ml.gbbM.addActionListener(this);
    }

    public void setCln(Client cln) {
        this.cln = cln;
    }
    
    @Override
    public void actionPerformed(ActionEvent ev) {
        
        movies = cnm.movies(null);
                
        if(ml.isActive()){
            
            if(ev.getSource() == ml.movie1B){
                if(!movies.isEmpty()){
                    String path = "C:\\Users\\jordy\\Documents\\NetBeansProjects\\CinemaLayout\\src\\main\\resources\\funcl\\img1.png";
                    mv = movies.get(0); 
                    ImageIcon img = new ImageIcon(path);
                    ml.movieTitle.setText(mv.getNameM());
                    ml.movieImg.setIcon(img);
                    ml.durationT.setText(Integer.toString(mv.getDuration())+ml.durationT.getText());
                    ml.restrictionT.setText(mv.getRestriction());
                    ml.movieDescription.setText(cnm.descriptions(ml, mv.getNameM()));
                    
                    fns = cnm.functions(ml, mv.getNameM());
                    
                    for(Function fn : fns){
                        ml.functionsS.addItem(fn.getFunctionId());
                    }
                    
                    ml.setVisible(false);
                    ml.MovieDisp.setVisible(true);
                    ml.MovieDisp.setLocationRelativeTo(null);
                }else{
                    JOptionPane.showMessageDialog(ml, "Functions are not loaded yet!", "Alert!", JOptionPane.ERROR_MESSAGE);
                }    
            } else if(ev.getSource() == ml.movie2B){
                if(!movies.isEmpty()){
                    String path = "C:\\Users\\jordy\\Documents\\NetBeansProjects\\CinemaLayout\\src\\main\\resources\\funcl\\img2.png";
                    mv = movies.get(1); 
                    ImageIcon img = new ImageIcon(path);
                    ml.movieTitle.setText(mv.getNameM());
                    ml.movieImg.setIcon(img);
                    ml.durationT.setText(Integer.toString(mv.getDuration())+ml.durationT.getText());
                    ml.restrictionT.setText(mv.getRestriction());
                    ml.movieDescription.setText(cnm.descriptions(ml, mv.getNameM()));
                    
                    fns = cnm.functions(ml, mv.getNameM());
                    
                    for(Function fn : fns){
                        ml.functionsS.addItem(fn.getFunctionId());
                    }
                    
                    ml.setVisible(false);
                    ml.MovieDisp.setVisible(true);   
                    ml.MovieDisp.setLocationRelativeTo(null);
                }else{
                    JOptionPane.showMessageDialog(ml, "Functions are not loaded yet!", "Alert!", JOptionPane.ERROR_MESSAGE);
                }  
            } else if(ev.getSource() == ml.movie3B){
                if(!movies.isEmpty()){
                    String path = "C:\\Users\\jordy\\Documents\\NetBeansProjects\\CinemaLayout\\src\\main\\resources\\funcl\\img3.png";
                    mv = movies.get(2); 
                    ImageIcon img = new ImageIcon(path);
                    ml.movieTitle.setText(mv.getNameM());
                    ml.movieImg.setIcon(img);
                    ml.durationT.setText(Integer.toString(mv.getDuration())+ml.durationT.getText());
                    ml.restrictionT.setText(mv.getRestriction());
                    ml.movieDescription.setText(cnm.descriptions(ml, mv.getNameM()));

                    fns = cnm.functions(ml, mv.getNameM());
                    
                    for(Function fn : fns){
                        ml.functionsS.addItem(fn.getFunctionId());
                    }
                    
                    ml.setVisible(false);
                    ml.MovieDisp.setVisible(true);
                    ml.MovieDisp.setLocationRelativeTo(null);
                }else{
                    JOptionPane.showMessageDialog(ml, "Functions are not loaded yet!", "Alert!", JOptionPane.ERROR_MESSAGE);
                } 
            } else if(ev.getSource() == ml.movie4B){
                if(!movies.isEmpty()){
                    String path = "C:\\Users\\jordy\\Documents\\NetBeansProjects\\CinemaLayout\\src\\main\\resources\\funcl\\img4.png";
                    mv = movies.get(3); 
                    ImageIcon img = new ImageIcon(path);
                    ml.movieTitle.setText(mv.getNameM());
                    ml.movieImg.setIcon(img);
                    ml.durationT.setText(Integer.toString(mv.getDuration())+ml.durationT.getText());
                    ml.restrictionT.setText(mv.getRestriction());
                    ml.movieDescription.setText(cnm.descriptions(ml, mv.getNameM()));

                    fns = cnm.functions(ml, mv.getNameM());
                    
                    for(Function fn : fns){
                        ml.functionsS.addItem(fn.getFunctionId());
                    }

                    ml.setVisible(false);
                    ml.MovieDisp.setVisible(true);
                    ml.MovieDisp.setLocationRelativeTo(null);                    
                }else{
                    JOptionPane.showMessageDialog(ml, "Functions are not loaded yet!", "Alert!", JOptionPane.ERROR_MESSAGE);
                } 
            } else if(ev.getSource() == ml.signB){
                ml.setVisible(false);
                logn.setVisible(true);
                logn.setLocationRelativeTo(null);
            }
        }
        
        if(ml.MovieDisp.isActive()){
            if(ev.getSource() == ml.gbbM){
                ml.durationT.setText("");
                ml.durationT.setText("min");
                ml.functionsS.removeAllItems();
                ml.MovieDisp.setVisible(false);
                ml.setVisible(true);
                ml.setLocationRelativeTo(null);
            } else if(ev.getSource() == ml.seatSelB){
                
                if(isLoged){
                    rcp.setClientName(cln.getNamesP());
                    rcp.setClientId(Integer.toString(cln.getId()));
                    
                    Movie mMov = null;
                    Function mFn = null;
                    for(Movie mov : cnm.movies(ml.MovieDisp)){
                        if(mov.getNameM().equals(ml.movieTitle)){
                            mMov = mov;
                            for(Function fun : cnm.functions(ml.MovieDisp, mMov.getNameM())){
                                if(fun.equals(ml.functionsS.getSelectedItem())){
                                    mFn = fun;
                                    break;
                                }
                            }
                            break;
                        }
                    }
                    
                    rs.setFunction(mFn);
                    ssc = new SSController(ml, mMov, mFn);
                    ml.MovieDisp.setVisible(false);
                    
                } else{
                    JOptionPane.showMessageDialog(null, "You must have been logged in first.", "Policinema", JOptionPane.OK_OPTION);
                }
            }
        }
        
        if(ml.FinalSel.isActive()){
            rcp.setRes(rs);
            ml.displayFS.setText(rcp.displayRecipe());
        }
    }  
}
