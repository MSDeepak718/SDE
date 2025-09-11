import java.util.*;

public class Prob6 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int l = sc.nextInt();
        int m = sc.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++) arr[i] = sc.nextInt();
        System.out.println(Math.max(helper(arr,l,m),helper(arr,m,l)));
        sc.close();
    }
    public static int helper(int arr[],int l,int m){
        int n = arr.length;
        int pref[] = new int[n+1];
        for(int i=0;i<n;i++){
            pref[i+1] = pref[i]+arr[i];
        }
        int ans = 0;
        int maxl = 0;
        for(int i=l+m;i<=n;i++){
            maxl = Math.max(maxl,pref[i]-pref[i-l-m]);
            int curr = maxl+pref[i]-pref[i-m];
            ans = Math.max(ans,curr);
        }
        return ans;
    }
}
