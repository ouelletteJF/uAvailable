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
import com.uavailable.entites.BlocDisponilites;
/**
 *
 * @author DomyMb
 */
public class BlocDisponilitesDAO extends DAO<BlocDisponilites> {
    
    
     public BlocDisponilitesDAO(Connection c) {
        super(c);
    }

    @Override
    public boolean create(BlocDisponilites x) {
        // TODO Auto-generated method stub

        String req = "INSERT INTO blocDisponilites (`nomBloc` , `descriptionBloc` , `dateHeureBloc` , `duree` , `optRappelBloc`) "
                + "VALUES ('" + x.getNomBloc() + "','" + x.getDescriptionBloc() + "','" + x.getDateHeureBloc() + "','" + x.getDuree() +  "','" + x.getOptRappelBloc() +"')";

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
    public boolean delete(BlocDisponilites x) {
        // TODO Auto-generated method stub
        Statement stm = null;
        try {
            stm = cnx.createStatement();
            int n = stm.executeUpdate("DELETE FROM blocDisponilites WHERE nomBloc='" + x.getNomBloc() + "'");
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
    public BlocDisponilites find(String id) {
        // TODO Auto-generated method stub
        try {
            Statement stm = cnx.createStatement();
            ResultSet r = stm.executeQuery("SELECT * FROM blocDisponilites WHERE nomBloc = '" + id + "'");
            if (r.next()) {
                BlocDisponilites c = new BlocDisponilites(r.getString("nomBloc"));
                r.close();
                stm.close();
                return c;
            }
        } catch (SQLException exp) {
        }
        return null;
    }

    @Override
    public boolean update(BlocDisponilites x) {
        // TODO Auto-generated method stub
        Statement stm = null;
        try {
            String req = "UPDATE blocDisponilites SET descriptionBloc = '" + x.getDescriptionBloc() +   "',dateHeure = '" + x.getDateHeureBloc() + "',duree = '" + x.getDuree() +  "',optRappelBloc ='" + x.getOptRappelBloc() + "'"
                    + " WHERE nomBloc = '" + x.getNomBloc() + "'";
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
    public List<BlocDisponilites> findAll() {
        // TODO Auto-generated method stub
        List<BlocDisponilites> liste = new LinkedList<BlocDisponilites>();
        try {
            Statement stm = cnx.createStatement();
            ResultSet r = stm.executeQuery("SELECT * FROM blocDisponilites");
            while (r.next()) {
                BlocDisponilites c = new BlocDisponilites(r.getString("nomBloc"));
                liste.add(c);
            }
            r.close();
            stm.close();
        } catch (SQLException exp) {
        }
        return liste;
    }
    
    
     @Override
    public BlocDisponilites find(int x ) {
        // TODO Auto-generated method stub
        
        return null;
    }
      
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
