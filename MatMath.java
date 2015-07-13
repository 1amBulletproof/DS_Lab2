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
     * Calculate the determinant of a matrix recursively
     * @param matrix    matrix to calculate determinant 
     * @return value of the determinant 
     */
    public double det(Matrix2D matrix)
    {
        double detSum = 0; 
        final int columnNum = 1;
        final double exponentBase = -1;

        //base case: the matrix is 1x1 (assuming square) & det(matrix[x]) = x
        if (matrix.getNumRows() == 1){return matrix.getValue(1,1);}
        
        //recursively solve for each minor matrix determinant
        else
        {
            //choosing Column 1 to check all values (so vary all of the rows)
            for (int rowNum = 1; rowNum <= matrix.getNumRows(); rowNum++ )
            {
                 detSum += (Math.pow(exponentBase, ((double)columnNum + (double)rowNum)) * matrix.getValue(rowNum, columnNum)) * det(minor(matrix, rowNum, columnNum));
            }
            return detSum;
        }
           
    }    
    
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
        if (matrix.isSquare() && matrix.getNumCol() == 1)
        {
            System.out.println("There is no minor, you have a 1x1 matrix");
        }
        else
        {
            for (int x = 1; x < matrix.getNumRows(); x++) //make sure new matrix has 1 fewer rows
            {
                if (x == row){i++;}//skip the row that coincides with the minor coord.
                for (int y = 1; y < matrix.getNumCol(); y++)//make sure new matrix has 1 fewer col
                {
                    if (y == column){j++;}//skip the col. that is same as minor coord.
                    minorMatrix.setValue( x, y, matrix.getValue(i, j));
                    j++;//go to the next column
                }
                j = 1;//reset column to the be the first value
                i++;//go to the next row
            }
        }
        
        return minorMatrix;
    }
    
}   
