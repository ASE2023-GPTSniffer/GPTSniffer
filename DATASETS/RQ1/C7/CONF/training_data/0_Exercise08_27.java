public static double[][] sortColumns(double[][] m) {
    double[][] sortedM = new double[m.length][m[0].length];
    
    
    for (int i = 0; i < m.length; i++) {
        for (int j = 0; j < m[0].length; j++) {
            sortedM[i][j] = m[i][j];
        }
    }
    
    
    for (int j = 0; j < sortedM[0].length; j++) {
        for (int i = 0; i < sortedM.length - 1; i++) {
            double min = sortedM[i][j];
            int minIndex = i;
            
            for (int k = i + 1; k < sortedM.length; k++) {
                if (sortedM[k][j] < min) {
                    min = sortedM[k][j];
                    minIndex = k;
                }
            }
            
            if (minIndex != i) {
                for (int k = 0; k < sortedM[0].length; k++) {
                    double temp = sortedM[i][k];
                    sortedM[i][k] = sortedM[minIndex][k];
                    sortedM[minIndex][k] = temp;
                }
            }
        }
    }
    
    return sortedM;
}
