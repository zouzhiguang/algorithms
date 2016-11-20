package com.interview.crackcode;

import java.util.Set;

public class SpreadSheetResolver implements SpreadSheetProblem {

    public class Cell{
        public int row, column;
        public String value;

        public Cell(int row, int column, String value) {
            this.row = row;
            this.column = column;
            this.value = value;
        }
    }

    @Override
    public boolean canResolve(String[][] spreadsheet) {
        if(spreadsheet == null || spreadsheet.length <= 0 || spreadsheet[0].length <= 0) return true;
        int m = spreadsheet.length, n = spreadsheet[0].length;
        boolean[][] visited = new boolean[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(visited[i][j]) continue;
                String expression = spreadsheet[i][j].trim();
                if(isValue(expression)){
                    visited[i][j] = true;
                    continue;
                }

                boolean[][] dependencies = new boolean[m][n];
                for(String cell : expression.split("[\\s\\+\\-\\*\\\\]")){
                    if(cell == null || cell.isEmpty()){
                        continue;
                    }

                    if(isComplexExpression(cell)){

                        if(!addDependencies(cell, visited, dependencies)){
                            return false;
                        }
                    }
                }
            }
        }

        return true;
    }

    @Override
    public int[][] resolve(String[][] spreadsheet) throws IllegalArgumentException {
        return new int[0][];
    }


    private boolean isValue(String s) {
        return !(s == null || s.isEmpty()) && s.chars().allMatch(Character::isDigit);
    }

    // exact match B3~5, row number should be index based.
    private boolean isComplexExpression(String s) {
        return s != null && s.length() == 4 && Character.isUpperCase(s.charAt(0)) && Character.isDigit(s.charAt(1)) && s.charAt(2) == '~' && Character.isUpperCase(s.charAt(3));
    }

    // if there is cyclic dependencies, return false.
    private boolean addDependencies(String s, boolean[][] visited, boolean[][] dependencies){

        int m =  s.charAt(0) - 'A';
        for(int i = s.charAt(1) - '0'; i < s.charAt(3) - '0'; i++){
            if(visited[m][i]) continue;
            if(dependencies[m][i]) return false;
            dependencies[m][i] = true;
        }
        return true;
    }

    private void resolveSingle(Cell cell, boolean[][] visited, Set<Cell> dependencies){
        
    }

}
