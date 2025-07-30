/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fis.poo.cinemalayout.controller;

import fis.poo.cinemalayout.model.entities.Function;
import fis.poo.cinemalayout.model.entities.Movie;
import fis.poo.cinemalayout.model.entities.Reservation;
import fis.poo.cinemalayout.model.services.CinemaManager;
import fis.poo.cinemalayout.view.Loginoptions;
import fis.poo.cinemalayout.view.MainLayout;
import fis.poo.cinemalayout.view.SeatsSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 *
 * @author jordy
 */
public class MLController implements ActionListener{
    
    private MainLayout ml;
    private Loginoptions logn; 
    private ArrayList<Function> functions; 
    private Reservation rs;
    private Movie mv;
    private Function fn; 
    private ArrayList<Movie> movies;
    private CinemaManager cnm;
    private SeatsSelection st; 
    private SMainController smc;
    
    public MLController(MainLayout ml, SeatsSelection st) {
        this.ml = ml;
        
    }    

    public MLController(MainLayout ml, Loginoptions logn, CinemaManager cnm, SeatsSelection st, SMainController smc) {
        this.ml = ml;
        this.logn = logn;
        this.cnm = cnm;
        this.st = st;
        this.smc = smc;
        this.ml.movieT1.setText(functions.get(0).getMovieD().getNameM());
        this.ml.movieT2.setText(functions.get(1).getMovieD().getNameM());
        this.ml.movieT3.setText(functions.get(2).getMovieD().getNameM());
        this.ml.movieT4.setText(functions.get(3).getMovieD().getNameM());
        this.ml.movie1B.setIcon((Icon) new File("CinemaLayout\\src\\main\\resources\\mainl\\img1.png"));
        this.ml.movie2B.setIcon((Icon) new File("CinemaLayout\\src\\main\\resources\\mainl\\img2.png"));
        this.ml.movie3B.setIcon((Icon) new File("CinemaLayout\\src\\main\\resources\\mainl\\img3.png"));
        this.ml.movie4B.setIcon((Icon) new File("CinemaLayout\\src\\main\\resources\\mainl\\img4.png"));
        this.ml.signB.addActionListener(this); 
        this.ml.movie1B.addActionListener(this);
        this.ml.movie2B.addActionListener(this);
        this.ml.movie3B.addActionListener(this);
        this.ml.movie4B.addActionListener(this);
        this.ml.gbbM.addActionListener(this);
    }
    
    
    
    @Override
    public void actionPerformed(ActionEvent ev) {
        
        movies = cnm.movies();
        functions = cnm.functions();
        
        if(ml.isAct(ml)){
            
            if(ev.getSource() == ml.movie1B){
                String path = "CinemaLayout\\src\\main\\resources\\funcl\\img1.png";
                mv = movies.get(0); 
                ImageIcon img = new ImageIcon(path);
                ml.movieTitle.setText(mv.getNameM());
                ml.movieImg.setIcon(img);
                ml.movieFeatures.setText(mv.getRestriction()+"\n"+mv.getDuration());
                ml.movieDescription.setText(ml.descriptions.get(0));
                
                fn = functions.get(0);
                ml.selF(fn);
                
                for(int i=0; i<cnm.functions().size(); i++){
                    if(ml.movieTitle.getText().equals(fn.getMovieName())){
                        ml.functionsS.insertItemAt(fn.getSchedule()+" "+ fn.getHall()+" "+ fn.getnHall(), i);
                    }
                }
                ml.setVisible(false);
                ml.MovieDisp.setVisible(true);
                    
            } else if(ev.getSource() == ml.movie2B){
                String path = "CinemaLayout\\src\\main\\resources\\funcl\\img2.png";
                mv = movies.get(1); 
                ImageIcon img = new ImageIcon(path);
                ml.movieTitle.setText(mv.getNameM());
                ml.movieImg.setIcon(img);
                ml.movieFeatures.setText(mv.getRestriction()+"\n"+mv.getDuration());
                ml.movieDescription.setText(ml.descriptions.get(1));
                
                fn = functions.get(1);
                ml.selF(fn);
                
                for(int i=0; i<cnm.functions().size(); i++){
                    if(ml.movieTitle.getText().equals(fn.getMovieName())){
                        ml.functionsS.insertItemAt(fn.getSchedule()+" "+ fn.getHall()+" "+ fn.getnHall(), i);
                    }
                }
                ml.setVisible(false);
                ml.MovieDisp.setVisible(true);   
                
            } else if(ev.getSource() == ml.movie3B){
                String path = "CinemaLayout\\src\\main\\resources\\funcl\\img3.png";
                mv = movies.get(2); 
                ImageIcon img = new ImageIcon(path);
                ml.movieTitle.setText(mv.getNameM());
                ml.movieImg.setIcon(img);
                ml.movieFeatures.setText(mv.getRestriction()+"\n"+mv.getDuration());
                ml.movieDescription.setText(ml.descriptions.get(2));
                
                fn = functions.get(2);
                ml.selF(fn);
                
                for(int i=0; i<cnm.functions().size(); i++){
                    if(ml.movieTitle.getText().equals(fn.getMovieName())){
                        ml.functionsS.insertItemAt(fn.getSchedule()+" "+ fn.getHall()+" "+ fn.getnHall(), i);
                    }
                }
                ml.setVisible(false);
                ml.MovieDisp.setVisible(true); 
                
            } else if(ev.getSource() == ml.movie4B){
                String path = "CinemaLayout\\src\\main\\resources\\funcl\\img4.png";
                mv = movies.get(3); 
                ImageIcon img = new ImageIcon(path);
                ml.movieTitle.setText(mv.getNameM());
                ml.movieImg.setIcon(img);
                ml.movieFeatures.setText(mv.getRestriction()+"\n"+mv.getDuration());
                ml.movieDescription.setText(ml.descriptions.get(3));
                
                fn = functions.get(3);
                ml.selF(fn);
                
                for(int i=0; i<cnm.functions().size(); i++){
                    if(ml.movieTitle.getText().equals(fn.getMovieName())){
                        ml.functionsS.insertItemAt(fn.getSchedule()+" "+ fn.getHall()+" "+ fn.getnHall(), i);
                    }
                }
                
                ml.setVisible(false);
                ml.MovieDisp.setVisible(true);
            }
        }
        
        if(ml.MovieDisp.isActive()){
            if(ev.getSource() == ml.gbbM){
                ml.MovieDisp.setVisible(false);
                ml.setVisible(true);
            } else if(ev.getSource() == ml.seatSelB){
                rs.setFunction(fn);
                st.setVisible(true);
                ml.MovieDisp.setVisible(false);
            }
        }
    }  
}
