/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataBase;

/**
 *
 * @author Administrator
 */
public class dbObj {
    int id;
    String game_name;
    String name1;
    String name2;
    String winner;
    public dbObj(int id,String game_name,String name1,String name2,String winner){
        this.id=id;
        this.game_name=game_name;
        this.name1=name1;
        this.name2=name2;
        this.winner=winner;
    }

    public dbObj() {}
}
