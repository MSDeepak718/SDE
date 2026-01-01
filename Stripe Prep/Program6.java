import java.util.*;

// Question: Brace Expansion II
// Handle multiple braces and generate all possible combinations
// Example: "a{b,c}{d,e}" -> ["abd", "abe", "acd", "ace"]

public class Program6 {
    
    public static List<String> expandBracesAdvanced(String expression) {
        Set<String> results = new HashSet<>();
        helper(expression, results);
        List<String> list = new ArrayList<>(results);
        Collections.sort(list);
        return list;
    }
    
    private static void helper(String s, Set<String> results) {
        int closingPos = s.lastIndexOf('}');
        
        if(closingPos == -1) {
            results.add(s);
            return;
        }
        
        int openingPos = s.lastIndexOf('{', closingPos);
        
        String prefix = s.substring(0, openingPos);
        String itemsStr = s.substring(openingPos + 1, closingPos);
        String suffix = s.substring(closingPos + 1);
        
        String[] items = itemsStr.split(",");
        
        for(String item : items) {
            helper(prefix + item + suffix, results);
        }
    }

    public static void main(String[] args) {
        // Test case 1: Two braces
        String test1 = "a{b,c}{d,e}";
        System.out.println("Test 1: \"" + test1 + "\"");
        System.out.println("Result: " + expandBracesAdvanced(test1));
        System.out.println();

        // Test case 2: Nested style multiple braces
        String test2 = "{a,b}{1,2,3}";
        System.out.println("Test 2: \"" + test2 + "\"");
        System.out.println("Result: " + expandBracesAdvanced(test2));
        System.out.println();

        // Test case 3: Three braces
        String test3 = "pre{x,y}{1,2}{A,B}post";
        System.out.println("Test 3: \"" + test3 + "\"");
        System.out.println("Result: " + expandBracesAdvanced(test3));
        System.out.println();

        // Test case 4: Single brace
        String test4 = "{p,q,r}";
        System.out.println("Test 4: \"" + test4 + "\"");
        System.out.println("Result: " + expandBracesAdvanced(test4));
    }
}