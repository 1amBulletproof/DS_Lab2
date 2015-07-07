/*
 *  $Id:  RuntimeMetric.java $
 *
 *  Copyright 2011, The Johns Hopkins University Whiting School of Engineering
 *      All rights reserved.
 *      This material may be used, modified and reproduced by faculty,
 *      staff, and students of The Johns Hopkins University for instruction, 
 *      evaluation, and grading purposes.  For any other permission, please 
 *      contact The Johns Hopkins University Whiting School of Engineering.
 */

/**
 *  Provides a matched set to determine Big-O runtime metrics.
 * <p> This is a modified version of the distributed code given for 605.202.</p>
 * 
 *  @version    2.0     2011-06-15
 *  @author     Brandon Tarney
 */
public class RuntimeMetric {

    private long runtime;
    
    /**
     *  A single constructor is used to create each metric.  The metric
     *  cannot be changed after creation.
     * 
     *  @param t The time it took to solve the problem.
     */
    public RuntimeMetric (long t) 
    {
        runtime = t;
    }

    /**
     *  Fetches the time it took to solve the problem.
     * 
     *  @return The time measured in nanoseconds.
     */
    public long getRuntime() {
        return runtime;
    }
    

}
