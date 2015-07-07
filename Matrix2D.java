/**
 * This will be a custom ADT wrapper on a basic 2d matrix
 * <p> the purpose of this ADT is to have a generic accessor and setter wrapper
 * on matrix so that the implementation can be changed without changing the interface </p>
 * 
 * @author Brandon Tarney   7/5/2015
 * @version 1.0
 */

/**
 *
 * @author Tarney
 */
public class Matrix2D {
    private double[][] matrix;
    private int sizeX;//# of rows
    private int sizeY;//# of columns
    private double unused = -9999.99;
    private String output = ""; //used for the display method 
    
    /**
     * Class constructor: creates an empty 2d matrix
     * the matrix is 10x10 by default
     */
    public Matrix2D ()
    {
        matrix = new double[10][10];
        for (int i = 0; i < 10; i++)
        {
            for (int j = 0; j < 10; j++)
            { 
                matrix[i][j] = unused;//value represents un-set array index 
            }
        }
        sizeX = 10;
        sizeY = 10;
    }
    
    /**
     * Class constructor: creates an empty 2d matrix
     * @param x sets the matrix row size
     * @param y sets the matrix row size
     */
    public Matrix2D (int x, int y)
    {
        matrix = new double[x][y];
        for (int i = 0; i < x; i++)
        {
            for (int j = 0; j < y; j++)
            { 
                matrix[i][j] = unused;//value represents un-set array index 
            }
        }        
        sizeX = x;
        sizeY = y;
    }
    
    /**
     * Stores a value in the matrix
     * @param x row location to set value
     * @param y column location to set value
     * @param value the value to store in the matrix
     */
    public void setValue(int x, int y, double value)
    {
        matrix[x][y] = value;
    }
    
    /**
     * Retrieves a value in the matrix
     * @param x row location to retrieve value
     * @param y column location to retrieve value
     * @return  the value retrieved in the matrix
     */
    public double getValue(int x, int y)
    {
        return matrix[x][y];
    }
    
    /**
     * Prints matrix to console
     */
    public void display()
    {
        for (int i = 0; i < sizeX; i++)
        {
            for (int j = 0; j < sizeY; j++)
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
}
