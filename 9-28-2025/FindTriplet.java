import java.util.*;

/*
 Find all unique triplets such that each element is 
 from an Individual array and all adds up to give
 the target sum
 */

public class FindTriplet {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n];
        int b[] = new int[n];
        int c[] = new int[n];
        int t = sc.nextInt();
        for(int i=0;i<n;i++){
            a[i] = sc.nextInt();
        }
        for(int i=0;i<n;i++){
            b[i] = sc.nextInt();
        }
        for(int i=0;i<n;i++){
            c[i] = sc.nextInt();
        }
        Set<List<Integer>> ans = new HashSet<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                for(int k=0;k<n;k++){
                    if(a[i]+b[j]+c[k]==t){
                        List<Integer> temp = new ArrayList<>();
                        temp.add(a[i]);
                        temp.add(b[j]);
                        temp.add(c[k]);
                        ans.add(new ArrayList<>(temp));
                    }
                }
            }
        }
        System.out.println(ans);
        sc.close();
    }
}


//Time Complexity: O(n^3)
//Space Complexity: O(m) where m is number of triplets found