import java.util.*;

public class Prob3 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int arr[][] = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++) arr[i][j] = sc.nextInt();
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(isValid(i,j,arr,n,m)){
                    System.out.println(arr[i][j]);
                    sc.close();
                    return;
                }
            }
        }
        System.out.println(-1);
        sc.close();
    }    
    public static boolean isValid(int i,int j,int arr[][],int n,int m){
        for(int c=0;c<m;c++){
            if(c==j) continue;
            if(arr[i][c]<arr[i][j]) return false;
        }
        for(int r=0;r<n;r++){
            if(r==i) continue;
            if(arr[r][j]>arr[i][j]) return false;
        }
        return true;
    }
}
