import java.util.*;

/*
 Merge the Overlapping Intervals in a 2-D Array
 */

public class MergeOverlappingIntervals {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[][] = new int[n][2];
        for(int i=0;i<n;i++){
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }
        List<int[]> list = new ArrayList<>();
        for(int i=0;i<n;i++){
            int s = arr[i][0];
            int e = arr[i][1];
            int j = i+1;
            while(j<n && arr[j][0]<=e){
                e = arr[j][1];
                j++;
            }
            list.add(new int[]{s,e});
            i = j-1;
        }
        for(int x[]:list){
            System.out.print("{"+x[0]+","+x[1]+"} ");
        }
        System.out.println();
        sc.close();
    }    
}

//Time Complexity: O(n) 
//Space Complexity: O(n)