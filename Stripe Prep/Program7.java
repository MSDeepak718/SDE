import java.util.*;

// Question: Brace Expansion II - Advanced
// Handle nested braces and generate all possible combinations
// Finds the innermost brace first and expands outward
// Example: "a{b{c,d},e}f" -> ["abcf", "abdf", "aef"]

public class Program7 {
    
    public static TreeSet<String> expandNestedBraces(String expression) {
        TreeSet<String> results = new TreeSet<>();
        expandHelper(expression, results);
        return results;
    }
    
    private static void expandHelper(String s, TreeSet<String> results) {
        int closingPos = s.indexOf('}');
        
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
            String expanded = prefix + item + suffix;
            expandHelper(expanded, results);
        }
    }

    public static void main(String[] args) {
        // Test case 1: Simple nested braces
        String test1 = "a{b{c,d},e}f";
        System.out.println("Test 1: \"" + test1 + "\"");
        System.out.println("Result: " + expandNestedBraces(test1));
        System.out.println();

        // Test case 2: Complex nesting
        String test2 = "{a{b,c},d{e,f}}";
        System.out.println("Test 2: \"" + test2 + "\"");
        System.out.println("Result: " + expandNestedBraces(test2));
        System.out.println();

        // Test case 3: Multiple levels of nesting
        String test3 = "p{q{r,s},t{u,v}}q";
        System.out.println("Test 3: \"" + test3 + "\"");
        System.out.println("Result: " + expandNestedBraces(test3));
        System.out.println();

        // Test case 4: No nesting
        String test4 = "a{x,y,z}b";
        System.out.println("Test 4: \"" + test4 + "\"");
        System.out.println("Result: " + expandNestedBraces(test4));
    }
}