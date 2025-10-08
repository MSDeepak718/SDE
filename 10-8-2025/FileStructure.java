import java.util.*;

public class FileStructure {
    Map<String,List<String>> map;
    Set<String> rem;
    FileStructure(){
        map = new HashMap<>();
        rem = new HashSet<>();
    }
    public void add(String parent,String child){
        map.putIfAbsent(parent,new ArrayList<>());
        map.putIfAbsent(child, new ArrayList<>());
        map.get(parent).add(child);
    }
    public void remove(String folder){
        rem.add(folder);
    }
    public int getCount(String folder){
        if(rem.contains(folder) || !map.containsKey(folder)) return -1;
        int count = dfs(folder);
        System.out.println(count);
        return count;
    }
    public int dfs(String node){
        int ans = 1;
        for(String x:map.get(node)){
            if(!rem.contains(x)){
                ans += dfs(x);
            }
        }
        return ans;
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        FileStructure fs = new FileStructure();
        fs.add("f1", "f2");
        fs.add("f2","f3");
        fs.add("f2","f4");
        fs.getCount("f2");
        fs.add("f3","f5");
        fs.getCount("f5");
        fs.remove("f3");
        fs.getCount("f2");
    }
}


//Time Complexity: O(N) for getCount where N is number of nodes in the subtree rooted at folder
//Space Complexity: O(N) for storing the tree