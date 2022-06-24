import java.util.*;

class Solution {
    public void setZeroes(int[][] matrix) {
        
        HashSet<Integer> zeroRows = new HashSet<>();
        HashSet<Integer> zeroCols = new HashSet<>();

        for(int i = 0; i < matrix.length; ++i) {
            for(int j = 0; j < matrix[i].length; ++j) {
                if(matrix[i][j] == 0) {
                    if(!zeroRows.contains(i)) {
                        zeroRows.add(i);
                    }
                    if(!zeroCols.contains(j)) {
                        zeroCols.add(j);
                    }
                }
            }
        }

        for(int i = 0; i < matrix.length; ++i) {
            for(int j = 0; j < matrix[i].length; ++j) {
                if(zeroRows.contains(i) && zeroCols.contains(j)) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}