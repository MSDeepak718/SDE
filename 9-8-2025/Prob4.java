//Find the leader in an Array
import java.util.*;

public class Prob4 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++) arr[i] = sc.nextInt();
        List<Integer> ans = new ArrayList<>();
        ans.add(arr[n-1]);
        int max = arr[n-1];
        for(int i=n-2;i>=0;i--){
            if(arr[i]>max){
                ans.add(arr[i]);
                max = arr[i];
            }
        }
        Collections.reverse(ans);
        System.out.println(ans);
        sc.close();
    }
}
