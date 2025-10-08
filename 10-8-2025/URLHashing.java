import java.util.*;

public class URLHashing {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        String url = sc.nextLine();
        int k = sc.nextInt();
        String s = sc.next();
        int n = url.length();
        int m = s.length();
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<n;i+=k){
            String curr = url.substring(i,Math.min(n,i+k));
            sb.append(s.charAt(helper(curr)%m));
        }
        System.out.println(sb.toString());
    }
    public static int helper(String x){
        int count = 0;
        for(char c:x.toCharArray()){
            if(Character.isAlphabetic(c)) count += (c-'a');
            else{
                if(c=='.') count += 28;
                else if(c=='/') count += 27;
                else if(c==':') count += 26; 
            }
        }
        return count;
    }
}

//Time Complexity: O(N) where N is length of url
//Space Complexity: O(N) for storing the hashed url
