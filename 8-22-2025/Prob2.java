import java.util.*;

public class Prob2 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++) arr[i] = sc.nextInt();
        int max = -1;
        List<Integer> list = new ArrayList<>();
        for(int i=n-1;i>=0;i--){
            if(arr[i]>max) list.add(arr[i]);
            max = Math.max(max,arr[i]);
        }
        Collections.reverse(list);
        for(int x:list){
            System.out.print(x+" ");
        }
        System.out.println();
        sc.close();
    }    
}
