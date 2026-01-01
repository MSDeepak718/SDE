import java.util.*;

// Question: Brace Expansion I
// Given a string with format "prefix{item1,item2,...}suffix"
// Return all combinations by expanding the braces
// Example: "a{b,c}d" -> ["abd", "acd"]

public class Program5 {
    
    public static List<String> expandBraces(String expression) {
        List<String> results = new ArrayList<>();
        
        String[] parts = expression.split("[{}]");
        
        if(parts.length < 2 || parts.length > 3) {
            results.add(expression);
            return results;
        }
        
        String prefix = parts[0];
        String[] items = parts[1].split(",");
        String suffix = parts.length > 2 ? parts[2] : "";
        
        if(items.length >= 1) {
            for(String item : items) {
                results.add(prefix + item + suffix);
            }
        }
        
        return results;
    }

    public static void main(String[] args) {
        // Test case 1: Simple brace expansion
        String test1 = "a{b,c}d";
        System.out.println("Test 1: \"" + test1 + "\"");
        System.out.println("Result: " + expandBraces(test1));
        System.out.println();

        // Test case 2: No prefix or suffix
        String test2 = "{x,y,z}";
        System.out.println("Test 2: \"" + test2 + "\"");
        System.out.println("Result: " + expandBraces(test2));
        System.out.println();

        // Test case 3: With prefix and suffix
        String test3 = "pre{A,B,C}post";
        System.out.println("Test 3: \"" + test3 + "\"");
        System.out.println("Result: " + expandBraces(test3));
        System.out.println();

        // Test case 4: Only prefix
        String test4 = "prefix{1,2}";
        System.out.println("Test 4: \"" + test4 + "\"");
        System.out.println("Result: " + expandBraces(test4));
    }
}