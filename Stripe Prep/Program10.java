import java.util.*;

// Question: Shortest Word Distance with Distance Constraint
// Given a text and query string, find starting indices of the first word in query
// such that all words in the query are at most k apart
// Example: text="The quick brown fox", query="quick fox", k=2
//          returns [1] because quick(1) and fox(3) are 2 apart

public class Program10 {
    
    public static List<Integer> findQueryIndices(String text, String query, int k) {
        List<Integer> results = new ArrayList<>();
        
        String[] words = text.split(" ");
        String[] queryWords = query.split(" ");
        
        Map<String, List<Integer>> wordIndex = new HashMap<>();
        for(int i = 0; i < words.length; i++) {
            String word = words[i];
            wordIndex.putIfAbsent(word, new ArrayList<>());
            wordIndex.get(word).add(i);
        }
        
        if(!wordIndex.containsKey(queryWords[0])) {
            return results;
        }
        
        for(int firstPos : wordIndex.get(queryWords[0])) {
            boolean valid = true;
            int lastPos = firstPos;
            
            for(int i = 1; i < queryWords.length; i++) {
                List<Integer> positions = wordIndex.getOrDefault(queryWords[i], new ArrayList<>());
                
                if(positions.isEmpty()) {
                    valid = false;
                    break;
                }
                
                int nextPos = binarySearch(positions, lastPos);
                
                if(nextPos == -1 || nextPos - lastPos > k) {
                    valid = false;
                    break;
                }
                
                lastPos = nextPos;
            }
            
            if(valid) {
                results.add(firstPos);
            }
        }
        
        return results;
    }
    
    private static int binarySearch(List<Integer> list, int target) {
        int left = 0;
        int right = list.size() - 1;
        int result = -1;
        
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(list.get(mid) > target) {
                result = list.get(mid);
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        
        return result;
    }

    public static void main(String[] args) {
        // Test case 1: Basic example
        String text1 = "The quick brown fox is quick fox";
        String query1 = "quick fox";
        int k1 = 2;
        System.out.println("Test 1:");
        System.out.println("Text: \"" + text1 + "\"");
        System.out.println("Query: \"" + query1 + "\", k=" + k1);
        System.out.println("Result: " + findQueryIndices(text1, query1, k1));
        System.out.println("(Word positions: quick=[1,5], fox=[3,6])");
        System.out.println();

        // Test case 2: Stricter distance constraint
        String text2 = "a b c d e f g";
        String query2 = "a g";
        int k2 = 3;
        System.out.println("Test 2:");
        System.out.println("Text: \"" + text2 + "\"");
        System.out.println("Query: \"" + query2 + "\", k=" + k2);
        System.out.println("Result: " + findQueryIndices(text2, query2, k2));
        System.out.println("(a at 0, g at 6; distance=6 > k=3, so empty)");
        System.out.println();

        // Test case 3: Multiple occurrences
        String text3 = "apple banana cherry apple banana apple";
        String query3 = "apple banana";
        int k3 = 1;
        System.out.println("Test 3:");
        System.out.println("Text: \"" + text3 + "\"");
        System.out.println("Query: \"" + query3 + "\", k=" + k3);
        System.out.println("Result: " + findQueryIndices(text3, query3, k3));
        System.out.println("(Positions: apple=[0,3,5], banana=[1,4])");
        System.out.println();

        // Test case 4: Word not in text
        String text4 = "hello world test";
        String query4 = "hello xyz";
        int k4 = 2;
        System.out.println("Test 4:");
        System.out.println("Text: \"" + text4 + "\"");
        System.out.println("Query: \"" + query4 + "\", k=" + k4);
        System.out.println("Result: " + findQueryIndices(text4, query4, k4) + " (xyz not found)");
    }
}