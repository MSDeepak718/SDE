import java.util.*;

public class PalindromicAlgorithms{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int arr[] = new int[26];
        PriorityQueue<int[]> q1 = new PriorityQueue<>((a,b)->{
            if(a[0]==b[0]) return a[1]-b[1];
            return a[0]-b[0];
        });
        PriorityQueue<int[]> q2 = new PriorityQueue<>((a,b)->{
            if(a[0]==b[0]) return b[1]-a[1];
            return b[0]-a[0];
        });
        for(char c:s.toCharArray()){
            arr[c-'a']++;
        }
        for(char c='a';c<='z';c++){
            if(arr[c-'a']%2!=0){
                q1.add(new int[]{arr[c-'a'],c-'a'});
                q2.add(new int[]{arr[c-'a'],c-'a'});
            }
        }
        int k = q1.size()/2;
        while(k-->0){
            int c[] = q1.poll();
            int d[] = q2.poll();
            char a = (char)(c[1]+97);
            char b = (char)(d[1]+97);
            arr[d[1]]--;
            arr[c[1]]++;
        }
        Character mid = null;
        for(char c='a';c<='z';c++){
            if(arr[c-'a']%2==1){
                mid = c;
                arr[c-'a'] -= 1;
                break;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(char c='a';c<='z';c++){
            if(arr[c-'a']==0) continue;
            int idx = sb.length()/2;
            for(int i=0;i<arr[c-'a'];i++){
                sb.insert(idx,c);
            }
        }
        if(mid!=null) sb.insert(sb.length()/2,mid);
        System.out.println(sb.toString());
    }
}

//Time Complexity: O(N) where N is length of string
//Space Complexity: O(1) since we are using fixed space