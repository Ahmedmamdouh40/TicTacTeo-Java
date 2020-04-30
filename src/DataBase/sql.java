/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataBase;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

/**
 *
 * @author Administrator
 */
public class sql {

    dbase db = new dbase();
    PosObj po = new PosObj();
    static String table_Name=null;
    //tableCheck tb=new tableCheck();
    public void insert(String gname, String player1, String player2, String winner) {
        try {
            table_Name="game";
            new tableCheck(table_Name);
            Date date = new Date();
            SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
            String strDate = formatter.format(date);
            String sql = "INSERT INTO game(game_name,player1,player2,winner,play_date) VALUES ('" + gname + "','" + player1 + "','" + player2 + "','" + winner + "','" + strDate + "')";
            db.stmt.executeUpdate(sql);
            db.con.setAutoCommit(false);
        } catch (SQLException ex) {
            ex.printStackTrace();
            try {
                if (db.con != null) {
                    db.con.rollback();
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

    public void update(String winner) {
        try {
            table_Name="game";
            new tableCheck(table_Name);
            String queryString = new String("select * from game");
            db.rs = db.stmt.executeQuery(queryString);
            db.rs.last();
            String name = db.rs.getString("game_name");
            String sql1 = "UPDATE game " + "SET winner='" + winner + "' WHERE game_name ='" + name + "'";
            db.stmt.executeUpdate(sql1);
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

    public void record2(int pos1, int pos2, int pos3, int pos4, int pos5, int pos6, int pos7, int pos8, int pos9) {
        try {
            table_Name="record2";
            new tableCheck(table_Name);
            String queryString = new String("select * from game");
            db.rs = db.stmt.executeQuery(queryString);
            db.rs.last();
            String gname = db.rs.getString("game_name");
            String sql = "INSERT INTO record2(g_name,pos1,pos2,pos3,pos4,pos5,pos6,pos7,pos8,pos9) VALUES ('" + gname + "','" + pos1 + "','" + pos2 + "','" + pos3 + "','" + pos4 + "','" + pos5 + "','" + pos6 + "','" + pos7 + "','" + pos8 + "','" + pos9 + "')";
            db.stmt.executeUpdate(sql);
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

    public Vector<String> view() {
        Vector<String> allRecords = new Vector<>();
        try {
            table_Name="game";
            new tableCheck(table_Name);
            String queryString = new String("select * from game");
            db.rs = db.stmt.executeQuery(queryString);
            while (db.rs.next()) {
                String name1 = db.rs.getString("game_name");
                String winner = db.rs.getString("winner");
                allRecords.add(name1);
            }
            //System.out.println(allRecords.get(0));
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
        return allRecords;
    }

    public PosObj viewRecord() {
        try {
            table_Name="record2";
            new tableCheck(table_Name);
            String gname = po.getName();
            String queryString = new String("select * from record2 Where g_name= '" + gname + "' ");
            db.rs = db.stmt.executeQuery(queryString);
            db.rs.first();
            int pos1 = db.rs.getInt("pos1");
            int pos2 = db.rs.getInt("pos2");
            int pos3 = db.rs.getInt("pos3");
            int pos4 = db.rs.getInt("pos4");
            int pos5 = db.rs.getInt("pos5");
            int pos6 = db.rs.getInt("pos6");
            int pos7 = db.rs.getInt("pos7");
            int pos8 = db.rs.getInt("pos8");
            int pos9 = db.rs.getInt("pos9");
            po = new PosObj(pos1, pos2, pos3, pos4, pos5, pos6, pos7, pos8, pos9);
            System.out.println(pos1 + pos2 +pos3);
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
        return po;
    }

    public Vector<String> viewDate() {
        Vector<String> Records = new Vector<>();
        try {
            table_Name="game";
            new tableCheck(table_Name);
            String queryString = new String("select * from game");
            db.rs = db.stmt.executeQuery(queryString);
            while (db.rs.next()) {
                String date = db.rs.getString("play_date");
                Records.add(date);
            }
            //System.out.println(Records.get(0));
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
        return Records;
    }

}
