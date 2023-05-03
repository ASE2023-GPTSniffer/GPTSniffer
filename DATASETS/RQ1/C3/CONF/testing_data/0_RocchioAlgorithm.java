import java.util.ArrayList;
import java.util.List;

public class Rocchio {
    private static final double ALPHA = 1;
    private static final double BETA = 0.75;
    private static final double GAMMA = 0.15;

    public static List<Double> rocchio(List<List<Double>> relevantDocs, List<List<Double>> nonRelevantDocs, List<Double> query) {
        List<Double> centroidRelevant = new ArrayList<>();
        List<Double> centroidNonRelevant = new ArrayList<>();

        // calculate centroid of relevant docs
        for (int i = 0; i < relevantDocs.get(0).size(); i++) {
            double sum = 0;
            for (List<Double> doc : relevantDocs) {
                sum += doc.get(i);
            }
            centroidRelevant.add(sum / relevantDocs.size());
        }

        // calculate centroid of non-relevant docs
        for (int i = 0; i < nonRelevantDocs.get(0).size(); i++) {
            double sum = 0;
            for (List<Double> doc : nonRelevantDocs) {
                sum += doc.get(i);
            }
            centroidNonRelevant.add(sum / nonRelevantDocs.size());
        }

        // modify query
        for (int i = 0; i < query.size(); i++) {
            query.set(i, query.get(i) * ALPHA + centroidRelevant.get(i) * BETA - centroidNonRelevant.get(i) * GAMMA);
        }

        return query;
    }

    public static void main(String[] args) {
        List<List<Double>> relevantDocs = new ArrayList<>();
        relevantDocs.add(List.of(1.0, 2.0, 3.0));
        relevantDocs.add(List.of(2.0, 3.0, 4.0));
        relevantDocs.add(List.of(3.0, 4.0, 5.0));

        List<List<Double>> nonRelevantDocs = new ArrayList<>();
        nonRelevantDocs.add(List.of(4.0, 5.0, 6.0));
        nonRelevantDocs.add(List.of(5.0, 6.0, 7.0));
        nonRelevantDocs.add(List.of(6.0, 7.0, 8.0));

        List<Double> query = List.of(1.0, 1.0, 1.0);

        System.out.println(rocchio(relevantDocs, nonRelevantDocs, query));
    }
}

