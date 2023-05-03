import java.util.*;

public class CardGame {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] numbers = new int[4];
        
        
        System.out.print("Enter four numbers between 1 and 13: ");
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = input.nextInt();
        }
        
        
        String solution = findSolution(numbers);
        
        
        System.out.println(solution);
    }
    
    public static String findSolution(int[] numbers) {
        List<String> operators = Arrays.asList("+", "-", "*", "/");
        List<List<String>> permutations = generatePermutations(operators, 3);
        
        
        for (int a : numbers) {
            for (int b : numbers) {
                if (b == a) continue;
                for (int c : numbers) {
                    if (c == a || c == b) continue;
                    for (int d : numbers) {
                        if (d == a || d == b || d == c) continue;
                        for (List<String> ops : permutations) {
                            double result = evaluateExpression(a, b, c, d, ops);
                            if (result == 24) {
                                return formatSolution(a, b, c, d, ops);
                            }
                        }
                    }
                }
            }
        }
        
        
        return "No solution";
    }
    
    public static List<List<String>> generatePermutations(List<String> items, int length) {
        List<List<String>> result = new ArrayList<>();
        if (length == 1) {
            for (String item : items) {
                result.add(Arrays.asList(item));
            }
        } else {
            for (String item : items) {
                List<String> rest = new ArrayList<>(items);
                rest.remove(item);
                for (List<String> permutation : generatePermutations(rest, length - 1)) {
                    List<String> newPermutation = new ArrayList<>();
                    newPermutation.add(item);
                    newPermutation.addAll(permutation);
                    result.add(newPermutation);
                }
            }
        }
        return result;
    }
    
    public static double evaluateExpression(int a, int b, int c, int d, List<String> ops) {
        String expression = String.format("%d %s %d %s %d %s %d", a, ops.get(0), b, ops.get(1), c, ops.get(2), d);
        return evaluateExpression(expression);
    }