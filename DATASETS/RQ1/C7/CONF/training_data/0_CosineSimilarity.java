
public class CosineSimilarity {
    public static double cosineSimilarity(List<Double> vectorA, List<Double> vectorB) {
        double dotProduct = 0.0;
        double normA = 0.0;
        double normB = 0.0;
        for (int i = 0; i < vectorA.size(); i++) {
            dotProduct += vectorA.get(i) * vectorB.get(i);
            normA += Math.pow(vectorA.get(i), 2);
            normB += Math.pow(vectorB.get(i), 2);
        }
        return dotProduct / (Math.sqrt(normA) * Math.sqrt(normB));
    }

    public static void main(String[] args) {
        List<Double> vectorA = Arrays.asList(1.0, 2.0, 3.0);
        List<Double> vectorB = Arrays.asList(4.0, 5.0, 6.0);
        double similarity = cosineSimilarity(vectorA, vectorB);
        System.out.println("Cosine similarity: " + similarity);
    }
}

