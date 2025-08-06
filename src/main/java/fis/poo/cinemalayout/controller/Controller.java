/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fis.poo.cinemalayout.controller;

import fis.poo.cinemalayout.model.entities.Cashier;
import fis.poo.cinemalayout.model.entities.Client;
import fis.poo.cinemalayout.model.entities.Function;
import fis.poo.cinemalayout.model.entities.Movie;
import fis.poo.cinemalayout.model.entities.Recipe;
import fis.poo.cinemalayout.model.entities.Reservation;
import fis.poo.cinemalayout.model.services.CashierReserv;
import fis.poo.cinemalayout.model.services.CinemaManager;
import fis.poo.cinemalayout.model.services.ClientReserv;
import fis.poo.cinemalayout.model.services.ImageManager;
import fis.poo.cinemalayout.model.services.PersonManager;
import fis.poo.cinemalayout.model.services.PricePolicy;
import fis.poo.cinemalayout.model.services.Verificator;
import fis.poo.cinemalayout.view.AdminPanel;
import fis.poo.cinemalayout.view.CashierPanel;
import fis.poo.cinemalayout.view.HiddenView;
import fis.poo.cinemalayout.view.Loginoptions;
import fis.poo.cinemalayout.view.MainLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author jordy
 */
public class Controller implements ActionListener{   
    
    private AdminPanel adm = new AdminPanel();
    private HiddenView hdn = new HiddenView();
    private CashierPanel csh = new CashierPanel(); 
    private Loginoptions lgn = new Loginoptions();
    private MainLayout mnl = new MainLayout();
    private AJCBController jcb = new AJCBController(adm);
    //private SeatManager smn;
    private SSController ssc;
    private CJCBController cb;
    private Verificator vrf = new Verificator();
    private PersonManager pm = new PersonManager();
    private CinemaManager cn = new CinemaManager(); 
    private PricePolicy prp = new PricePolicy();
    private ImageManager img = new ImageManager(); 
    private Reservation rsr;
    private ArrayList<Function> functions = new ArrayList<>();
    private ArrayList<Cashier> cashiers = new ArrayList<>();
    private ArrayList<Client> clients = new ArrayList<>();
    private ArrayList<Movie> movies = new ArrayList<>();
    private Recipe rcp; 
    private ClientReserv clnr;
    private CashierReserv crs;
    private Client cln;
    private Cashier cshr;
    private String secret = "RR1717160533";
    private MLController ml;

