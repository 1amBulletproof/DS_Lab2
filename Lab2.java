/**
* This is the Lab2 driver class. 
* <p> This class will implement the main flow of the program as follows:
* read all input with File_IO.java 
* store every nxn matrix in Matrix2D.java 
* calculate every nxn matrix determinant in MatMath.java
* write every nxn matrix to an output file with File_IO.java & Matrix2D.java
* write every nxn matrix determinant to the output file using File_IO.java
* and it will use RuntimeMetric.java to store the program runtime.
* 
* @author Brandon Tarney
* @version 1.0  7/5/15
*/

import java.util.*;

public class Lab2 
{
    static RuntimeMetric metrics;

    
   /**
    * Main program which will drive lab2.
    * <p> Grab input from the input file,
    * store the matrix, calculate determinant,
    * output the results to an output file.</p>
    * 
    * @param args   1D array: args[0] = inputfile, args[1] = outputfile] 
    */
   public static void main(String [] args)
    {
        //initial declarations
        long start = System.nanoTime(); //runtime metrics variable
        long end;                       //runtime metrics variable
        int matrixSize;                 //nxn size of next matrix
        Scanner scanner;                //will scan input strings for individual doubles
        double value;                   //temporary storage for any doubles found in each input line
        Matrix2D matrix;                //main matrix to manipulate
        MatMath matrixCalc = new MatMath();
        double determinant;             //final determinant value
        String errorMsg;
        
        //Main Driving Algorithm
        if (args.length != 2)               //Error Handling for < or > 2 file arguments
        {
            errorMsg = "There should be an input file followed by an output file, "
                + "you gave me something else. Please try again.";
            System.out.println(errorMsg); 
        } else                              //good input arguments
        {
            try                             //cautiously initialize File I/O
            {
                File_IO fileIO = new File_IO(args[0], args[1]);              
                while (fileIO.hasNextLine())    //proceed through whole file
                {
                    scanner = new Scanner(fileIO.getNextLine());//scanner of each line input
                    if (scanner.hasNextInt()){matrixSize = scanner.nextInt();}
                    else
                    {
                        errorMsg = "There was an error in your input.txt file: "
                                + "EMPTY LINE. "
                                + "Please check the input file";
                        System.out.println(errorMsg);
                        fileIO.writeOutput(errorMsg);
                        break; 
                    }
                    if (scanner.hasNext())      //ERROR HANDLING HERE FOR 0 or >1 matrix size
                    {
                        errorMsg = "There was an error in your input.txt file: "
                                + "too many arguments given for matrix size (should be only 1)."
                                + "Please check the input file";
                        System.out.println(errorMsg);
                        fileIO.writeOutput(errorMsg);
                        break;
                    }
                    else                            //Create the matrix
                    {
                        matrix = new Matrix2D();

                        int matrixRow = 1;          //keeps track of row insert index 
                        int matrixColumn = 1;       //keeps track of column insert index

                        for (int i = 1; i <= matrixSize; i++) 
                        {
                            scanner = new Scanner(fileIO.getNextLine());//scanner of each line input
                            if (scanner.hasNextDouble())
                            {
                                while (scanner.hasNextDouble())
                                {
                                    value = scanner.nextDouble();
                                    matrix.setValue(matrixRow, matrixColumn, value);
                                    matrixColumn++;
                                }
                                matrixRow++;        //like line feed
                                matrixColumn = 1;   //like Carriage Return
                            }
                        }//matrix created
                        if (matrix.isSquare())      //checks every row equal size & totalRow == totalCol
                        {
                            determinant = matrixCalc.det(matrix);
                            fileIO.writeOutput(matrix.toString());
                            fileIO.writeOutput("The Determinant of the matrix is: " + String.valueOf(determinant));
                            fileIO.writeOutput("\n\n"); 
                        }
                        else
                        {
                            errorMsg = "\n\nMatrix was not square! Please check your input\n\n";
                            fileIO.writeOutput(errorMsg);
                        }
                    }
                }
                fileIO.closeOutput();
            }//end try
            catch (Exception e)//this exception should be generated for the fileIO input
            {
                System.out.println(e);
                System.out.println("There was an input or output file parameter issue");  
            }//end catch
        }//end if/else
        
        //runtime metrics
        end = System.nanoTime();                    
        metrics = new RuntimeMetric(end - start);
        
        //report program status
        System.out.println("\nThe program has completed, please check your output file for the results");
        System.out.println("The Program took " + metrics.getRuntime() + " nano seconds");
    }//end of main method

}//end of lab2 class

