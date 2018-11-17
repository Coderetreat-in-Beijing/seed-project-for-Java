package fx.leyu.code.retreat;

public class Game {
    private static int[][] STATES = {
            {0,0,0,1,0,0,0,0},
            {0,0,1,1,0,0,0,0}};

    public static int[][] run(int[][] matrix, int times) {
        int[][] result = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < times; i++) {
            for (int row = 0; row < matrix.length; row++) {
                for (int col = 0; col < matrix[row].length; col++) {
                    result[row][col] = gainNextState(matrix, row, col);
                }
            }
        }
        return result;
    }

    private static int gainNextState(int[][] matrix, int row, int col) {
        int numOfLiveNeighbour = gainNumOfLiveNeighbour(matrix, row, col);
        return gainNextCellState(matrix[row][col], numOfLiveNeighbour);
    }

    private static int gainNextCellState(int state, int nums) {

        return STATES[state][nums];
    }

    private static int gainNumOfLiveNeighbour(int[][] matrix, int row, int col) {
        int result = 0;
        for (int i = row - 1; i <= row + 1; i++) {
            for (int j = col - 1; j <= col + 1; j++) {
                result += getNeighbours(matrix, i, j);
            }
        }
        result -= matrix[row][col];
        return result;
    }

    private static int getNeighbours(int[][] matrix, int m, int n) {
        int[][] newmatrix = new int[matrix.length+2][matrix[0].length+2];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                newmatrix[i+1][j+1] = matrix[i][j];
            }
        }
        return newmatrix[m+1][n+1];
    }
}
