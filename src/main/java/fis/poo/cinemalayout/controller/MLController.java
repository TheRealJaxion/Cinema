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
    private ArrayList<Function> functions = new ArrayList<>(); 
    private Recipe rcp; 
    private Reservation rs;
    private Movie mv;
    private Client cln; 
    private Function fn; 
    private ArrayList<Movie> movies = new ArrayList<>();
    private CinemaManager cnm = new CinemaManager();
    private SeatsSelection st; 
    private SeatController smc;

    public void setIsLoged(boolean isLoged) {
        this.isLoged = isLoged;
    }
    
    
    public MLController(MainLayout ml, Loginoptions logn, SeatsSelection st, SeatController smc, ArrayList<Movie> movies) {
        this.ml = ml;
        this.logn = logn;
        this.st = st;
        this.movies = movies; 
        this.smc = smc;
        if(!cnm.movies().isEmpty()){
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
        
        movies = cnm.movies();
        functions = cnm.functions();
        
        if(ml.isActive()){
            
            if(ev.getSource() == ml.movie1B){
                String path = "CinemaLayout\\src\\main\\resources\\funcl\\img1.png";
                mv = movies.get(0); 
                ImageIcon img = new ImageIcon(path);
                ml.movieTitle.setText(mv.getNameM());
                ml.movieImg.setIcon(img);
                ml.movieFeatures.setText(mv.getRestriction()+"\n"+mv.getDuration());
                ml.movieDescription.setText(cnm.descriptions().get(0));
                
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
            } else if(ev.getSource() == ml.signB){
                ml.setVisible(false);
                logn.setVisible(true);
                logn.setLocationRelativeTo(null);
            }
        }
        
        if(ml.MovieDisp.isActive()){
            if(ev.getSource() == ml.gbbM){
                ml.MovieDisp.setVisible(false);
                ml.setVisible(true);
            } else if(ev.getSource() == ml.seatSelB){
                
                if(isLoged){
                    rcp.setClientName(cln.getNamesP());
                    rcp.setClientId(Integer.toString(cln.getId()));
                    rs.setFunction(fn);
                    st.setVisible(true);
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
