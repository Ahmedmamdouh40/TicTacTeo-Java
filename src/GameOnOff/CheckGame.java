/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameOnOff;

import static GameOnOff.GameON.movesPlayed;
import java.util.Vector;

/**
 *
 * @author Nouran
 */
public class CheckGame {
    
//    Vector board;
    GameON gamePage;
    GameOFF gameOffPage;
    String X = "X";
    String O = "O";
    
    public CheckGame(GameON gamePage) {
//        this.board = boxes;
        this.gamePage = gamePage;
        
        checkGame();
    }
    
    public CheckGame(GameOFF gamePage) {
        this.gameOffPage = gamePage;
        
        checkGame();
    }
    
    void checkGame() {
        String[] p;
        String sp = gamePage.mySymbol;
        int i,j,k;

        p = new String[9];
        
        for ( i=0 ; i < 9 ; i++){
            p[i] = gamePage.boxes.get(i).getText();
            System.out.println(gamePage.boxes.get(i).getText());
        } 
        System.out.println("Game checking");
        
        for(int x = 0 ; x<2 ; x++){
            for (j=k=0; j<9 ; j+=3, k++){
                if (
                        (sp.equals(p[j]) && sp.equals(p[j+1]) && sp.equals(p[j+2])) // Check The Rows 
                        || (sp.equals(p[k]) && sp.equals(p[k+3]) && sp.equals(p[k+6])) // Check The Columns
                    ){
                        //System.out.println("Inside if");
                      if ( gamePage.mySymbol.equals(sp) ) {
                          System.out.println("Player " + gamePage.mySymbol + " won");
                          gamePage.playerWon = gamePage.mySymbol;
                        }
                      if ( gamePage.oponentSymbol.equals(sp) ) {
                          System.out.println("Player " + gamePage.oponentSymbol + " won");
                          gamePage.playerWon = gamePage.oponentSymbol;
                      }
                      gamePage.gameEnded = true;
                      stop();
                    }
            } 
            if (
                (sp.equals(p[0]) && sp.equals(p[4]) && sp.equals(p[8]))  // Check Diagnoal (\)
                || (sp.equals(p[6]) && sp.equals(p[4]) && sp.equals(p[2])) // Check Diagonal (/)
                ){
                    if ( gamePage.mySymbol.equals(sp) ) {
                          System.out.println("Player " + gamePage.mySymbol + " won");
                          gamePage.playerWon = gamePage.mySymbol;
                        }
                      if ( gamePage.oponentSymbol.equals(sp) ) {
                          System.out.println("Player " + gamePage.oponentSymbol + " won");
                          gamePage.playerWon = gamePage.oponentSymbol;
                      }
                    gamePage.gameEnded = true;
                    stop();
                }
            sp = gamePage.oponentSymbol;
        }

        if (movesPlayed.size() == 9 && gamePage.gameEnded == false) {
            System.out.println("Tie");
            gamePage.playerWon = "None";
            gamePage.gameEnded = true;
        }
    }
    
//    private void checkgame() {
//        
//        String[] p;
//        String sp = "X";
//        int i,j,k;
//
//        p = new String[9];
//        
//        for ( i=0 ; i < 9 ; i++){
//            p[i] = btn[i].getText();
//        } 
//        
//        for(int x = 0 ; x<2 ; x++){
//                for (j=k=0; j<9 ; j+=3, k++){
//                    if (
//                            (sp.equals(p[j]) && sp.equals(p[j+1]) && sp.equals(p[j+2])) // Check The Rows 
//                            || (sp.equals(p[k]) && sp.equals(p[k+3]) && sp.equals(p[k+6])) // Check The Columns
//                        ){
//                          if ( X.equals(sp) ) System.out.println("player 1 won");
//                          if ( O.equals(sp) ) System.out.println("player 2 won");
//                          end = true;
//                          stop();}} 
//                if (
//                        (sp.equals(p[0]) && sp.equals(p[4]) && sp.equals(p[8]))  // Check Diagnoal (\)
//                        || (sp.equals(p[6]) && sp.equals(p[4]) && sp.equals(p[2])) // Check Diagonal (/)
//                        ){
//                          if ( X.equals(sp) ) System.out.println("player 1 won");
//                          if ( O.equals(sp) ) System.out.println("player 2 won");
//                          end = true;
//                          stop();}
//            sp = "O";
//        }
//
//        if (count == 9 && end == false) {
//            System.out.println("Tie");
//        }
//    }
//    
    private void stop() {
        System.out.println("Thank you for playing");
//        System.exit(0);
    }
}
