
/**
 * Write a description of class MatrixOps here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Matrix
{
    int[][] matrix;
    //int[][] i = new int[][] {{1,2,2,25},{2,1,3,37},{1,3,2,37}};
    public Matrix(int[][] inMatrix){
        matrix = inMatrix;
    }

    public String toString(){
        StringBuilder stringMatrix = new StringBuilder("");;
        for(int i = 0; i < matrix.length; i++){
            stringMatrix.append("|");
            for(int j = 0; j < matrix[i].length; j++){
                stringMatrix.append(" " + matrix[i][j]);
            }
            stringMatrix.append(" |\n");
        }
        System.out.println(stringMatrix);
        return stringMatrix.toString();
    }
    
    public Matrix echelon(){
        
        int[][] i = new int[][] { {1,2}, {3,4} };;
        return new Matrix(i);
    }
}
