import java.util.*;

public class JobExecution {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        int x = sc.nextInt();
        int y = sc.nextInt();
        for(int i=0;i<n;i++) arr[i] = sc.nextInt();
        Queue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        for(int p:arr) queue.add(p);
        int k = 0;
        int ops = 0;
        while(!queue.isEmpty() && queue.peek()-k>0){
            int v = queue.poll();
            v -= x;
            k += y;
            ops++; 
        }
        System.out.println(ops+1);
    }
}

//Time Complexity: O(N log N) where N is number of jobs
//Space Complexity: O(N) for storing the jobs in the priority queue