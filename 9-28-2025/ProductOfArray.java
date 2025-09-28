import java.util.*;

/*
 Product of the array except the self element
 */

public class ProductOfArray {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++) arr[i] = sc.nextInt();
        int pref[] = new int[n];
        int suff[] = new int[n];
        pref[0] = arr[0];
        suff[n-1] = arr[n-1];
        for(int i=1;i<n;i++) pref[i] = pref[i-1]*arr[i];
        for(int i=n-2;i>=0;i--) suff[i] = suff[i+1]*arr[i];
        List<Integer> ans = new ArrayList<>();
        for(int i=0;i<n;i++){
            int pre = 1;
            int suf = 1;
            if(i-1>=0) pre = pref[i-1];
            if(i+1<n) suf = suff[i+1];
            ans.add(pre*suf);
        }
        System.out.println(ans);
        sc.close();
    }
}

//Time Complexity: O(n)
//Space Complexity: O(n)
