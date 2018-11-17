package fx.leyu.code.retreat;

import org.junit.Assert;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class GameTest {
    @Test
    public void testRun() {
        int[][] matrix = new int[3][3];
        matrix[0][2] = 1;

        matrix = Game.run(matrix, 1);
        assertMatrix(new int[3][3], matrix);
    }

    private void assertMatrix(int[][] expected, int[][] matrix) {
        for (int i = 0; i < expected.length; i++) {
            Assert.assertArrayEquals(expected[i], matrix[i]);
        }
    }
}
