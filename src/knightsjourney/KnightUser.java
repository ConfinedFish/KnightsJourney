package knightsjourney;

import java.util.Scanner;

public class KnightUser {
    public static void main(String[] args){
        new KnightUser().run();
    }
    private void run(){
        Scanner scan = new Scanner(System.in);
        int row = 0;
        int col = 0;
        Position pos = new Position(col, row);
        int startCol = 4;
        int startRow = 4;
        Knight knight = new Knight(startCol, startRow,pos);
        println("The final value: " + (movePiece(knight) ? "Success" : "Failure"));
        print(knight.printGrid());

    }
    private boolean movePiece(Knight knight){
        BackTrack backTrack = new BackTrack(knight);
        knight.markAsPossible(knight.getStart());
        return backTrack.tryToReachGoal(knight.getStart());
    }
    private void print(Object obj){
        System.out.print(obj);
    }
    private void println(Object obj){
        System.out.println(obj);
    }
}
