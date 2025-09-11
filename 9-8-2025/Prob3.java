//Sort the words in a string by lexicographical order
import java.util.*;

public class Prob3 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Queue<String> queue = new PriorityQueue<>();
        List<String> ans = new ArrayList<>();
        for(int i=0;i<n;i++){
            String s = sc.next();
            queue.add(s);
        }
        while(!queue.isEmpty()){
            String c = queue.poll();
            ans.add(c);
        }
        System.out.println(ans);
        sc.close();
    }
}
