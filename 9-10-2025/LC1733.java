import java.util.*;

class Solution {
    public int minimumTeachings(int n, int[][] l, int[][] f) {
        int m = l.length;
        Map<Integer,Set<Integer>> map = new HashMap<>();
        for(int i=0;i<m;i++){
            int u = i+1;
            int la[] = l[i];
            map.put(u,new HashSet<>());
            for(int x:la){
                map.get(u).add(x);
            }
        }
        int ans = m;
        Set<Integer> users = new HashSet<>();
        for(int fr[]:f){
            int u = fr[0];
            int v = fr[1];
            boolean found = false;
            for(int la:map.get(u)){
                if(map.get(v).contains(la)){
                    found = true;
                    break;
                }
            }
            if(!found) {
                users.add(u);
                users.add(v);
            }
        }
        for(int i=1;i<=n;i++){
            int count = 0;
            for(int x:users){
                if(!map.get(x).contains(i)) count++;
            }
            ans = Math.min(ans,count);
        }
        return ans;
    }
}

// Time Complexity: O(m*n*k)
// Space Complexity: O(m*k)