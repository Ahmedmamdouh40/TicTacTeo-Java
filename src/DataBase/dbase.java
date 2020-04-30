/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataBase;

import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author Administrator
 */
public class dbase {

    Connection con = null;
    Statement stmt = null;
    ResultSet rs = null;
    boolean flag = false;

    public dbase() {
        while (!flag) {
            try {
                ArrayList<String> list = new ArrayList<String>();
                String url = "jdbc:mysql://localhost:3306?&serverTimezone=UTC";
                con = DriverManager.getConnection(url, "root", "");
                stmt = con.createStatement();
                DatabaseMetaData meta = con.getMetaData();
                String database = "gameplay";
                rs = meta.getCatalogs();
                while (rs.next()) {
                    String listofDatabases = rs.getString("TABLE_CAT");
                    list.add(listofDatabases);
                }
                if (list.contains(database)) {
                    //System.out.println("Database already exists");
                    url = "jdbc:mysql://localhost:3306/gameplay?&serverTimezone=UTC";
                    con = DriverManager.getConnection(url, "root", "");
                    stmt = con.createStatement();
                    flag = true;
                } else {
                    String hrappSQL = "CREATE DATABASE gameplay";
                    stmt.executeUpdate(hrappSQL);
                    url = "jdbc:mysql://localhost:3306/gameplay?&serverTimezone=UTC";
                    con = DriverManager.getConnection(url, "root", "");
                    stmt = con.createStatement();
                    flag = true;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
