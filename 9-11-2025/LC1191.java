class Solution {
    private int mod = (int)1e9+7;
    public int kConcatenationMaxSum(int[] arr, int k) {
        int n = arr.length;
        int sum = 0;
        long ans = 0;
        for(int x:arr){
            sum += x;
            ans = Math.max(ans,(long)x);
        }
        ans = Math.max(ans,((long)sum*(long)k)%mod);
        int max2 = 0;
        int curr = 0;
        if(k>1){
            int narr[] = new int[n*2];
            for(int i=0;i<n;i++){
                narr[i] = arr[i];
                narr[i+n] = arr[i];
            }
            for(int j=0;j<n*2;j++){
                curr += narr[j];
                if(curr<0) curr = 0;
                max2 = Math.max(max2,curr);
            }
            ans = Math.max(ans,((long)max2+Math.max(0L,((long)sum*(long)(k-2))))%mod);
        }
        return (int)ans;
    }
}

//Time Complexity: O(n)
//Space Complexity: O(1)