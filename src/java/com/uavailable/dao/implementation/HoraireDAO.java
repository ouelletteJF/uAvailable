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
import com.uavailable.entites1.Horaire;
/**
 *
 * @author DomyMb
 */
public class HoraireDAO extends DAO<Horaire>  {
    
     public HoraireDAO(Connection c) {
        super(c);
    }
     
    @Override
    public boolean create(Horaire x) {
        // TODO Auto-generated method stub

        String req = "INSERT INTO horaire (`nomHoraire`,`nomCalendrier`,`nomBloc`)" +
			   " VALUES ('"+x.getNomHoraire()+"','"+x.getNomCalendrier()+"','"+x.getNomBloc()+"')";

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
    public boolean delete(Horaire x) {
        // TODO Auto-generated method stub
        Statement stm = null;
        try {
            stm = cnx.createStatement();
            int n = stm.executeUpdate("DELETE FROM horaire WHERE nomHoraire='" + x.getNomHoraire() + "'");
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
    public Horaire find(String id) {
        // TODO Auto-generated method stub
        try {
            Statement stm = cnx.createStatement();
            ResultSet r = stm.executeQuery("SELECT * FROM horaire WHERE nomHoraire = '" + id + "'");
            if (r.next()) {
                Horaire c = new Horaire(r.getString("nomHoraire"));
                r.close();
                stm.close();
                return c;
            }
        } catch (SQLException exp) {
        }
        return null;
    }
    
    
    
     @Override
    public Horaire find(int x ) {
        // TODO Auto-generated method stub
        
        return null;
    }
    

    @Override
    public boolean update(Horaire x) {
        // TODO Auto-generated method stub
        Statement stm = null;
        try {
            String req = "UPDATE horaire SET nomCalendrier = '" + x.getNomCalendrier() + "', nomBloc ='"+x.getNomBloc()+ "'"
                    + " WHERE nomHoraire = '" + x.getNomHoraire() + "'";
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
    public List<Horaire> findAll() {
        // TODO Auto-generated method stub
        List<Horaire> liste = new LinkedList<Horaire>();
        try {
            Statement stm = cnx.createStatement();
            ResultSet r = stm.executeQuery("SELECT * FROM horaire");
            while (r.next()) {
                Horaire c = new Horaire(r.getString("nomHoraire"));
                liste.add(c);
            }
            r.close();
            stm.close();
        } catch (SQLException exp) {
        }
        return liste;
    }
    
    
         
    
    
}
