import java.util.*;

// Question: Evaluate Equation / Division Evaluation
// Given equations like a/b=2, b/c=3, find value of a/c
// Uses graph traversal (BFS/DFS) to find paths between variables

public class Program8 {
    
    public static double[] evaluateDivision(List<List<String>> equations, 
                                            double[] values, 
                                            List<List<String>> queries) {
        Map<String, Map<String, Double>> graph = new HashMap<>();
        
        int n = equations.size();
        for(int i = 0; i < n; i++) {
            String dividend = equations.get(i).get(0);
            String divisor = equations.get(i).get(1);
            double value = values[i];
            
            graph.putIfAbsent(dividend, new HashMap<>());
            graph.putIfAbsent(divisor, new HashMap<>());
            
            graph.get(dividend).put(divisor, value);
            graph.get(divisor).put(dividend, 1.0 / value);
        }
        
        double[] results = new double[queries.size()];
        for(int i = 0; i < queries.size(); i++) {
            String dividend = queries.get(i).get(0);
            String divisor = queries.get(i).get(1);
            
            if(!graph.containsKey(dividend) || !graph.containsKey(divisor)) {
                results[i] = -1.0;
            } else if(dividend.equals(divisor)) {
                results[i] = 1.0;
            } else {
                results[i] = bfsEvaluate(dividend, divisor, graph);
            }
        }
        
        return results;
    }
    
    private static double bfsEvaluate(String start, String end, 
                                      Map<String, Map<String, Double>> graph) {
        Queue<String> queue = new LinkedList<>();
        Map<String, Double> visited = new HashMap<>();
        
        queue.add(start);
        visited.put(start, 1.0);
        
        while(!queue.isEmpty()) {
            String current = queue.poll();
            
            if(current.equals(end)) {
                return visited.get(end);
            }
            
            for(String neighbor : graph.get(current).keySet()) {
                if(!visited.containsKey(neighbor)) {
                    double value = visited.get(current) * graph.get(current).get(neighbor);
                    visited.put(neighbor, value);
                    queue.add(neighbor);
                }
            }
        }
        
        return -1.0;
    }

    public static void main(String[] args) {
        // Test case 1: Basic equations
        List<List<String>> equations1 = Arrays.asList(
            Arrays.asList("a", "b"),
            Arrays.asList("b", "c")
        );
        double[] values1 = {2.0, 3.0};
        List<List<String>> queries1 = Arrays.asList(
            Arrays.asList("a", "c"),
            Arrays.asList("b", "a"),
            Arrays.asList("a", "e"),
            Arrays.asList("a", "a"),
            Arrays.asList("x", "x")
        );
        
        System.out.println("Test 1: a/b=2, b/c=3");
        double[] results1 = evaluateDivision(equations1, values1, queries1);
        System.out.println("a/c = " + results1[0] + " (expected: 6.0)");
        System.out.println("b/a = " + results1[1] + " (expected: 0.5)");
        System.out.println("a/e = " + results1[2] + " (expected: -1.0)");
        System.out.println("a/a = " + results1[3] + " (expected: 1.0)");
        System.out.println("x/x = " + results1[4] + " (expected: -1.0)");
        System.out.println();

        // Test case 2: More complex graph
        List<List<String>> equations2 = Arrays.asList(
            Arrays.asList("x", "y"),
            Arrays.asList("y", "z")
        );
        double[] values2 = {0.5, 2.0};
        List<List<String>> queries2 = Arrays.asList(
            Arrays.asList("x", "z"),
            Arrays.asList("z", "x")
        );
        
        System.out.println("Test 2: x/y=0.5, y/z=2");
        double[] results2 = evaluateDivision(equations2, values2, queries2);
        System.out.println("x/z = " + results2[0] + " (expected: 1.0)");
        System.out.println("z/x = " + results2[1] + " (expected: 1.0)");
    }
}