    public Controller(Reservation rsr, Recipe rcp, Client cln, Cashier cshr) {
        this.rsr = rsr;
        this.rcp = rcp;
        this.cln = cln;
        this.cshr = cshr;
        this.cb = new CJCBController(csh);
        this.adm.model.addColumn("Name");
        this.adm.model.addColumn("Duration");
        this.adm.model.addColumn("Restriction");    
        for(JButton btn : csh.buttons()){
            btn.addActionListener(this);
        }
        for(JButton btns : adm.buttons()){
            btns.addActionListener(this);
        }
        for(JButton bt : hdn.buttons()){
            bt.addActionListener(this);
        }

        if(!cn.movies(null).isEmpty()){
            movies = cn.movies(null);
            for(int i=0; i<cn.movies(null).size(); i++){
                Movie movie = cn.movies(null).get(i);
                Object[] ob = {movie.getNameM(), movie.getDuration(), movie.getRestriction()};
                adm.model.addRow(ob);
            }
            ml = new MLController(mnl, lgn, movies);
            
        } else{
            ml = new MLController(mnl, lgn, movies);
            System.out.println("empty");
        }
        lgn.signB.addActionListener(this);
        lgn.lognB.addActionListener(this);
        lgn.cnclB.addActionListener(this);
        lgn.hiddenB.addActionListener(this);
        lgn.loginB.addActionListener(this);
        lgn.signin.addActionListener(this);
    }

    
    @Override
    public void actionPerformed(ActionEvent ev) {
        Object sr = ev.getSource();
        String[] schdl = {"11AM", "13PM", "15PM", "17PM", "19PM"};
        String[] hallN = {"1", "2", "3", "4", "5", "6"};
        if(adm.isActive()){
            if(sr == adm.showInfo){
                adm.info.setVisible(true);
                adm.setVisible(false);
                adm.info.setLocationRelativeTo(null);
            } else if(sr== adm.setMovies){
                adm.movieSet.setVisible(true);
                adm.setVisible(false);
                adm.movieSet.setLocationRelativeTo(null);
            } else if(sr == adm.nCashier){
                adm.newCashier.setVisible(true);
                adm.setVisible(false);
                adm.newCashier.setLocationRelativeTo(null);
            } else if(sr == adm.setPr){
                adm.promN1.setText(prp.getProm1());
                adm.promN2.setText(prp.getProm2());
                adm.promN3.setText(prp.getProm3());
                adm.promN4.setText(prp.getProm4());
                
                adm.pprom1.setText(Double.toString(prp.getPprom1()));
                adm.pprom2.setText(Double.toString(prp.getPprom2()));
                adm.pprom3.setText(Double.toString(prp.getPprom3()));
                adm.pprom4.setText(Double.toString(prp.getPprom4()));
                
                adm.priceSH.setText(Double.toString(prp.getSeatPriceH()));
                adm.priceSI.setText(Double.toString(prp.getSeatPriceI()));
                adm.taxT.setText(Double.toString(prp.getTaxPer()));
                
                adm.pricePanel.setVisible(true);
                adm.setVisible(false);
                adm.pricePanel.setLocationRelativeTo(null);
            } else if(ev.getSource() == adm.logout){
                adm.setVisible(false);
                hdn.setVisible(true);
                hdn.setLocationRelativeTo(null);
            }
        }
        
        if(hdn.isActive()){
            if(sr == hdn.hiddenAdm){
                String pass = JOptionPane.showInputDialog(hdn, "Type the secret code.");
                if(pass.equals("admntest3")){
                    JOptionPane.showMessageDialog(hdn, "Access Guaranted!", "Policinema", JOptionPane.OK_OPTION);
                    hdn.setVisible(false);
                    adm.setVisible(true);
                    adm.setLocationRelativeTo(null);
                } else{
                    JOptionPane.showMessageDialog(hdn, "Incorrect code!", "Alert!", JOptionPane.ERROR_MESSAGE);
                }
                
            } else if(sr == hdn.hiddenCash){
                hdn.loginCs.setVisible(true);
                hdn.setVisible(false);
                hdn.loginCs.setLocationRelativeTo(null);
            }
        }
        
        if(hdn.loginCs.isActive()){
            if(sr == hdn.lognC){
                String username = hdn.cshT.getText();
                String password = hdn.pwF.getText(); 
                if(vrf.verifier(hdn.loginCs, "cashier", username, password)){
                    cshr = pm.cashiers(hdn.loginCs).get(vrf.getPosCh());
                    hdn.setVisible(false);
                    hdn.loginCs.setVisible(false);
                    
                    csh.displayC.setText(cshr.getNamesP());
                    movies = cn.movies(hdn.loginCs);
                    
                    
                    for(Movie mv : movies){
                        csh.movieCB.addItem(mv.getNameM());
                    }

                    csh.setVisible(true);
                    csh.setLocationRelativeTo(null);
                    
                } else{
                    hdn.alertM(hdn.loginCs);
                    hdn.clear(hdn.cshT, hdn.pwF);
                }  
            }else if(sr == hdn.canclC){
                hdn.setVisible(true);
                hdn.loginCs.setVisible(false);
                hdn.setLocationRelativeTo(null);
            }
        }
        if(adm.newCashier.isActive()){
            if(sr == adm.backB){
                adm.setVisible(true);
                adm.newCashier.setVisible(false);
                adm.setLocationRelativeTo(null);
            } else if(sr == adm.regcashB){
                if(adm.isEmp(adm.ncs())){
                    adm.alertM(adm.ncs(), adm.newCashier);
                } else{
                    pm.registerCashier(adm.newCashier, adm.getTI(adm.nT), adm.getTI(adm.unT), adm.getTI(adm.lnT), adm.getTI(adm.pwT));
                    adm.refresh(adm.ncs());
                }
            }
        }
        
        if(adm.info.isActive()){
           if(sr == adm.gbB){
               adm.info.setVisible(false);
               adm.setVisible(true);
               adm.setLocationRelativeTo(null);
           }
        }
        
        if(adm.pricePanel.isActive()){
            if(sr == adm.svp1){
                if(adm.isEmpt(adm.pprom1T)){
                    adm.alertM(adm.pr(), adm.pricePanel);
                } else{
                    prp.setPprom1(Double.parseDouble(adm.getTI(adm.pprom1T)));
                }
            } else if(sr == adm.svp2){
                
                if(adm.isEmpt(adm.pprom2T)){
                    adm.alertM(adm.pr(), adm.pricePanel);
                } else{
                    prp.setPprom2(Double.parseDouble(adm.getTI(adm.pprom2T)));
                }
            } else if(sr == adm.svp3){
                
                if(adm.isEmpt(adm.pprom3T)){
                    adm.alertM(adm.pr(), adm.pricePanel);
                } else{
                    prp.setPprom3(Double.parseDouble(adm.getTI(adm.pprom3T)));
                }
            } else if(sr == adm.svp4){ 
                if(adm.isEmpt(adm.pprom4T)){
                    adm.alertM(adm.pr(), adm.pricePanel);
                } else{
                    prp.setPprom4(Double.parseDouble(adm.getTI(adm.pprom4T)));
                }
            } else if(sr == adm.svsH){
                if(adm.isEmpt(adm.priceH)){
                    adm.alertM(adm.pr(), adm.pricePanel);
                } else{
                    prp.setSeatPriceH(Double.parseDouble(adm.getTI(adm.priceH)));
                }
            } else if(sr == adm.svsI){
                if(adm.isEmpt(adm.priceI)){
                    adm.alertM(adm.pr(), adm.pricePanel);
                } else{
                    prp.setSeatPriceI(Double.parseDouble(adm.getTI(adm.priceI)));
                }
            } else if(sr == adm.svt){
                if(adm.isEmpt(adm.taxF)){
                    adm.alertM(adm.pr(), adm.pricePanel);
                } else{
                    prp.setSeatPriceI(Double.parseDouble(adm.getTI(adm.taxF)));
                }           
            }else if(sr == adm.saveAll){
                if(adm.isEmp(adm.pr())){
                    adm.alertM(adm.pr(), adm.pricePanel);
                } else{
                    prp.setPprom1(Double.parseDouble(adm.getTI(adm.pprom1T)));
                    prp.setPprom2(Double.parseDouble(adm.getTI(adm.pprom2T)));
                    prp.setPprom3(Double.parseDouble(adm.getTI(adm.pprom3T)));
                    prp.setPprom4(Double.parseDouble(adm.getTI(adm.pprom4T)));
                    prp.setSeatPriceI(Double.parseDouble(adm.getTI(adm.priceI)));
                    prp.setSeatPriceH(Double.parseDouble(adm.getTI(adm.priceH)));
                    prp.setTaxPer(Double.parseDouble(adm.getTI(adm.taxF)));
                    JOptionPane.showConfirmDialog(adm.pricePanel, "Prices has been set succesfully.", "Finished", JOptionPane.OK_OPTION);
                    adm.refresh(adm.pr());
                }    
            } else if(sr == adm.gbpB){
                adm.refresh(adm.pr());
                adm.pricePanel.setVisible(false);
                adm.setVisible(true);
                adm.setLocationRelativeTo(null);
            }   
        }
        
        if(adm.movieSet.isActive()){
            if(sr == adm.selimgM){
                JFileChooser fc = new JFileChooser(); 
                fc.setDialogTitle("Save Imgage As");
                
                FileNameExtensionFilter pngF = new FileNameExtensionFilter("PNG Files (*.png)", "png");
                fc.addChoosableFileFilter(pngF);
                fc.setFileFilter(pngF);
                
                int userSel = fc.showSaveDialog(adm.movieSet);
                if(userSel == JFileChooser.APPROVE_OPTION){
                    File imgSelPath = fc.getSelectedFile();
                    img.mainImg(adm.movieSet, imgSelPath);
                }
            }else if(sr == adm.selimgF){
                JFileChooser fc = new JFileChooser(); 
                fc.setDialogTitle("Save Imgage As");
                
                FileNameExtensionFilter pngF = new FileNameExtensionFilter("PNG Files (*.png)", "png");
                fc.addChoosableFileFilter(pngF);
                fc.setFileFilter(pngF);
                
                int userSel = fc.showSaveDialog(adm.movieSet);
                if(userSel == JFileChooser.APPROVE_OPTION){
                    File imgSelPath = fc.getSelectedFile();
                    img.functImg(adm.movieSet, imgSelPath);
                }
            }else if(sr == adm.saveM){
                if(adm.isEmp(adm.mvs())){
                    adm.alertM(adm.mvs(), adm.movieSet);
                } else{
                    cn.setMovies(adm.movieSet, adm.getTI(adm.mN), Integer.parseInt(adm.getTI(adm.mD)), (String) adm.ageR.getSelectedItem());
                    cn.setDesc(adm.movieSet, adm.mvdesc.getText(), adm.getTI(adm.mN));
                    adm.refresh(adm.mvs());
                }
            
            }else if(sr == adm.setF){
                if(!adm.isEmp(adm.mvs())){
                    cn.setMovies(adm.movieSet, adm.getTI(adm.mN), Integer.parseInt(adm.getTI(adm.mD)), (String) adm.ageR.getSelectedItem());
                    cn.setDesc(adm.movieSet, adm.mvdesc.getText(), adm.getTI(adm.mN));
                    adm.movieBx.addItem(adm.getTI(adm.mN));
                    adm.refresh(adm.mvs());
                    
                    for(String s : schdl){
                        adm.scheduleSel.addItem(s);
                    }
                    adm.hallSet.addItem("Normal Hall");
                    adm.hallSet.addItem("IMAX");
                    
                    
                    
                    adm.movieSet.setVisible(false);
                    adm.functionGenerator.setVisible(true);
                    adm.functionGenerator.setLocationRelativeTo(null);
                } else{
                    ArrayList<Movie> mvs = cn.movies(adm.movieSet);
                    for(Movie mv : mvs){
                    adm.movieBx.addItem(mv.getNameM());
                    }   
                    for(String s : schdl){
                        adm.scheduleSel.addItem(s);
                    }
                    adm.hallSet.addItem("Normal Hall");
                    adm.hallSet.addItem("IMAX");
                    
                    adm.functionGenerator.setVisible(true);
                    adm.movieSet.setVisible(false);
                    adm.functionGenerator.setLocationRelativeTo(null);
                }                
            } else if(sr == adm.gbM){
                adm.refresh(adm.mvs());
                adm.setVisible(true);
                adm.movieSet.setVisible(false);
                adm.setLocationRelativeTo(null);
            }
        }
        
        if(adm.functionGenerator.isActive()){
            if(sr == adm.gnrtF){
                Movie mvF = new Movie();
                for(Movie mvs : cn.movies(adm.functionGenerator)){
                    mvF = mvs;
                    if(mvF.getNameM().equals(adm.getItem(adm.movieBx))){
                        mvF = mvs;
                        break;
                    } else{
                        System.out.println(mvF.getNameM());
                        mvF = null;
                    }
                }
                if(mvF != null){
                    cn.setFunction(adm.functionGenerator, mvF, (String) adm.scheduleSel.getSelectedItem(), adm.selH(adm.hallSet), Integer.parseInt((String) adm.numH.getSelectedItem()));
                    adm.numH.removeItem(adm.numH.getSelectedItem());
                } else{
                    JOptionPane.showMessageDialog(adm.functionGenerator, "Movie not found!", "Alert!", JOptionPane.ERROR_MESSAGE);
                }
            } else if(sr == adm.cancelB){
                adm.movieBx.removeAllItems();
                adm.scheduleSel.removeAllItems();
                adm.hallSet.removeAllItems();
                adm.setVisible(true);
                adm.functionGenerator.setVisible(false);
                adm.setLocationRelativeTo(null);
            }   
        }
        
        if(csh.isActive()){
            if(sr == csh.seatSB){
                if(cn.movies(csh)!=null){
                    Movie cmov = new Movie();
                    for(Movie mv : cn.movies(csh)){
                        if(mv.getNameM().equals(csh.movieCB.getSelectedItem())){
                            cmov = mv;
                            System.out.println("setted!");
                            System.out.println(cmov.getNameM());
                            break;
                        }
                    }
                    
                    Function cfn = null;
                    functions = cn.functions(csh, cmov.getNameM());
                    
                    for(Function fns : functions){
                        System.out.println("Searching..");
                        if(fns.getFunctionId().equals(csh.functionCB.getSelectedItem())){
                            cfn = fns;
                            System.out.println("fnset");
                            break;
                        }
                    }

                    ssc = new SSController(csh, cmov, cfn);
                    
                } else{
                    JOptionPane.showMessageDialog(csh, "There's no movies availables!", "Error!", JOptionPane.ERROR_MESSAGE);
                }    
                
            } else if(sr == csh.addB){
                if(csh.isEmpty() || ssc.getCounter() == 0){
                    JOptionPane.showMessageDialog(csh, "Invalid Statements!", "Cashier Panel", JOptionPane.ERROR);
                    csh.clear();
                } else{
                    rcp.setClientId(csh.clientID.getText());
                    rcp.setClientName(csh.clientNames.getText());
                    crs.markSeats();
                    rcp.setRes(rsr);
                    csh.displayC.setText(rcp.displayRecipe());
                }
            }

            if(sr == csh.cancelB){
                csh.clear();
                ssc.clear();
                csh.displayC.setText("");
            }

            if(sr == csh.payB){

            }
        
            if(sr == csh.logOut){
                if(JOptionPane.showConfirmDialog(csh, "Are you sure to finish this shift?", "Cashier Panel", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
                    csh.clear();
                    hdn.setVisible(true);
                    csh.setVisible(false);
                    hdn.setLocationRelativeTo(null);
                }
            }
        }
        if(lgn.isActive()){
            if(sr==lgn.signB){
                lgn.setVisible(false);
                lgn.signinF.setVisible(true);
                lgn.signinF.setLocationRelativeTo(null);
            } else if(sr==lgn.lognB){
                lgn.maiIn.setVisible(true);
                lgn.maiIn.setLocationRelativeTo(null);
            } else if(sr==lgn.hiddenB){
                String pss = JOptionPane.showInputDialog(lgn, "Enter the secret Password:"); 
                if(pss.equals(secret)){
                    lgn.setVisible(false);
                    hdn.setVisible(true);
                    hdn.setLocationRelativeTo(null);                    
                } else{
                    JOptionPane.showMessageDialog(lgn, "INVALID PASSWORD!", "ALERT", JOptionPane.ERROR_MESSAGE);
                    lgn.setVisible(false);
                }
            }
        }
        
        if(lgn.signinF.isActive()){
            if(sr == lgn.cnclB){
                lgn.clear(lgn.fields()); 
                lgn.signinF.setVisible(false);
                lgn.setVisible(true);
            } else if(sr == lgn.signin){
                if(lgn.conditions()){
                    pm.registerClient(lgn.signinF, lgn.unTxt.getText(), lgn.nTxt.getText(), lgn.lnTxt.getText(), lgn.pwTxt.getText(), lgn.mTxt.getText(), Integer.parseInt(lgn.idTxt.getText()));
                    lgn.clear(lgn.fields());
                } else{
                    JOptionPane.showMessageDialog(lgn.signinF, "Incompatible data. Please, try again.", "Error", JOptionPane.ERROR_MESSAGE);
                    lgn.clear(lgn.fields());
                }
            }
        }
        
        if(lgn.maiIn.isActive()){
            if(sr == lgn.loginB){
                String uN = lgn.userIn.getText();
                String pW = lgn.psw.getText();
                if(vrf.verifier(lgn.maiIn, "client", uN, pW)){
                    JOptionPane.showMessageDialog(lgn.maiIn, "Welcome Back!", "Policinema", JOptionPane.OK_OPTION);
                    ml.setCln(pm.clients(lgn.maiIn).get(vrf.getPosition())); 
                    mnl.signB.hide();
                    ml.setIsLoged(true);
                    lgn.maiIn.setVisible(false);
                    lgn.setVisible(false);
                    mnl.setVisible(true);
                    mnl.setLocationRelativeTo(null);
                } else{
                    JOptionPane.showMessageDialog(lgn.maiIn, "User not found!", "Error", JOptionPane.ERROR_MESSAGE);
                    lgn.clear(lgn.fields());
                }
            }
        }
    }
}
