package tictactoe.model;

import tictactoe.view.GameField;


import java.util.ArrayList;
import java.util.List;


public class UltrBot extends Bot {
    private int difficulty;
    private int fieldSize;
    private int score;
    private int maxDepth;

    private int enemywho; // human
    private int who; //ai

    private Buttons[][] buttons;

    private int[][] bestmove;
    private ArrayList availablePoints;

    public UltrBot(int fieldSize, int difficulty, int who) {
        checkWinner = new CheckWinner(fieldSize, fieldSize == 3 ? 3 : (fieldSize == 5 ? 4 : 5));
        maxDepth = fieldSize == 3 ? 10 : (fieldSize == 5 ? 4 : 3);

        this.difficulty = difficulty;
        this.fieldSize = fieldSize;
        this.who = who;
        buttons = GameField.getButtons();
        if (PvMGameProcess.getTurn() == 0) {
            if (who == 0) {
                enemywho = 1;
            } else enemywho = 2;
        } else {
            if (who == 0) {
                enemywho = 2;
            } else enemywho = 1;
        }
        bestmove = new int[2][2];
    }

    public List<Point> getAvailableStates(Buttons[][] newbuttons) {
        availablePoints = new ArrayList<>();
        for (int i = 0; i < fieldSize; ++i) {
            for (int j = 0; j < fieldSize; ++j) {
                if (newbuttons[i][j].isFree()) {
                    availablePoints.add(new Point(i, j));
                }
            }
        }
        return availablePoints;
    }

    private int minimax(int player, int x, int y, Buttons[][] newbuttons, int depth) {
        checkWinner.refreshData(newbuttons);
        List<Point> pointsAvailable = getAvailableStates(newbuttons);   //get all free positions
        if (checkWinner.checkWin(enemywho, x, y)) {
            return -1;
        } else if (checkWinner.checkWin(who, x, y)) {
            return 1;
        } else if (checkWinner.checkDraw()) {
            return 0;
        }
        if(depth==maxDepth)
            return 0;
        ArrayList<UltrScore> scoreList = new ArrayList<>();

        for (int i = 0; i < pointsAvailable.size(); i++) {
            Point point = pointsAvailable.get(i);           //get free point at i
            UltrScore score1 = new UltrScore();             //make new score element
            score1.setRaw(point.getX());
            score1.setCol(point.getY());                     //set curr position
            newbuttons[score1.getRaw()][score1.getCol()].setTest(player, false);      //set test value for curr position
            if (player == who) {
                score = minimax(enemywho, score1.getRaw(), score1.getCol(), newbuttons,depth + 1);           //find the best position for curr player(AI)
                score1.setScore(score);                         //save score at curr position
                if(score==1){
                    newbuttons[score1.getRaw()][score1.getCol()].setTest(0, true);        //remove test value
                    scoreList.add(score1);
                    break;
                }
            } else {
                score = minimax(who, score1.getRaw(), score1.getCol(), newbuttons,depth + 1);           //find the best position for enemy(human)
                score1.setScore(score);
                if(score==-1){
                    newbuttons[score1.getRaw()][score1.getCol()].setTest(0, true);        //remove test value
                    scoreList.add(score1);
                    break;
                }
            }
            newbuttons[score1.getRaw()][score1.getCol()].setTest(0, true);        //remove test value
            scoreList.add(score1);                                      //add score with curr position to list
        }

        int MaxScore = -10000;                                  //start values
        int MinScore = 10000;
        if (player == who) {
            for (int i = 0; i < scoreList.size(); i++) {                //find max score for curr combination
                if (scoreList.get(i).getScore() > MaxScore) {
                    MaxScore = scoreList.get(i).getScore();
                    bestmove[0][0] = scoreList.get(i).getRaw();                  //get x,y of best position to hit
                    bestmove[0][1] = scoreList.get(i).getCol();
                    if(MaxScore==1){
                        break;
                    }
                }
            }
        } else {                                                     //find min score for curr combination(the best way for enemy)
            for (int i = 0; i < scoreList.size(); i++) {
                if (scoreList.get(i).getScore() < MinScore) {
                    MinScore = scoreList.get(i).getScore();
                    bestmove[0][0] = scoreList.get(i).getRaw();
                    bestmove[0][1] = scoreList.get(i).getCol();
                    if(MaxScore==-1){
                        break;
                    }
                }
            }
        }
        return player == who ? MaxScore : MinScore;                     //return curr score
    }

    public void hitBot() {
        int depth = 0;
        List<Point> pointsAvailable = getAvailableStates(buttons);
        if (pointsAvailable.isEmpty()) return;
        minimax(who, pointsAvailable.get(0).getX(), pointsAvailable.get(0).getY(), buttons,depth);
        buttons[bestmove[0][0]][bestmove[0][1]].setWho(who);
        PvMGameProcess.isWinner(bestmove[0][0], bestmove[0][1]);

    }


}
