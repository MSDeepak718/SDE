import java.util.*;

public class Prob4 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int n = sc.nextInt();
        int sum = 0;
        for(int i=0;i<n;i++){
            int v = sc.nextInt();
            while(v>0){
                int d = v%10;
                if(d==a){
                    sum += i;
                    break;
                }
                v = v/10;
            }
        }
        System.out.println(sum);
        sc.close();
    }
}
