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
import com.uavailable.entites.Tache;
/**
/**
 *
 * @author DomyMb
 */
public class TacheDAO extends DAO<Tache> {
    
        
     public TacheDAO(Connection c) {
        super(c);
    }

    @Override
    public boolean create(Tache x) {
        // TODO Auto-generated method stub

        String req = "INSERT INTO tache (`nomTache` , `dateHeure` , `descriptionTache` , `optRappel`) "
                + "VALUES ('" + x.getNomTache() + "','" + x.getDateHeure() + "','" + x.getDescriptionTache() + "','" + x.getOptRappel() + "')";

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
    public boolean delete(Tache x) {
        // TODO Auto-generated method stub
        Statement stm = null;
        try {
            stm = cnx.createStatement();
            int n = stm.executeUpdate("DELETE FROM tache WHERE nomTache='" + x.getNomTache() + "'");
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
    public Tache find(String id) {
        // TODO Auto-generated method stub
        try {
            Statement stm = cnx.createStatement();
            ResultSet r = stm.executeQuery("SELECT * FROM tache WHERE nomTache = '" + id + "'");
            if (r.next()) {
                Tache c = new Tache(r.getString("nomTache"));
                r.close();
                stm.close();
                return c;
            }
        } catch (SQLException exp) {
        }
        return null;
    }

    @Override
    public boolean update(Tache x) {
        // TODO Auto-generated method stub
        Statement stm = null;
        try {
            String req = "UPDATE tache SET dateHeure = '" + x.getDateHeure() +   "',dateHeure = '" + x.getDescriptionTache() + "',optRappel = '" + x.getOptRappel() +  "'"
                    + " WHERE nomTache = '" + x.getNomTache() + "'";
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
    public List<Tache> findAll() {
        // TODO Auto-generated method stub
        List<Tache> liste = new LinkedList<Tache>();
        try {
            Statement stm = cnx.createStatement();
            ResultSet r = stm.executeQuery("SELECT * FROM tache");
            while (r.next()) {
                Tache c = new Tache(r.getString("nomTache"));
                liste.add(c);
            }
            r.close();
            stm.close();
        } catch (SQLException exp) {
        }
        return liste;
    }
    
    
     @Override
    public Tache find(int x ) {
        // TODO Auto-generated method stub
        
        return null;
    }
      
    
    
    
    
    
    
}
