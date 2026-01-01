import java.util.*;

// Question: Store Closing Time Penalty - Part 3
// Input string contains multiple stores with format: "BEGIN <log> END BEGIN <log> END"
// Find the best closing time for each store using Part 2 function

public class Program3 {
    
    public static int bestClosingTime(String customers) {
        int n = customers.length();
        
        int[] suffix = new int[n + 1];
        for(int i = n - 1; i >= 0; i--) {
            suffix[i] = suffix[i + 1] + (customers.charAt(i) == 'Y' ? 1 : 0);
        }
        
        int minPenalty = suffix[0];
        int prefix = 0;
        int bestTime = 0;
        
        for(int i = 0; i < n; i++) {
            if(customers.charAt(i) == 'N') {
                prefix++;
            }
            int currentPenalty = prefix + suffix[i + 1];
            if(currentPenalty < minPenalty) {
                minPenalty = currentPenalty;
                bestTime = i + 1;
            }
        }
        return bestTime;
    }
    
    public static List<Integer> processMultipleStores(String input) {
        String[] tokens = input.split(" ");
        Stack<String> stack = new Stack<>();
        List<Integer> results = new ArrayList<>();
        
        for(String token : tokens) {
            if(token.equals("END")) {
                StringBuilder log = new StringBuilder();
                while(!stack.isEmpty()) {
                    String val = stack.pop();
                    if(val.equals("BEGIN")) {
                        break;
                    }
                    log.append(val);
                }
                log.reverse();
                
                int closingTime = bestClosingTime(log.toString());
                results.add(closingTime);
            } else {
                stack.push(token);
            }
        }
        return results;
    }

    public static void main(String[] args) {
        // Test case 1: Single store
        String input1 = "BEGIN YYNY END";
        System.out.println("Test 1: \"" + input1 + "\"");
        System.out.println("Best closing times: " + processMultipleStores(input1));
        System.out.println();

        // Test case 2: Multiple stores
        String input2 = "BEGIN YYNY END BEGIN NNNYYY END";
        System.out.println("Test 2: \"" + input2 + "\"");
        System.out.println("Best closing times: " + processMultipleStores(input2));
        System.out.println();

        // Test case 3: Three stores
        String input3 = "BEGIN YYYY END BEGIN NNNN END BEGIN YNYN END";
        System.out.println("Test 3: \"" + input3 + "\"");
        System.out.println("Best closing times: " + processMultipleStores(input3));
    }
}