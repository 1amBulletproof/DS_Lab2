/**
 * This is a generic 2D matrix interface
 * 
 * @author Brandon Tarney 7/6/2015
 * @version 1.0
 */

public interface Matrix 
{
    /**
     * Tests whether the matrix is square
     * @return true if the matrix is square
     */
    public boolean isSquare ();
    
    /**
     * Stores a value in the matrix
     * @param x row location to set value
     * @param y column location to set value
     * @param value the value to store in the matrix
     */
    public void setValue (int x, int y, double value);
    
    /**
     * Retrieves a value in the matrix
     * @param x row location to retrieve value
     * @param y column location to retrieve value
     * @return  the value retrieved in the matrix
     */
    public double getValue(int x, int y);
    
    /**
     * Retrieves the # of rows in use
     * @return  the # of rows
     */
    public int getNumRows();
    
    /**
     * Retrieves the # of columns in use
     * @return  the # of columns
     */
    public int getNumCol();
    
    
    /**
     * returns string representation of matrix 
     * @return string representation of matrix
     */
    @Override
    public String toString();
    
    
}
