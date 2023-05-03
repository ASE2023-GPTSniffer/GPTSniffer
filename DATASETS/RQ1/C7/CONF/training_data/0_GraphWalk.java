
public class GraphWalk {
    public static void main(String[] args) {
        
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            graph.add(new ArrayList<>());
        }
        graph.get(0).add(1);
        graph.get(0).add(3);
        graph.get(1).add(0);
        graph.get(1).add(2);
        graph.get(1).add(4);
        graph.get(2).add(1);
        graph.get(3).add(0);
        graph.get(4).add(1);

        
        int currentNode = 0;
        System.out.print(currentNode + " ");

        
        Random rand = new Random();
        for (int i = 0; i < 10; i++) {
            
            int nextNode = graph.get(currentNode).get(rand.nextInt(graph.get(currentNode).size()));

            
            currentNode = nextNode;
            System.out.print(currentNode + " ");
        }
    }
}

