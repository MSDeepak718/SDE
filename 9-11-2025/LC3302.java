class Solution {
    public int[] validSequence(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int last[] = new int[m];
        int j = m-1;
        for(int i=n-1;i>=0;i--){
            if(j>=0 && word1.charAt(i)==word2.charAt(j)){
                last[j--] = i;
            }
        }
        int ans[] = new int[m];
        j = 0;
        boolean skip = false;
        for(int i=0;i<n && j<m;i++){
            if(word1.charAt(i)==word2.charAt(j) || (!skip && (j==m-1 || i<last[j+1]))){
                if(word1.charAt(i)!=word2.charAt(j)) skip = true;
                ans[j++] = i; 
            }
        }
        return j==m?ans:new int[]{};
    }
}

// Time Complexity: O(n+m)
// Space Complexity: O(m)