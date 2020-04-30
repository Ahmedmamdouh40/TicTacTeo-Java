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
public class PosObj {
    static String name;
    int pos1;
    int pos2;
    int pos3;
    int pos4;
    int pos5;
    int pos6;
    int pos7;
    int pos8;
    int pos9;
    static int flag;
    PosObj(){}
    public String getName() {
    return name;
    }
    public void setName(String newName) {
    this.name = newName;
    }
    public int getFlag() {
    return flag;
    }
    public void setFlag(int newFlag) {
    this.flag = newFlag;
    }
    PosObj(int pos1,int pos2,int pos3,int pos4,int pos5,int pos6,int pos7,int pos8,int pos9){
        this.pos1=pos1;
        this.pos2=pos2;
        this.pos3=pos3;
        this.pos4=pos4;
        this.pos5=pos5;
        this.pos6=pos6;
        this.pos7=pos7;
        this.pos8=pos8;
        this.pos9=pos9;
    }
}
