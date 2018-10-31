package knightsjourney;

public class Test {
    private static int N = 8;

    /* A utility function to check if i,j are
    valid indexes for N*N chessboard */
    private static boolean isSafe(int x, int y, int sol[][]) {
        return (x >= 0 && x < N && y >= 0 && y < N && sol[x][y] == -1);
    }

    /* A utility function to print solution
    matrix sol[N][N] */
    private static void printSolution(int sol[][]) {
        for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++)
                System.out.print(sol[x][y] + " ");
            System.out.println();
        }
    }

    /* This function solves the Knight Tour problem
    using Backtracking. This function mainly
    uses solveKTUtil() to solve the problem. It
    returns false if no complete tour is possible,
    otherwise return true and prints the tour.
    Please note that there may be more than one
    solutions, this function prints one of the
    feasible solutions. */
    private static void solveKT() {
        int sol[][] = new int[8][8];

        /* Initialization of solution matrix */
        for (int col = 0; col < N; col++)
            for (int row = 0; row < N; row++)
                sol[col][row] = -1;

	/* rowMove[] and colMove[] define next move of Knight.
		rowMove[] is for next value of row coordinate
		colMove[] is for next value of col coordinate */
        int rowMove[] = {2, 1, -1, -2, -2, -1,  1,  2};
        int colMove[] = {1, 2,  2,  1, -1, -2, -2, -1};

        // Since the Knight is initially at the first block
        sol[0][0] = 0;

		/* Start from 0,0 and explore all tours using
		solveKTUtil() */
        if (!solveKTUtil(0, 0, 1, sol, rowMove, colMove)) {
            System.out.println("Solution does not exist");
        } else
            printSolution(sol);
    }

    /* A recursive utility function to solve Knight
    Tour problem */
    private static boolean solveKTUtil(int col, int row, int movei,
                                       int sol[][], int rowMove[],
                                       int colMove[]) {
        int k, nextCol, nextRow;
        if (movei == N * N)
            return true;
		/* Try all next moves from the current coordinate
			row, col */
        for (k = 0; k < 8; k++) {
            nextCol = col + rowMove[k];
            nextRow = row + colMove[k];
            if (isSafe(nextCol, nextRow, sol)) {
                sol[nextCol][nextRow] = movei;
                if (solveKTUtil(nextCol, nextRow, movei + 1, sol, rowMove, colMove))
                    return true;
                else
                    sol[nextCol][nextRow] = -1;// backtracking
            }
        }

        return false;
    }

    /* Driver program to test above functions */
    public static void main(String args[]) {
        solveKT();
    }
}
