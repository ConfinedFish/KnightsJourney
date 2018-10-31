package knightsjourney;

import java.util.Scanner;

public class KnightUser {
    public static void main(String[] args){
        new KnightUser().run();
    }
    private void run(){
        Scanner scan = new Scanner(System.in);
        int row, col, startCol, startRow;

        while (true){
            print("Please enter a column width");
            try{
                col = scan.nextInt();
                break;
            }
            catch (Exception e){
                println("Invalid input");
            }
        }
        while (true){
            print("Please enter a row height");
            try{
                row = scan.nextInt();
                break;
            }
            catch (Exception e){
                println("Invalid Input");
            }
        }
        while (true){
            print("Please enter a starting column value");
            try{
                startCol = scan.nextInt();
                break;
            }
            catch(Exception e){
                println("Invalid input");
            }
        }
        while (true){
            print("Please enter a starting row value");
            try{
                startRow = scan.nextInt();
                break;
            }
            catch(Exception e){
                println("Invalid input");
            }
        }
        Position pos = new Position(startRow, startCol);
        Knight knight = new Knight(col, row, pos);
        println("The final value: " + (movePiece(knight) ? "Success" : "Failure"));
        println(knight.toString());
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
