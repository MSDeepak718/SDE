import java.util.*;

// Question: Parse Accept-Language Header
// Given an Accept-Language header and list of supported languages,
// return supported languages in order of preference from the header
// Example: header="en-US, fr-CA, fr-FR", supported={"en-US", "de"} -> ["en-US"]

public class Program9 {
    
    public static List<String> parseAcceptLanguage(String headerValue, Set<String> supportedLanguages) {
        List<String> result = new ArrayList<>();
        
        String[] preferences = headerValue.split(",");
        
        for(String pref : preferences) {
            String language = pref.trim();
            
            if(supportedLanguages.contains(language)) {
                result.add(language);
            }
        }
        
        return result;
    }

    public static void main(String[] args) {
        // Test case 1: Basic accept-language parsing
        String header1 = "en-US, fr-CA, fr-FR";
        Set<String> supported1 = new HashSet<>(Arrays.asList("en-US", "de", "fr-FR"));
        System.out.println("Test 1:");
        System.out.println("Header: \"" + header1 + "\"");
        System.out.println("Supported: " + supported1);
        System.out.println("Result: " + parseAcceptLanguage(header1, supported1));
        System.out.println();

        // Test case 2: With spacing variations
        String header2 = "en-US,fr-CA,de-DE";
        Set<String> supported2 = new HashSet<>(Arrays.asList("en-US", "de-DE", "pt-BR"));
        System.out.println("Test 2:");
        System.out.println("Header: \"" + header2 + "\"");
        System.out.println("Supported: " + supported2);
        System.out.println("Result: " + parseAcceptLanguage(header2, supported2));
        System.out.println();

        // Test case 3: No matches
        String header3 = "zh-CN, zh-Hans, zh";
        Set<String> supported3 = new HashSet<>(Arrays.asList("en-US", "fr-FR", "es-ES"));
        System.out.println("Test 3:");
        System.out.println("Header: \"" + header3 + "\"");
        System.out.println("Supported: " + supported3);
        System.out.println("Result: " + parseAcceptLanguage(header3, supported3) + " (no matches)");
        System.out.println();

        // Test case 4: All matches
        String header4 = "en-US, fr-FR, de-DE";
        Set<String> supported4 = new HashSet<>(Arrays.asList("en-US", "fr-FR", "de-DE"));
        System.out.println("Test 4:");
        System.out.println("Header: \"" + header4 + "\"");
        System.out.println("Supported: " + supported4);
        System.out.println("Result: " + parseAcceptLanguage(header4, supported4));
    }
}