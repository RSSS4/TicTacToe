package tictactoe.model;

import tictactoe.view.GameField;
import tictactoe.view.XOButton;

import java.util.ArrayList;
import java.util.List;


public class UltrBot extends Bot {
    private int difficulty;
    private int fieldSize;
    private int score;

    private int enemywho; // human
    private int who; //ai

    private XOButton[][] buttons;

    private int[][] bestmove;
    private ArrayList availablePoints;

    public UltrBot(int fieldSize, int difficulty, int who) {
        checkWinner = new CheckWinner(fieldSize, fieldSize == 3 ? 3 : (fieldSize == 5 ? 4 : 5));
        this.difficulty = difficulty;
        this.fieldSize = fieldSize;
        this.who = who;
        buttons = GameField.GetButtons();
        if (PvMGameProcess.GetTurn() == 0) {
            if (who == 0) {
                enemywho = 1;
            } else enemywho = 2;
        } else {
            if (who == 0) {
                enemywho = 2;
            } else enemywho = 1;
        }
        bestmove = new int[2][2];
        System.out.println(difficulty);
    }

    public List<Point> getAvailableStates(XOButton[][] newbuttons) {
        availablePoints = new ArrayList<>();
        for (int i = 0; i < fieldSize; ++i) {
            for (int j = 0; j < fieldSize; ++j) {
                if (newbuttons[i][j].IsFree()) {
                    availablePoints.add(new Point(i, j));
                }
            }
        }
        return availablePoints;
    }

    private int minimax(int player, int x, int y, XOButton[][] newbuttons){
        checkWinner.RefreshData(newbuttons);
        List<Point> pointsAvailable = getAvailableStates(newbuttons);   //get all free positions
        if (checkWinner.CheckWin(enemywho, x, y)){
            return -1;
        }
        else if (checkWinner.CheckWin(who, x, y)){
            return 1;
        }
        else if (checkWinner.CheckDraw()){
            return 0;
        }
        ArrayList<UltrScore> scoreList = new ArrayList<>();

        for (int i = 0; i < pointsAvailable.size(); i++) {
            Point point = pointsAvailable.get(i);           //get free point at i
            UltrScore score1 = new UltrScore();             //make new score element
            score1.SetRaw(point.GetX());
            score1.SetCol(point.GetY());                     //set curr position
            newbuttons[score1.GetRaw()][score1.GetCol()].SetTest(player, false);      //set test value for curr position
            if(player ==  who){
                score = minimax(enemywho, score1.GetRaw(), score1.GetCol(),newbuttons);           //find the best position for curr player(AI)
                score1.SetScore(score);                         //save score at curr position
            }else{
                score = minimax(who,  score1.GetRaw(), score1.GetCol(),newbuttons);           //find the best position for enemy(human)
                score1.SetScore(score);
            }
            newbuttons[score1.GetRaw()][score1.GetCol()].SetTest(0, true);        //remove test value
            scoreList.add(score1);                                      //add score with curr position to list
        }

        int MaxScore = -10000;                                  //start values
        int MinScore = 10000;
        if (player == who) {
            for (int i = 0; i < scoreList.size(); i++) {                //find max score for curr combination
                if (scoreList.get(i).GetScore() > MaxScore) {
                    MaxScore = scoreList.get(i).GetScore();
                    bestmove[0][0] = scoreList.get(i).GetRaw();                  //get x,y of best position to hit
                    bestmove[0][1] = scoreList.get(i).GetCol();
                }
            }
        } else {                                                     //find min score for curr combination(the best way for enemy)
            for (int i = 0; i < scoreList.size(); i++) {
                if (scoreList.get(i).GetScore() < MinScore) {
                    MinScore = scoreList.get(i).GetScore();
                    bestmove[0][0] = scoreList.get(i).GetRaw();
                    bestmove[0][1] = scoreList.get(i).GetCol();
                }
            }
        }
        return player == who?MaxScore:MinScore;                     //return curr score
    }

    public void HitBot(){
        List<Point> pointsAvailable = getAvailableStates(buttons);
        if (pointsAvailable.isEmpty()) return;
        minimax(who,pointsAvailable.get(0).GetX(), pointsAvailable.get(0).GetY(), buttons);
        buttons[bestmove[0][0]][bestmove[0][1]].SetWho(who);
        PvMGameProcess.IsWinner(bestmove[0][0],  bestmove[0][1]);

    }


}
