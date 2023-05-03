import java.util.Arrays;

public class ClosestPair {
    
    public static Pair getClosestPair(double[][] points) {
        Arrays.sort(points, (a, b) -> Double.compare(a[0], b[0])); 
        return getClosestPair(points, 0, points.length - 1);
    }
    
    private static Pair getClosestPair(double[][] points, int low, int high) {
        if (low >= high) { 
            return low == high ? null : new Pair(points[low], points[high]);
        }
        
        int mid = (low + high) / 2;
        Pair leftPair = getClosestPair(points, low, mid);
        Pair rightPair = getClosestPair(points, mid + 1, high);
        Pair minPair = (leftPair == null) ? rightPair
                : (rightPair == null) ? leftPair
                : (leftPair.getDistance() < rightPair.getDistance()) ? leftPair : rightPair;
        
        
        double midX = points[mid][0];
        double[] strip = new double[high - low + 1];
        int j = 0;
        for (int i = low; i <= high; i++) {
            if (Math.abs(points[i][0] - midX) < minPair.getDistance()) {
                strip[j++] = points[i][1];
            }
        }
        Arrays.sort(strip, 0, j);
        for (int i = 0; i < j; i++) {
            for (int k = i + 1; k < j && strip[k] - strip[i] < minPair.getDistance(); k++) {
                double[] p1 = {midX, strip[i]};
                double[] p2 = {midX, strip[k]};
                Pair crossPair = new Pair(p1, p2);
                if (crossPair.getDistance() < minPair.getDistance()) {
                    minPair = crossPair;
                }
            }
        }
        
        return minPair;
    }
    
    public static void main(String[] args) {
        double[][] points = {{2, 3}, {12, 30}, {40, 50}, {5, 1}, {12, 10}, {3, 4}};
        Pair closestPair = getClosestPair(points);
        System.out.println("The closest pair of points are " + Arrays.toString(closestPair.getP1()) 
                + " and " + Arrays.toString(closestPair.getP2()) + " with distance " + closestPair.getDistance());
    }
}

class Pair {
    private double[] p1;
    private double[] p2;
    
    public Pair(double[] p1, double[] p2) {
        this.p1 = p1;
        this.p2 = p2;
    }
    
    public double[] getP1() {
        return p1;
    }
    
    public double[] getP2() {
        return p2;
    }
    
    public double getDistance() {
        double dx = p1[0] - p2[0];
        double dy = p1[1] - p2[1];
        return Math.sqrt(dx * dx + dy * dy);
    }
}