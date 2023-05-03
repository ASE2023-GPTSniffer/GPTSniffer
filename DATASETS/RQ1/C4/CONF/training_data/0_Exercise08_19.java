public static boolean isConsecutiveFour(int[][] values) {
    int numRows = values.length;
    int numCols = values[0].length;

    
    for (int i = 0; i < numRows; i++) {
        for (int j = 0; j < numCols - 3; j++) {
            if (values[i][j] == values[i][j+1] && 
                values[i][j+1] == values[i][j+2] && 
                values[i][j+2] == values[i][j+3]) {
                return true;
            }
        }
    }

    
    for (int j = 0; j < numCols; j++) {
        for (int i = 0; i < numRows - 3; i++) {
            if (values[i][j] == values[i+1][j] && 
                values[i+1][j] == values[i+2][j] && 
                values[i+2][j] == values[i+3][j]) {
                return true;
            }
        }
    }

    
    for (int i = 0; i < numRows - 3; i++) {
        for (int j = 0; j < numCols - 3; j++) {
            if (values[i][j] == values[i+1][j+1] &&
                values[i+1][j+1] == values[i+2][j+2] &&
                values[i+2][j+2] == values[i+3][j+3]) {
                return true;
            }
            if (values[i][j+3] == values[i+1][j+2] &&
                values[i+1][j+2] == values[i+2][j+1] &&
                values[i+2][j+1] == values[i+3][j]) {
                return true;
            }
        }
    }

    
    return false;
}