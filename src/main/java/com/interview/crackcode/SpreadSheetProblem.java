package com.interview.crackcode;

/**
 * SpreadSheet related problems.
 * SpreadSheet may be filled with int values or simple expressions.
 *
 * Simple Expression is defined as:
 * 1> only +, -, maybe included in the expression.
 * 2> no parentheses
 * 3> B3~5 means all cells in B column from line 3 to 5. Which are B3, B4 and B5
 *
 * Given this and try to determine whether or not the spreadsheet can be resolved
 * And, try to resolve all cells to int values, if can not, an Exception should be thrown.
 * eg:
 * <p>
 *        A           B          C         D         E
 * ---------------------------------------------------------
 * 1  |  12          C2+4       D4-A2      4        A4
 * 2  |  B3~5+C2     45         C1         A1       9
 * 3  |   ..         ..         ..         ..       ..
 * 4  |   ..         ..         ..         ..       ..
 */
public interface SpreadSheetProblem {

    /**
     * Tell if a spreadsheet can be resolved for all cells.
     *
     * @param spreadsheet 2-dimensional string array which denotes the spreadsheet
     * @return whether or not the spreadsheet can be resolved.
     */
    boolean canResolve(String[][] spreadsheet);

    /**
     * Resolve the given spreadsheet cells all into int values.
     * @param spreadsheet 2-dimensional string array which denotes the spreadsheet
     * @return int 2-D array for all cell values
     * @throws IllegalArgumentException when it can not be resolved.
     */
    int[][] resolve(String[][] spreadsheet) throws IllegalArgumentException;
}
