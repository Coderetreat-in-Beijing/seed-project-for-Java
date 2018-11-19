package fx.leyu.code.retreat;

public class Game {
    private static final int[][] STATES = {
            {0,0,0,1,0,0,0,0}, // 0
            {0,0,1,1,0,0,0,0}  // 1
    };
    private final int[][] matrix;
    private final int[][] broad;

    public Game(int[][] matrix) {
        this.matrix = matrix;
        broad = new int[matrix.length + 2][matrix[0].length + 2];
        initBroad();
    }

    private void initBroad() {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                broad[i + 1][j + 1] = matrix[i][j];
            }
        }
    }

    public int[][] run(int times) {
        int[][] result = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < times; i++) {
            runOneTime(result);
        }
        return result;
    }

    private void runOneTime(int[][] result) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                result[row][col] = gainNextState(matrix, row, col);
            }
        }
    }

    private int gainNextState(int[][] matrix, int row, int col) {
        int numOfLiveNeighbour = gainNumOfLiveNeighbour(matrix, row, col);
        return gainNextCellState(matrix[row][col], numOfLiveNeighbour);
    }

    private int gainNextCellState(int state, int nums) {
        return STATES[state][nums];
    }

    private int gainNumOfLiveNeighbour(int[][] matrix, int row, int col) {
        int result = 0;
        for (int i = row - 1; i <= row + 1; i++)
            for (int j = col - 1; j <= col + 1; j++)
                result += broad[i+1][j+1];
        return result - matrix[row][col];
    }
}
