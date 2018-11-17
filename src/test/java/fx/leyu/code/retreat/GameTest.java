package fx.leyu.code.retreat;

import org.junit.Assert;
import org.junit.Test;

public class GameTest {

    @Test
    public void testRun01() {
        int[][] matrix = new int[3][3];
        matrix[0][2] = 1;
        matrix[1][1] = 1;
        matrix = Game.run(matrix, 1);

        assertMatrix(new int[3][3], matrix);
    }

    @Test
    public void testRun02() {
        int[][] matrix = {{1,0,1},{0,1,0},{1,0,1}};
        matrix = Game.run(matrix, 1);
        int[][] expected = {{0,1,0},{1,0,1},{0,1,0}};
        assertMatrix(expected, matrix);
    }

    @Test
    public void testRun03() {
        int[][] matrix = {{0,0,1},{0,0,0},{1,0,1}};
        matrix = Game.run(matrix, 1);
        int[][] expected = {{0,0,0},{0,1,0},{0,0,0}};
        assertMatrix(expected, matrix);
    }

    @Test
    public void testRun04() {
        int[][] matrix = {{1,0,1},{0,0,0},{0,0,1}};
        matrix = Game.run(matrix, 1);
        int[][] expected = {{0,0,0},{0,1,0},{0,0,0}};
        assertMatrix(expected, matrix);
    }

    private void assertMatrix(int[][] expected, int[][] matrix) {
        for (int i = 0; i < expected.length; i++) {
            Assert.assertArrayEquals(expected[i], matrix[i]);
        }
    }
}
