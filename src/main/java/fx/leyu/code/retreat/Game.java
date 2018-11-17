package fx.leyu.code.retreat;

public class Game {
    public static int[][] run(int[][] matrix, int times) {
        // TODO
        assert (matrix!=null);
        for(int i = 0; i < times; i++) {
            for(int j=0;j<matrix.length;j++){
                for(int k=0;k<matrix[j].length;k++){
                    matrix[j][k]=shouldLive(matrix,j,k)?1:0;
                }
            }
        }
        return matrix;
    }

    private static boolean shouldLive(int[][] matrix, int j, int k) {
        int numOfLive=numOfLive(matrix,j,k);
        if(matrix[j][k]==1){
            return numOfLive==2||numOfLive==3;
        }else{
            return numOfLive==3;
        }
    }

    private static int numOfLive(int[][] matrix, int j, int k) {
        int numOfLive=0;
        for(int m=j-1;m<=j+1;m++){
            for(int n=k-1;n<=k+1;n++){
                if(m==j&&n==k){
                    continue;
                }
                if(m>=0&&m<matrix.length&&n>=0&&n<matrix[j].length&&matrix[m][n]==1){
                    numOfLive++;
                }
            }
        }
        return numOfLive;
    }

}
