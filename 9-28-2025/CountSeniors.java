import java.util.*;

/*
 Extract age from the string and return 
 the count of senior citizens
 */

public class CountSeniors {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String arr[] = new String[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.next();
        }
        int count = 0;
        for(String x:arr){
            int age = Integer.parseInt(x.substring(11,13));
            if(age>=60) count++;
        }
        System.out.println(count);
        sc.close();
    }
}

//Time Complexity: O(n)
//Space Complexity: O(1)
