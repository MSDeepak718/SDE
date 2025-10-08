import java.util.*;

public class Prob2 {

    public static Map<String,Integer> map;
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        map = new HashMap<>();
        for(int i=0;i<n;i++) arr[i] = sc.nextInt();
        Arrays.sort(arr);
        int ans = helper(0,0,-2,arr,n);
        System.out.println(ans);
        sc.close();
    }

    public static int helper(int i,int j,int k,int arr[],int n){
        if(i==n) return 0;
        String key = i+','+j+","+k;
        if(map.containsKey(key)) return map.get(key);
        int pick = 0;
        int notPick = helper(i+1,j,k,arr,n);
        if(k==-2) pick = 1+helper(i+1,i,-1,arr,n);
        if(k==-1) pick = 1+helper(i+1,i,arr[i]-arr[j],arr,n);
        if(k>=0 && arr[i]-arr[j]==k) pick = 1+helper(i+1,i,k,arr,n);
        map.put(key,Math.max(pick,notPick));
        return map.get(key); 
    }
}
