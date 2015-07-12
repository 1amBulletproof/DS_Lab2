/**
 * This class computes the determinant of a nxn matrix
 * 
 * @author Tarney
 */
public class MatMath {
    //class variables
    
//    public double computerDet(Matrix2D matrix)
//    {
//        
//    }
//    
    
    /**
     * Create a minor matrix from the original matrix
     * @param matrix    original matrix
     * @param row       row to be removed
     * @param column    column to be removed
     * @return Matrix2D new matrix which is the minor of the original
     */
    public Matrix2D minor(Matrix2D matrix, int row, int column)
    {
        int i = 1;
        int j = 1; //used to iterate through oldmatrix, i = row, j = column
        
       
        Matrix2D minorMatrix = new Matrix2D();
        for (int x = 1; x <= matrix.getNumRows(); x++)
        {
            if (x == row){i++;}//skip the row that coincides with the minor coord.
            for (int y = 1; y <= matrix.getNumCol(); y++)
            {
                if (y == column){j++;}//skip the col. that is same as minor coord.
                minorMatrix.setValue( x, y, matrix.getValue(i, j));
                j++;//go to the next column
            }
            j = 1;//reset column to the be the first value
            i++;//go to the next row
        }
        
        return minorMatrix;
    }
    
}   
