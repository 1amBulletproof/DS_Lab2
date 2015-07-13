/**
* This is the Lab2 driver class. 
* <p> This class will implement the main flow of the program as follows:
* read every nxn matrix with File_IO.java 
* store every nxn matrix in Matrix2D.java 
* write every nxn matrix to an output file with File_IO.java & Matrix2D.java
* calculate every nxn matrix determinant in Det.java
* write every nxn matrix determinant to the output file using File_IO.java
* and it will use RuntimeMetric.java to store the program runtime.
* 
* @author Brandon Tarney
* @version 1.0  7/5/15
*/

import java.io.*;
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
        long start = System.nanoTime(); //runtime metrics variable
        long end;                       //runtime metrics variable
        int matrixSize;                 //nxn size of next matrix
        Scanner scanner;                //will scan input strings for individual doubles
        double value;                   //temporary storage for any doubles found in each input line
        Matrix2D matrix;                //main matrix to manipulate
        Matrix2D minorMatrix;           //store a minor matrix for testing
        MatMath matrixCalc = new MatMath();
        double determinant; 
       
        //cautiously initialize File I/O
        try 
        {
            if (args.length != 2)
            {
                 System.out.println("There should be an input file followed by an output file, "
                    + "you gave me something else. Please try again."); 
             } else //good input arguments
             {
                //pass each input to Matrix2D
                File_IO fileIO = new File_IO(args[0], args[1]);              
                
/***********this will all repeat eventually*****************/
                while (fileIO.hasNextLine())
                {
                    scanner = new Scanner(fileIO.getNextLine());

                /******ERROR HANDLING HERE FOR 0 or >1 input*****/
                    matrixSize = scanner.nextInt();
                    matrix = new Matrix2D(matrixSize, matrixSize);

                    int matrixRow = 1;//keeps track of row insert index 
                    int matrixColumn = 1; //keeps track of column insert index

                    for (int i = 1; i <= matrixSize; i++) //loop through lines = sizeOfMatrix
                    {
                        scanner = new Scanner(fileIO.getNextLine());
                        if (scanner.hasNextDouble())
                        {
                            while (scanner.hasNextDouble())
                            {
                                value = scanner.nextDouble();
                                matrix.setValue(matrixRow, matrixColumn, value);
//                                System.out.println(value);
                                matrixColumn++;
                            }
                            matrixRow++;//like hitting "return"
                            matrixColumn = 1;//like hitting "return"
                        }
                    }
/***************************************************************/
            /*****Testing OUtput*******/
                System.out.println("\n\n" + matrix.toString());
                determinant = matrixCalc.det(matrix);
                System.out.println("\nThe Determinant of the matrix is: ");
                System.out.println(determinant);
                }
//                minorMatrix = matrixCalc.minor(matrix, 1, 1);
//                System.out.println(minorMatrix.getValue(1,1) + "\n");
//                System.out.println("\n\n" + minorMatrix.toString());

//
//                fileIO.writeOutput(matrix.toString());
//                //error handling on closing the output file
//                fileIO.closeOutput();
            }
        }
        catch (Exception e)
        {
          System.out.println("There was an input or output file parameter issue");  
        }
       


        //print determinant
        
//        //print output matrix
//        matrix.display();  
//        System.out.println("\n\n" + matrix.toString());
        
  

        
        //runtime metrics
        end = System.nanoTime();
        metrics = new RuntimeMetric(end - start);
        
        //report program status
        System.out.println("\nThe program ran successfully, please check your output file for the results");
        System.out.println("The Program took " + metrics.getRuntime() + " nano seconds");
    }//end of main method

}//end of lab1 class

