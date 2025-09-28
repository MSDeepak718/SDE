import java.util.*;

/*
 Replace the spaces in a string with %20
 */

public class ReplaceSpace {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String arr[] = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<arr.length;i++){
            String x = arr[i];
            x = x.trim();
            sb.append(x);
            if(i<arr.length-1) sb.append("%20");
        }
        System.out.println(sb.toString());
        sc.close();
    }
}

//Time Complexity: O(n)
//Space Complexity: O(n)    