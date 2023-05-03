
public class CountOccurrenceOfWords {
    public static void main(String[] args) {
        
        String text = "Good morning. Have a good class. " +
                "Have a good visit. Have fun!";

        
        Map<String, Integer> map = new TreeMap<>();

        String[] words = text.split("[\\s+\\p{P}]");
        for (String word : words) {
            String key = word.toLowerCase();

            if (key.length() > 0) {
                if (!map.containsKey(key)) {
                    map.put(key, 1);
                } else {
                    int value = map.get(key);
                    value++;
                    map.put(key, value);
                }
            }
        }

        
        List<WordOccurrence> list = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            list.add(new WordOccurrence(entry.getKey(), entry.getValue()));
        }

        
        Collections.sort(list);

        
        for (WordOccurrence wo : list) {
            System.out.println(wo.getWord() + " " + wo.getCount());
        }
    }
}

class WordOccurrence implements Comparable<WordOccurrence> {
    private String word;
    private int count;

    public WordOccurrence(String word, int count) {
        this.word = word;
        this.count = count;
    }

    public String getWord() {
        return word;
    }

    public int getCount() {
        return count;
    }

    @Override
    public int compareTo(WordOccurrence o) {
        if (count > o.count) {
            return 1;
        } else if (count < o.count) {
            return -1;
        } else {
            return 0;
        }
    }
}
