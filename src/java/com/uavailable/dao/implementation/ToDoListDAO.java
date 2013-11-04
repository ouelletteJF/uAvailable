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
import com.uavailable.entites.ToDoList;

/**
 *
 * @author azazazqs
 */
public class ToDoListDAO extends DAO<ToDoList>  {
        
        public ToDoListDAO(Connection c) {
        super(c);
    }

    @Override
    public boolean create(ToDoList x) {
        // TODO Auto-generated method stub

        String req = "INSERT INTO toDoList (`nomToDoList` , `nomTache`) "
                + "VALUES ('" + x.getNomToDoList() + "','" + x.getNomTache() + "')";

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
    public boolean delete(ToDoList x) {
        // TODO Auto-generated method stub
        Statement stm = null;
        try {
            stm = cnx.createStatement();
            int n = stm.executeUpdate("DELETE FROM toDoList WHERE nomToDoList='" + x.getNomToDoList() + "'");
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
    public ToDoList find(String id) {
        // TODO Auto-generated method stub
        try {
            Statement stm = cnx.createStatement();
            ResultSet r = stm.executeQuery("SELECT * FROM toDoList WHERE nomToDoList = '" + id + "'");
            if (r.next()) {
                ToDoList c = new ToDoList(r.getString("nomToDoList"));
                r.close();
                stm.close();
                return c;
            }
        } catch (SQLException exp) {
        }
        return null;
    }

    @Override
    public boolean update(ToDoList x) {
        // TODO Auto-generated method stub
        Statement stm = null;
        try {
            String req = "UPDATE toDoList SET nomTache = '" + x.getNomTache() + "'"
                    + " WHERE nomToDoList = '" + x.getNomToDoList() + "'";
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
    public List<ToDoList> findAll() {
        // TODO Auto-generated method stub
        List<ToDoList> liste = new LinkedList<ToDoList>();
        try {
            Statement stm = cnx.createStatement();
            ResultSet r = stm.executeQuery("SELECT * FROM toDoList");
            while (r.next()) {
                ToDoList c = new ToDoList(r.getString("nomToDoList"));
                liste.add(c);
            }
            r.close();
            stm.close();
        } catch (SQLException exp) {
        }
        return liste;
    }
    
    
     @Override
    public ToDoList find(int x ) {
        // TODO Auto-generated method stub
        
        return null;
    }
      
    
    
}
