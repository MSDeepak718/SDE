import java.util.*;

// Question: Shipping Cost Calculation
// 1. Given input like "US,UK,UPS,5:US,CA,FedEx,3:CA,UK,DHL,7"
//    find the cost to ship from X to Y
// 2. Find the minimum cost using intermediate steps (shortest path)

public class Program4 {
    
    static class Node {
        String location;
        int distance;
        
        Node(String location, int distance) {
            this.location = location;
            this.distance = distance;
        }
    }
    
    public static int findMinCost(String source, String destination, 
                                   Map<String, Map<String, Integer>> routes) {
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.distance - b.distance);
        pq.add(new Node(source, 0));
        
        Map<String, Integer> visited = new HashMap<>();
        visited.put(source, 0);
        
        while(!pq.isEmpty()) {
            Node current = pq.poll();
            String currLocation = current.location;
            int currDistance = current.distance;
            
            if(currLocation.equals(destination)) {
                return currDistance;
            }
            
            Map<String, Integer> neighbors = routes.getOrDefault(currLocation, new HashMap<>());
            for(String nextLocation : neighbors.keySet()) {
                int newDistance = currDistance + neighbors.get(nextLocation);
                int prevDistance = visited.getOrDefault(nextLocation, Integer.MAX_VALUE);
                
                if(newDistance < prevDistance) {
                    visited.put(nextLocation, newDistance);
                    pq.add(new Node(nextLocation, newDistance));
                }
            }
        }
        return -1;
    }
    
    public static Map<String, Map<String, Integer>> buildRoutes(String input) {
        Map<String, Map<String, Integer>> routes = new HashMap<>();
        String[] entries = input.split(":");
        
        for(String entry : entries) {
            String[] parts = entry.split(",");
            String from = parts[0];
            String to = parts[1];
            int cost = Integer.parseInt(parts[3]);
            
            routes.putIfAbsent(from, new HashMap<>());
            routes.get(from).put(to, Math.min(cost, 
                    routes.get(from).getOrDefault(to, Integer.MAX_VALUE)));
        }
        return routes;
    }

    public static void main(String[] args) {
        // Test case 1
        String input1 = "US,UK,UPS,5:US,CA,FedEx,3:CA,UK,DHL,7";
        Map<String, Map<String, Integer>> routes1 = buildRoutes(input1);
        System.out.println("Test 1: Routes = \"" + input1 + "\"");
        System.out.println("Cost US -> UK: " + findMinCost("US", "UK", routes1));
        System.out.println("Cost US -> CA: " + findMinCost("US", "CA", routes1));
        System.out.println();

        // Test case 2: Multiple hops
        String input2 = "A,B,Carrier1,10:B,C,Carrier2,5:A,C,Carrier3,20";
        Map<String, Map<String, Integer>> routes2 = buildRoutes(input2);
        System.out.println("Test 2: Routes = \"" + input2 + "\"");
        System.out.println("Cost A -> C: " + findMinCost("A", "C", routes2) + " (direct=20, via B=15)");
        System.out.println();

        // Test case 3: No route
        String input3 = "X,Y,C1,5:Y,Z,C2,3";
        Map<String, Map<String, Integer>> routes3 = buildRoutes(input3);
        System.out.println("Test 3: Routes = \"" + input3 + "\"");
        System.out.println("Cost X -> Z: " + findMinCost("X", "Z", routes3) + " (unreachable)");
    }
}