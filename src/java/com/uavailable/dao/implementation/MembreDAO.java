/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uavailable.dao.implementation;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import com.uavailable.dao.DAO;
import com.uavailable.entites.Membre;
/**
 *
 * @author DomyMb
 */
public class MembreDAO extends DAO< Membre>{
    
     
     public MembreDAO(Connection c) {
        super(c);
    }

    @Override
    public boolean create(Membre x) {
        // TODO Auto-generated method stub

        String req = "INSERT INTO membre (`numeroTelephone` , `nomMembre` , `prenomMembre` , `dateNaissance` , `eMail`, `motDePasse`, `nomGroupe`, `nomToDoList`) "
                + "VALUES ('" + x.getNumeroTelephone() + "','" + x.getNomMembre() + "','" + x.getPrenomMembre() + "','" + x.getDateNaissance() +  "','" + x.getEMail() +"','" + x.getMotDePasse() +"','" + x.getNomGroupe() +"','" + x.getNomToDoList() +"')";

        //System.out.println("REQUETE "+req);

        Statement stm = null;
        try {
            stm = cnx.createStatement();
            int n = stm.executeUpdate(req);
            if (n > 0) {
                stm.close();
                return true;
            }
        } 
        catch (SQLException exp) {
        } finally {
            if (stm != null) {
                try {
                    stm.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }

        return false;
    }

    @Override
    public boolean delete(Membre x) {
        // TODO Auto-generated method stub
        Statement stm = null;
        try {
            stm = cnx.createStatement();
            int n = stm.executeUpdate("DELETE FROM membre WHERE numeroTelephone='" + x.getNumeroTelephone() + "'");
            if (n > 0) {
                stm.close();
                return true;
            }
        } catch (SQLException exp) {
        } finally {
            if (stm != null) {
                try {
                    stm.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
        return false;
    }

    @Override
    public Membre find(String id) {
        // TODO Auto-generated method stub
        try {
            Statement stm = cnx.createStatement();
            ResultSet r = stm.executeQuery("SELECT * FROM membre WHERE numeroTelephone = '" + id + "'");
            if (r.next()) {
                Membre c = new Membre(r.getString("numeroTelephone"));
                r.close();
                stm.close();
                return c;
            }
        } catch (SQLException exp) {
        }
        return null;
    }

    @Override
    public boolean update(Membre x) {
        // TODO Auto-generated method stub
        Statement stm = null;
        try {
            String req = "UPDATE membre SET nomMembre = '" + x.getNomMembre() +   "',dateHeure = '" + x.getPrenomMembre() +
                    "',dateNaissance = '" + x.getDateNaissance() +  "',eMail ='" + x.getEMail() + "',motDePasse ='" + x.getMotDePasse() +
                    "',nomGroupe ='" + x.getNomGroupe() +"',nomToDoList ='" + x.getNomToDoList() + "'"
                    + " WHERE numeroTelephone = '" + x.getNumeroTelephone() + "'";
            //System.out.println("REQUETE "+req);
            stm = cnx.createStatement();
            int n = stm.executeUpdate(req);
            if (n > 0) {
                stm.close();
                return true;
            }
        } catch (SQLException exp) {
        } finally {
            if (stm != null) {
                try {
                    stm.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
        return false;
    }

    @Override
    public List<Membre> findAll() {
        // TODO Auto-generated method stub
        List<Membre> liste = new LinkedList<Membre>();
        try {
            Statement stm = cnx.createStatement();
            ResultSet r = stm.executeQuery("SELECT * FROM membre");
            while (r.next()) {
                Membre c = new Membre(r.getString("numeroTelephone"));
                liste.add(c);
            }
            r.close();
            stm.close();
        } catch (SQLException exp) {
        }
        return liste;
    }
    
    
     @Override
    public Membre find(int x ) {
        // TODO Auto-generated method stub
        
        return null;
    }

    public Membre Membre(String nom) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
