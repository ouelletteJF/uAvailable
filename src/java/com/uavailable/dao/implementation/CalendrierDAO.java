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
import com.uavailable.entites1.Calendrier;

/**
 *
 * @author DomyMb
 */
public class CalendrierDAO extends DAO<Calendrier>  {
    
    
      public CalendrierDAO(Connection c) {
        super(c);
    }
     
    @Override
    public boolean create(Calendrier x) {
        // TODO Auto-generated method stub

        String req = "INSERT INTO calendrier (`nomCalendrier`,`descriptionCalendrier`,`optPartage`)" +
			   " VALUES ('"+x.getNomCalendrier()+"','"+x.getDescriptionCalendrier()+"','"+x.getOptPartage()+"')";

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
    public boolean delete(Calendrier x) {
        // TODO Auto-generated method stub
        Statement stm = null;
        try {
            stm = cnx.createStatement();
            int n = stm.executeUpdate("DELETE FROM calendrier WHERE nomCalendrier='" + x.getNomCalendrier() + "'");
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
    public Calendrier find(String id) {
        // TODO Auto-generated method stub
        try {
            Statement stm = cnx.createStatement();
            ResultSet r = stm.executeQuery("SELECT * FROM calendrier WHERE nomCalendrier = '" + id + "'");
            if (r.next()) {
                Calendrier c = new Calendrier(r.getString("nomCalendrier"));
                r.close();
                stm.close();
                return c;
            }
        } catch (SQLException exp) {
        }
        return null;
    }
    
    
    
     @Override
    public Calendrier find(int x ) {
        // TODO Auto-generated method stub
        
        return null;
    }
    

    @Override
    public boolean update(Calendrier x) {
        // TODO Auto-generated method stub
        Statement stm = null;
        try {
            String req = "UPDATE calendrier SET descriptionCalendrier = '" + x.getDescriptionCalendrier() + "', optPartage ='"+x.getOptPartage()+ "'"
                    + " WHERE nomCalendrier = '" + x.getNomCalendrier() + "'";
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
    public List<Calendrier> findAll() {
        // TODO Auto-generated method stub
        List<Calendrier> liste = new LinkedList<Calendrier>();
        try {
            Statement stm = cnx.createStatement();
            ResultSet r = stm.executeQuery("SELECT * FROM calendrier");
            while (r.next()) {
                Calendrier c = new Calendrier(r.getString("nomCalendrier"));
                liste.add(c);
            }
            r.close();
            stm.close();
        } catch (SQLException exp) {
        }
        return liste;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
