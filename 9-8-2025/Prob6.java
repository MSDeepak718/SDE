//Insertion Sort Algorithm
import java.util.*;

public class Prob6 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++) arr[i] = sc.nextInt();
        for(int i=0;i<n;i++){
            int j = i-1;
            int key = arr[i];
            while(j>=0 && arr[j]>arr[j+1]){
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = key;
        }
        for(int x:arr) System.out.print(x+" ");
        sc.close();
    }
}
