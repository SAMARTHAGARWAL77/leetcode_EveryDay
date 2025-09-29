class Solution{
    public int minScoreTriangulation(int[] values) {
        
        int n = values.length;
        int [][]memo = new int[n][n];
        for(int i = 0;i < n;i++)
        {
            Arrays.fill(memo[i],-1);
        }
        return helper(values, 0 , n-1, memo) ;   
    }

    private Integer helper(int[] values, int i, int j, int [][]memo){
        int result = Integer.MAX_VALUE;
        if(j - i + 1 < 3) return 0;
        if(memo[i][j] != -1)return memo[i][j];
        for(int k=i+1;k<j;k++)
        {
            int wt = values[i] * values[j] * values[k] + helper(values, i, k, memo) + helper(values, k, j, memo);
            result = Math.min(result,wt);
        }
        memo[i][j] = result;
        return result;
    }
}