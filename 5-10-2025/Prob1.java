import java.util.*;

public class Prob1{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){
            int n = sc.nextInt();
            int arr[] = new int[n];
            for(int i=0;i<n;i++) arr[i] = sc.nextInt();
            int tar[] = {arr[0]+arr[1],arr[n-1]+arr[0],arr[n-1]+arr[n-2]};
            int a = 0;
            for(int x:tar){
                Integer dp[][] = new Integer[n][n];
                int v = helper(0,n-1,arr,x,dp);
                a = Math.max(a,v);
            }
            System.out.println(a);
        }
        sc.close();
    }
    public static int helper(int i,int j,int arr[],int t,Integer dp[][]){
        if(j-i+1<2) return 0;
        if(dp[i][j]!=null) return dp[i][j];
        int f = 0;
        int s = 0;
        int r = 0;
        if(arr[i]+arr[i+1]==t) f = 1+helper(i+2,j,arr,t,dp);
        if(arr[j]+arr[j-1]==t) s = 1+helper(i,j-2,arr,t,dp);
        if(arr[i]+arr[j]==t) r = 1+helper(i+1,j-1,arr,t,dp);
        return dp[i][j] = Math.max(f,Math.max(s,r));
    }
}