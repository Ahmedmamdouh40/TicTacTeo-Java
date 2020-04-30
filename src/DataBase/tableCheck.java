/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataBase;


import java.sql.*;

/**
 *
 * @author Administrator
 */
public class tableCheck {
    dbase db=new dbase();
    DatabaseMetaData dbmd; 
    public tableCheck(){}
    public tableCheck(String tableName) {
        try{
        dbmd = db.con.getMetaData();
        db.rs = dbmd.getTables(null, null, tableName, null);
        if(tableName=="game"){
        if(db.rs.next()){
            System.out.println("Table game Exists");
        }else{
            String sql= "CREATE TABLE game( game_id int UNSIGNED AUTO_INCREMENT, game_name varchar(100) NOT NULL UNIQUE,player1 varchar(100) NOT NULL,player2 varchar(100) NOT NULL,winner varchar(100) NOT NULL,Play_Date varchar(100) NOT NULL,PRIMARY KEY(game_id))";
            db.stmt.executeUpdate(sql);
        }}else if(tableName=="record2"){
         if(db.rs.next()){
            System.out.println("Table record2 Exists");
        }else{
            String sql1= "CREATE TABLE record2(g_name varchar(100) NOT NULL UNIQUE,pos1 int default NULL,pos2 int default NULL,pos3 int default NULL,pos4 int default NULL,pos5 int default NULL,pos6 int default NULL,pos7 int default NULL,pos8 int default NULL,pos9 int default NULL, FOREIGN KEY(g_name) REFERENCES game(game_name))";
            db.stmt.executeUpdate(sql1);
        }   
        }
             db.con.setAutoCommit(false);
        } catch (SQLException ex) {
            ex.printStackTrace();
            try {
                if (db.con != null) {
                    db.con.rollback();
                    System.out.println("Rollback");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } finally {
            try {
                if (db.con != null) {
                    db.con.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            try {
                if (db.stmt != null) {
                    db.stmt.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            try {
                if (db.rs != null) {
                    db.rs.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
}
