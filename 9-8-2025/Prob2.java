//Binary Search
import java.util.*;

public class Prob2 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++) arr[i] = sc.nextInt();
        int t = sc.nextInt();
        Arrays.sort(arr);
        int l = 0;
        int h = n-1;
        while(l<=h){
            int m = l+(h-l)/2;
            if(arr[m]==t){
                System.out.println(m);
                sc.close();
                return;
            }
            else if(arr[m]<t){
                l = m+1;
            }
            else{
                h = m-1;
            }
        }
        sc.close();
    }
}
