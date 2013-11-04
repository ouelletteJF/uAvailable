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
import com.uavailable.entites.GroupeDeContact;
/**
 *
 * @author azazazqs
 */
public class GroupeDeContactDAO extends DAO<GroupeDeContact> {  
      public GroupeDeContactDAO(Connection c) {
        super(c);
    }

    @Override
    public boolean create(GroupeDeContact x) {
        // TODO Auto-generated method stub

        String req = "INSERT INTO groupeDeContact (`nomGroupe` , `nomMembre`) "
                + "VALUES ('" + x.getNomGroupe() + "','" + x.getNomMembre() + "')";

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
    public boolean delete(GroupeDeContact x) {
        // TODO Auto-generated method stub
        Statement stm = null;
        try {
            stm = cnx.createStatement();
            int n = stm.executeUpdate("DELETE FROM groupeDeContact WHERE nomGroupe='" + x.getNomGroupe() + "'");
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
    public GroupeDeContact find(String id) {
        // TODO Auto-generated method stub
        try {
            Statement stm = cnx.createStatement();
            ResultSet r = stm.executeQuery("SELECT * FROM groupeDeContact WHERE nomGroupe = '" + id + "'");
            if (r.next()) {
                GroupeDeContact c = new GroupeDeContact(r.getString("nomGroupe"));
                r.close();
                stm.close();
                return c;
            }
        } catch (SQLException exp) {
        }
        return null;
    }

    @Override
    public boolean update(GroupeDeContact x) {
        // TODO Auto-generated method stub
        Statement stm = null;
        try {
            String req = "UPDATE groupeDeContact SET nomMembre = '" + x.getNomMembre() + "'"
                    + " WHERE nomGroupe = '" + x.getNomGroupe() + "'";
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
    public List<GroupeDeContact> findAll() {
        // TODO Auto-generated method stub
        List<GroupeDeContact> liste = new LinkedList<GroupeDeContact>();
        try {
            Statement stm = cnx.createStatement();
            ResultSet r = stm.executeQuery("SELECT * FROM groupeDeContact");
            while (r.next()) {
                GroupeDeContact c = new GroupeDeContact(r.getString("nomGroupe"));
                liste.add(c);
            }
            r.close();
            stm.close();
        } catch (SQLException exp) {
        }
        return liste;
    }
    
    
     @Override
    public GroupeDeContact find(int x ) {
        // TODO Auto-generated method stub
        
        return null;
    }
      
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
