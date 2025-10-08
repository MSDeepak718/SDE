import java.util.*;

public class MergeNetworks {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = 3;
        int Afrom[] = {1,1};
        int Ato[] = {2,3};
        int m = 3;
        int Bfrom[] = {1,2};
        int Bto[] = {2,3};
        List<List<Integer>> l1 = new ArrayList<>();
        List<List<Integer>> l2 = new ArrayList<>();
        for(int i=0;i<n;i++) l1.add(new ArrayList<>());
        for(int i=0;i<m;i++) l2.add(new ArrayList<>());
        for(int i=0;i<Ato.length;i++){
            int u = Afrom[i]-1;
            int v = Ato[i]-1;
            l1.get(u).add(v);
            l1.get(v).add(u);
        }
        for(int i=0;i<Bto.length;i++){
            int u = Bfrom[i]-1;
            int v = Bto[i]-1;
            l2.get(u).add(v);
            l2.get(v).add(u);
        }
        int k1 = topo(l1,n);
        int k2 = topo(l2,m);
        int k3 = (int)(Math.ceil(k1/2.0))+(int)(Math.ceil(k2/2.0))+1;
        int ans = Math.max(k1,Math.max(k2,k3));
        System.out.println(ans);
    }
    public static int topo(List<List<Integer>> list,int n){
        Queue<Integer> queue = new LinkedList<>();
        int in[] = new int[n];
        for(int i=0;i<n;i++){
            in[i] = list.size();
            if(list.get(i).size()==1) queue.add(i);
        }
        int layers = 0;
        int rem = n;
        while(rem>2){
            int m = queue.size();
            rem -= m;
            layers++;
            for(int i=0;i<m;i++){
                int node = queue.poll();
                for(int x:list.get(node)){
                    in[x]--;
                    if(in[x]==1){
                        queue.add(x);
                    }
                }
            }
        }
        if(rem==2) return (2*layers)+1;
        return 2*layers;
    }
}

//Time Complexity: O(N+M) where N is number of nodes
//Space Complexity: O(N+M) for storing the graph