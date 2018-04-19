package model;

//import org.junit.jupiter.api.Test;

import org.junit.Test;
import view.GameField;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
//import static org.junit.jupiter.api.Assertions.*;

 public class CheckWinnerTest {

    @Test
    public void refreshDataTestShouldReturnTrue() {
        CheckWinner checkWinner = new CheckWinner(5,5);
        Buttons buttons[][] = new Buttons[5][5];
        for (int i = 0; i < 5; i++)
            for (int j = 0; j < 5; j++){
                buttons[i][j] = new Buttons(1);
                buttons[i][j].setTest(1,true);
            }
        checkWinner.refreshData(buttons);               //update checkWinner buttons[][]
        assertArrayEquals(buttons, checkWinner.getButtons());
    }

    @Test
     public void checkWinTestShouldReturnTrue() {
        CheckWinner checkWinner = new CheckWinner(5,5);
        Buttons buttons[][] = new Buttons[5][5];
        for (int i = 0; i < 5; i++)
            for (int j = 0; j < 5; j++) {
                buttons[i][j] = new Buttons(1);
            }
        for (int i = 0; i < 5; i++){
                buttons[i][1].setTest(1,false);
            }
            checkWinner.refreshData(buttons);
        assertEquals(true, checkWinner.checkWin(1,0,1));
    }
     @Test
     public void checkWinTestShouldReturnFalse() {
         CheckWinner checkWinner = new CheckWinner(5,5);
         Buttons buttons[][] = new Buttons[5][5];
         for (int i = 0; i < 5; i++)
             for (int j = 0; j < 5; j++) {
                 buttons[i][j] = new Buttons(1);
             }
         for (int i = 0; i < 5; i++){
             buttons[i][1].setTest(1,false);
         }
         buttons[2][1].setTest(0,true);
         checkWinner.refreshData(buttons);
         assertEquals(false, checkWinner.checkWin(1,0,1));
     }

    @Test
    public void checkDrawTestShouldReturnFalse() {
        CheckWinner checkWinner = new CheckWinner(5,5);
        Buttons buttons[][] = new Buttons[5][5];
        for (int i = 0; i < 5; i++)
            for (int j = 0; j < 5; j++){
                buttons[i][j] = new Buttons(1);
                buttons[i][j].setTest(0,true);          //set all cells to free
            }

        checkWinner.refreshData(buttons);
        assertEquals(false, checkWinner.checkDraw());   //we expect false because all cells are free
    }

     @Test
     public void checkDrawTestShouldReturnTrue() {
         CheckWinner checkWinner = new CheckWinner(5,5);
         Buttons buttons[][] = new Buttons[5][5];
         for (int i = 0; i < 5; i++)
             for (int j = 0; j < 5; j++){
                 buttons[i][j] = new Buttons(1);
                 buttons[i][j].setTest(1,false);          //set all cells to free
             }

         checkWinner.refreshData(buttons);
         assertEquals(true, checkWinner.checkDraw());   //we expect false because all cells are free
     }

    @Test
    public void checkOutOfFieldTestShouldReturnTrue() {
        CheckWinner checkWinner = new CheckWinner(5,5);
        assertEquals(true, checkWinner.checkOutOfField(4,4));
    }
}