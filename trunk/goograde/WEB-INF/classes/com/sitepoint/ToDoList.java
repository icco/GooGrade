package com.sitepoint;

import java.util.*;
import java.sql.*;

public class ToDoList {

   private String jdbcConnectionString;
   private List list = new ArrayList();
   private boolean staleList = true;
   private Connection conn;

   public ToDoList(String jdbcDriver, String jdbcConnectionString) {
      this.jdbcConnectionString = jdbcConnectionString;

      // Load the driver
      try {
         Class.forName(jdbcDriver).newInstance();
      }
      catch (Exception ex) {
         System.err.println("Error loading database driver " + jdbcDriver +
                            ":\n" + ex.getMessage());
      }

   }

   private void refreshList() {
      if (staleList) {
         try {
            if (conn == null) {
               conn = DriverManager.getConnection(jdbcConnectionString);
            }

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT todoid, todo FROM todo");
            list = new ArrayList();

            while (rs.next()) {
               list.add(new ToDoItem(rs.getInt(1), rs.getString(2)));
            }
         }
         catch (SQLException ex) {
            System.err.println(
               "Error retrieving to-do list items from the database:\n" +
               ex.getMessage());
         }

         staleList = false;
      }
   }

   public List getToDoItems() {
      refreshList();
      List newlist = new ArrayList(list);
      return (List) newlist;
   }

   public int getItemCount() {
      refreshList();
      return list.size();
   }

   public void addItem(String item) {
      try {
         if (conn == null) {
            conn = DriverManager.getConnection(jdbcConnectionString);
         }
         PreparedStatement stmt = conn.prepareStatement(
         "INSERT INTO todo (todo) VALUES (?)");
         stmt.setString(1, item);
         stmt.executeUpdate();
      }
      catch (SQLException ex) {
         System.err.println(
            "Error adding a to-do list item to the database:\n" +
            ex.getMessage());
      }
      staleList = true;
   }

   public void deleteItem(int id) {
      try {
         if (conn == null) {
            conn = DriverManager.getConnection(jdbcConnectionString);
         }
         PreparedStatement stmt = conn.prepareStatement(
            "DELETE FROM todo WHERE todoid=?");
         stmt.setInt(1, id);
         stmt.executeUpdate();
      }
      catch (SQLException ex) {
         System.err.println(
            "Error deleting a to-do list item from the database:\n" +
            ex.getMessage());
      }
      staleList = true;
   }

}

