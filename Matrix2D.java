/**
 * This will be a custom ADT wrapper on a basic 2d matrix
 * <p> the purpose of this ADT is to have a generic accessor and setter wrapper
 * on matrix so that the implementation can be changed without changing the interface
 * NOTE: I have made this a 1-based (NOT 0-based) matrix</p>
 * 
 * @author Brandon Tarney   7/5/2015
 * @version 1.0
 */


public class Matrix2D implements Matrix{
    private double[][] matrix;
    private int sizeX;//# of rows in use
    private int sizeY;//# of columns in use
    private double unused = -9999.99;
    private String strOutput = ""; //used for the display method 
    
    /**
     * Class constructor: creates an empty 2d matrix
     * the matrix is 1-based 10x10 by default 
     */
    public Matrix2D ()
    {
        matrix = new double[11][11];
        for (int i = 0; i < 11; i++)
        {
            for (int j = 0; j < 11; j++)
            { 
                matrix[i][j] = unused;//value represents un-set array index 
            }
        }
        sizeX = 0;
        sizeY = 0;
        
    }
    
    /**
     * Class constructor: creates an empty 2d matrix
     * @param x sets the matrix row size
     * @param y sets the matrix row size
     */
    public Matrix2D (int x, int y)
    {
        matrix = new double[x][y];
        for (int i = 0; i < x+1; i++)
        {
            for (int j = 0; j <= y+1; j++)
            { 
                matrix[i][j] = unused;//value represents un-set array index 
            }
        }        
        sizeX = 0;
        sizeY = 0;
    }
    
    /**
     * Tests whether the matrix is square
     * @return true if the matrix is square
     */
    @Override
    public boolean isSquare ()
    {
        return sizeX == sizeY; 
    }
    
    /**
     * Stores a value in the matrix
     * @param x row location to set value
     * @param y column location to set value
     * @param value the value to store in the matrix
     */
    @Override
    public void setValue(int x, int y, double value)
    {
        matrix[x][y] = value;
        if (x > sizeX){sizeX = x;}
        if (y > sizeY){sizeY = y;}  
    }
    
    /**
     * Retrieves a value in the matrix
     * @param x row location to retrieve value
     * @param y column location to retrieve value
     * @return  the value retrieved in the matrix
     */
    @Override
    public double getValue(int x, int y)
    {
        return matrix[x][y];
    }
    
    /**
     * Retrieves the # of rows in use
     * @return  the # of rows
     */
    @Override
    public int getNumRows()
    {
        return sizeX;
    }
    
    /**
     * Retrieves the # of columns in use
     * @return  the # of columns
     */
    @Override
    public int getNumCol()
    {
        return sizeY;
    }    
    
    /**
     * Prints matrix to console
     */
    public void display()
    {
        String output = "";
        for (int i = 1; i <= sizeX; i++)
        {
            for (int j = 1; j <= sizeY; j++)
            { 
                if (getValue(i,j) != unused)
                {
                    output += String.valueOf(getValue(i,j));
                    output += " ";
                }
            }
            System.out.println(output);
            output = "";
            
        }
    }
   
    /**
     * returns string representation of matrix 
     * @return string representation of matrix
     */
    @Override
    public String toString()
    {
        strOutput = "";
        for (int i = 1; i <= sizeX; i++)
        {
            for (int j = 1; j <= sizeY; j++)
            { 
                if (getValue(i,j) != unused)
                {
                    strOutput += String.valueOf(getValue(i,j));
                    strOutput += " ";
                }
            }
            strOutput += "\n";
            
        }
        return strOutput;
    }    
    
}//end of Matrix2D class
