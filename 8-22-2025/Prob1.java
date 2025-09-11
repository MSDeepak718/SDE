import java.util.*;

public class Prob1{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i=0;i<n;i++){
            int v = i+1;
            int k = n-1;
            for(int j=0;j<=i;j++){
                System.out.print(v+" ");
                v += k;
                k--;
            }
            System.out.println();
        }
        sc.close();
    }
}