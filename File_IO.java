/**
 * Provides data structure and methods for String File input & output
 * @author Brandon Tarney
 * @version 1.0 6/16/15
 */
import java.io.*;
import java.util.*;

public class File_IO {
    
    private String input = new String();
    private String output = new String();
    private File inputFile;
    private File outputFile;
    private Scanner inputScanner;
    private PrintWriter printer;
    
    
    /**
     * Constructor method for File_IO class
     * <p> Opens two files (1 for input, 1 for output)</p>
     * 
     * @param file_in   name of input file to open
     * @param file_out  name of output file to open
     */
    public File_IO(String file_in, String file_out)
    {
        inputFile = new File(file_in);
        outputFile = new File(file_out);   
        //Error handling: in case there is no inputfile
        try
        {
            inputScanner = new Scanner(inputFile);
            printer = new PrintWriter(outputFile);
        } catch (Exception e)
        {
                System.out.println("There was a problem with the input or output parameters, please try again");
        }
    }
    
    /**
     * Tests for next line
     * @return boolean true if there is a next line
     */
    public boolean hasNextLine()
    {
        return inputScanner.hasNextLine();
    }

    /**
     * Returns the next input value as a double in the input file
     * 
     * @return  next line in the input as a String
     */
    public String getNextLine()
    {
        if (hasNextLine())
        {
            input = inputScanner.nextLine();
            return input;
        } else {return null;}           
    }
    
    
    /**
     * Writes a line to the output file
     * 
     * @param output    what to write to the output file (a string value)
     */
    public void write_Output(String output)
    {
        printer.println(output);
    }
   
    
    /**
     * Closes the output file
     */
    public void close_Output()
    {
        printer.close();
    }
    
    
}// end class File_IO
