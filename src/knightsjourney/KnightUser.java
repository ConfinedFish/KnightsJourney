/**
* Project: Project3                                             
* Author: Alex Zeigler                      
* Creation date: 10/18/18                             
* Completion time: 6 hours                                       
*                                                              
* Honor Code: I pledge that this program represents my         
*   own program code.            
*/

package knightsjourney;

import java.util.Scanner;

/**
 * This class demonstrates the algorithms inside the Knight class.
 * The main method calls run method then asks for user input. Based on that input, the board is built and the
 * knight is placed on the board.
 * Due to the complexity of the problem, boards larger than 9x9 take a long time to display the board. The possible
 * moves increases at an exponential rate.
 */
public class KnightUser {
    /**
     * Main method of the program. Calls the run() method.
     * @param args args
     */
    public static void main(String[] args){
        new KnightUser().run();
    }

    /**
     * Asks for user input and calls the required methods to run the algorithm from Knight.
     */
    private void run(){
        Scanner scan = new Scanner(System.in);
        int row, col, startCol, startRow;

        while (true){
            print("Please enter a column width: ");
            try{
                col = scan.nextInt();
                break;
            }
            catch (Exception e){
                println("Invalid input");
            }
        }
        while (true){
            print("Please enter a row height: ");
            try{
                row = scan.nextInt();
                break;
            }
            catch (Exception e){
                println("Invalid Input");
            }
        }
        while (true){
            print("Please enter a starting column value: ");
            try{
                startCol = scan.nextInt();
                break;
            }
            catch(Exception e){
                println("Invalid input");
            }
        }
        while (true){
            print("Please enter a starting row value: ");
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
        println((movePiece(knight) ? "Success\n" + knight.toString(): "Failure" ));
    }

    /**
     * Begins the calls for the algorithm
     * @param knight The knight object constructed with the start position
     * @return the result of the algorithm. If there is a solution the result is true.
     */
    public boolean movePiece(Knight knight){
        knight.markAsPossible(knight.getStart());
        return new BackTrack(knight).tryToReachGoal(knight.getStart());
    }

    /**
     * Shortcut to the System.out.print() method.
     * @param obj object to print
     */
    private void print(Object obj){
        System.out.print(obj);
    }
    /**
     * Shortcut to the System.out.println() method.
     * @param obj object to print
     */
    private void println(Object obj){
        System.out.println(obj);
    }
}
