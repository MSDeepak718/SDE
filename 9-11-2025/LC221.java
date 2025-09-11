class Solution {
    public int maximalSquare(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int p = Math.min(n,m);
        int low = 1;
        int high = p;
        int ans = -1;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(isCheck(matrix,mid)){
                ans = mid;
                low = mid+1;
            }
            else{
                high = mid-1;
            }
        }
        if(ans==-1) return 0;
        return ans*ans;
    }
    public boolean isCheck(char matrix[][],int x){
        int n = matrix.length;
        int m = matrix[0].length;
        for(int i=0;i<=n-x;i++){
            for(int j=0;j<=m-x;j++){
                if(isValid(matrix,i,j,i+x,j+x)) return true;
            }
        }
        return false;
    }
    public boolean isValid(char matrix[][],int r,int c,int n,int m){
        for(int i=r;i<n;i++){
            for(int j=c;j<m;j++){
                if(matrix[i][j]!='1') return false;
            }
        }
        return true;
    }
}

// Time Complexity: O(n*m*min(n,m)^2)
// Space Complexity: O(1)