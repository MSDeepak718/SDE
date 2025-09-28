import java.util.*;

/*
 Given an array of integers find the first missing integer in array of size n-1
 */

public class MissingInteger {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
            set.add(arr[i]);
        }
        int max = Arrays.stream(arr).max().getAsInt();
        for(int x=1;x<max;x++){
            if(!set.contains(x)){
                System.out.println(x);
                sc.close();
                return;
            }
        }
        System.out.println(max+1);
        sc.close();
    }
}

//Time Complexity: O(n)
//Space Complexity: O(n)
