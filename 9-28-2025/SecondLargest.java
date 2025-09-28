import java.util.*;

/*
Second Largest Element in an Array
Given an array of positive integers arr[] of size n, the task is to find second largest distinct element in the array.
Note: If the second largest element does not exist, return -1.
 */

public class SecondLargest {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        for(int x:arr){
            if(x>max1){
                max2 = max1;
                max1 = x;
            }
            else if(x==max1) continue;
            else if(x>max2){
                max2 = x;
            }
        }
        System.out.println(max2==Integer.MIN_VALUE?-1:max2);
        sc.close();
    }
}

//Time Complexity: O(n)
//Space Complexity: O(1)
