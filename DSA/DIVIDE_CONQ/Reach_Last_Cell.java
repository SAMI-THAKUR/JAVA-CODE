package DSA.DIVIDE_CONQ;



class RLC{
    int [][] matrix ;
    RLC(int [][] matrix){
        this.matrix = matrix;
    }

    public int soln(int i , int j, int [][] matrix){
        if(i==matrix.length-1 && j==matrix[0].length-1) {
            return matrix[i][j];
        }
        int right = Integer.MAX_VALUE;
        int down = Integer.MAX_VALUE;
        if(j!= matrix[0].length-1){
            right = matrix[i][j] + soln(i,j+1 , matrix);
        }
        if(i!= matrix.length-1){
            down = matrix[i][j] +  soln(i+1, j, matrix);
        }
        return Math.min(right,down);
    }

    public void minimum_cost(){
        int ans = soln(0,0,matrix);
        System.out.println("Minimum is: " + ans);
    }
}
public class Reach_Last_Cell {
    public static void main(String[] args) {
        int[][] matrix  = {{4,7,8,6,4},
                           {6,7,3,9,2},
                           {3,8,1,2,4},
                           {7,1,7,3,7},
                           {2,9,8,9,3}};
        RLC rlc = new RLC(matrix);
        rlc.minimum_cost();

    }
}
