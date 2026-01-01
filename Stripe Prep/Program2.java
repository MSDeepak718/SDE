// Question: Store Closing Time Penalty - Part 2
// Find the closing time with minimum penalty
// Use the Part 1 function to compute penalty for each closing time and track the minimum

public class Program2 {
    
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

    public static void main(String[] args) {
        // Test case 1
        String customers1 = "YYNY";
        System.out.println("Test 1: customers = \"" + customers1 + "\"");
        System.out.println("Best closing time: " + bestClosingTime(customers1));
        System.out.println();

        // Test case 2
        String customers2 = "NNNYYY";
        System.out.println("Test 2: customers = \"" + customers2 + "\"");
        System.out.println("Best closing time: " + bestClosingTime(customers2));
        System.out.println();

        // Test case 3
        String customers3 = "YYYYN";
        System.out.println("Test 3: customers = \"" + customers3 + "\"");
        System.out.println("Best closing time: " + bestClosingTime(customers3));
        System.out.println();

        // Test case 4
        String customers4 = "YYYY";
        System.out.println("Test 4: customers = \"" + customers4 + "\"");
        System.out.println("Best closing time: " + bestClosingTime(customers4));
    }
}