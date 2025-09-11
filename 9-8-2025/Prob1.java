//Reverse the words in the given string without using any inbuilt function
import java.util.*;

public class Prob1{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your input: ");
        String s = sc.nextLine();
        String arr[] = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for(String x:arr){
            x = x.trim();
            String y = helper(x);
            sb.append(y);
            sb.append(" ");
        }
        System.out.println(sb.toString().trim());
        sc.close();
    }
    public static String helper(String x){
        char arr[] = x.toCharArray();
        int i = 0;
        int j = x.length()-1;
        while(i<j){
            char t = arr[i];
            arr[i] = arr[j];
            arr[j] = t;
            i++;
            j--;
        }
        return new String(arr);
    }
}