// Question: Store Closing Time Penalty - Part 1
// Customer log: "Y Y N Y" where Y means customer comes, N means no.
// Compute the penalty by the rule:
// - If customers don't come (N) when the store is open: +1
// - If customers come (Y) when the store is closed: +1

public class Program1 {
    
    public static int computePenalty(String log, int closingTime) {
        int penalty = 0;
        for(int i = 0; i < log.length(); i++) {
            char c = log.charAt(i);
            if(i < closingTime) {
                if(c == 'N') penalty++;
            } else {
                if(c == 'Y') penalty++;
            }
        }
        return penalty;
    }

    public static void main(String[] args) {
        // Test case 1
        String log1 = "YYNY";
        int closingTime1 = 2;
        System.out.println("Test 1: log = \"" + log1 + "\", closing time = " + closingTime1);
        System.out.println("Penalty: " + computePenalty(log1, closingTime1));
        System.out.println();

        // Test case 2
        String log2 = "NNNYYY";
        int closingTime2 = 3;
        System.out.println("Test 2: log = \"" + log2 + "\", closing time = " + closingTime2);
        System.out.println("Penalty: " + computePenalty(log2, closingTime2));
        System.out.println();

        // Test case 3
        String log3 = "YYYYN";
        int closingTime3 = 4;
        System.out.println("Test 3: log = \"" + log3 + "\", closing time = " + closingTime3);
        System.out.println("Penalty: " + computePenalty(log3, closingTime3));
    }
}
