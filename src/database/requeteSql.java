/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Fiche;

/**
 *
 * @author User
 */
public class requeteSql {

    public requeteSql() {
        connexionDB.getInstance();
//            pd=new propertiesData();

    }

  

    public ResultSet getListRecrutement() {
        ResultSet rs = null;

        try {
            Statement st;
            String sql = "SELECT * FROM `t_recrutement`";
            st = connexionDB.getInstance().createStatement();

            rs = st.executeQuery(sql);
            return rs;

        } catch (SQLException ex) {
            Logger.getLogger(connexionDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }
    
    
 public ResultSet getUser(String table, String id) {
        ResultSet rs = null;

        try {
            Statement st;
            String sql = "SELECT * FROM "+table+" WHERE id="+id;
            System.out.println("REQUETE "+sql);
            st = connexionDB.getInstance().createStatement();

            rs = st.executeQuery(sql);
            return rs;

        } catch (SQLException ex) {
            Logger.getLogger(connexionDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }    
    
    
     public ResultSet getAbsenceDemande() {
        ResultSet rs = null;

        try {
            Statement st;
            String sql = "SELECT B.code_absence, A.Nom_agent,"
                    + " A.Prenom_agent,B.Type_absence, B.Duree_absence, "
                    + "B.Date_absence FROM `agent` A, absence B "
                    + "where B.Matricule_Agent=A.id AND B.etat=0";
            st = connexionDB.getInstance().createStatement();

            rs = st.executeQuery(sql);
            return rs;

        } catch (SQLException ex) {
            Logger.getLogger(connexionDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }
    
    
    
     public ResultSet getAgentAbsence() {
        ResultSet rs = null;

        try {
            Statement st;
            String sql = "SELECT * FROM `absence` where Matricule_Agent="+Setting.id;
            System.out.println("Requete "+sql);
            st = connexionDB.getInstance().createStatement();
            
            rs = st.executeQuery(sql);
            
            return rs;

        } catch (SQLException ex) {
            Logger.getLogger(connexionDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }
     
     
     
     
     public void updateAbsenceStatus(int etat, int code) {
        ResultSet rs = null;

        try {
            Statement st;
            String sql = "UPDATE `db_divine`.`absence` SET `etat`="+etat+" WHERE  `code_absence`="+code;
            System.out.println("Requete "+sql);
            st = connexionDB.getInstance().createStatement();
            
            st.executeUpdate(sql);
            
        } catch (SQLException ex) {
            Logger.getLogger(connexionDB.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
     
     
     
     
     
   

    public String loginUser(String email, String password) {
        ResultSet rs = null;
        try {

            String sql = "SELECT * FROM `auth` WHERE `email`=? AND password=?";

            PreparedStatement preparedStmt = connexionDB.getInstance().prepareStatement(sql);
            preparedStmt.setString(1, email);
            preparedStmt.setString(2, password);
            rs = preparedStmt.executeQuery();
            if (rs.next()) {
              
                String res=rs.getString("matricule")+"•"+rs.getString("table");
                  System.out.println("success "+res);
                return res;
            }
            System.err.println("Failed");

        } catch (SQLException ex) {
            Logger.getLogger(connexionDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "-1|-1";

    }

    public void addRecrutement(Fiche fiche) {
        ResultSet rs = null;
        try {

            String sql = "INSERT INTO `db_ruben`.`t_recrutement` (`numCarte`, `nom`, `postnom`, `prenom`, `sexe`, `dateNaissance`, `lieuNaissance`, `provinceOrigine`, `adresse`, `email`, `numPhone`, `diplome`, `etatCivil`) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";
            

            PreparedStatement ps = connexionDB.getInstance().prepareStatement(sql);
            ps.setString(1, fiche.getNumCarte());
            ps.setString(2, fiche.getNom());
            ps.setString(3, fiche.getPostnom());
            ps.setString(4, fiche.getPrenom());
            
            ps.setString(5, fiche.getSexe());
            ps.setString(6, fiche.getDateNaissance());
            ps.setString(7, fiche.getLieuNaissance());
            ps.setString(8, fiche.getProvinceOrigine());
            ps.setString(9, fiche.getAdresse());
            ps.setString(10, fiche.getEmail());
            ps.setString(11, fiche.getNumTelephone());
            ps.setString(12, fiche.getDiplome());
            ps.setString(13, fiche.getEtatCivil());
            
            
             ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(connexionDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
