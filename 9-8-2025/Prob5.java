//All possible permutations of a String
import java.util.*;

public class Prob5 {
    public static void main(String args[]){
        Scanner sc =  new Scanner(System.in);
        String s = sc.next();
        int n = s.length();
        int vis[] = new int[n];
        Set<String> set = new HashSet<>();
        helper(s,new StringBuilder(),set,vis,n);
        List<String> ans = new ArrayList<>(set);
        Collections.sort(ans);
        System.out.println(ans);
        sc.close();
    }
    public static void helper(String s,StringBuilder sb,Set<String> set,int vis[],int n){
        if(sb.length()==n){
            set.add(sb.toString());
            return;
        }
        for(int i=0;i<n;i++){
            if(vis[i]==0){
                vis[i] = 1;
                sb.append(s.charAt(i));
                helper(s,sb,set,vis,n);
                vis[i] = 0;
                sb.deleteCharAt(sb.length()-1);
            }
        }
    }
}
