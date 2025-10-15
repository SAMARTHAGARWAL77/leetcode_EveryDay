class Solution {
    public int maxIncreasingSubarrays(List<Integer> nums) {
    int n = nums.size();
    int prevRun = 0;
    int currRun = 1;
    int k = 1;
    for(int i = 1;i < n ;i++)
    {
        if(nums.get(i) > nums.get(i-1)){
            currRun++;
        }
        else{
        prevRun = currRun;
        currRun = 1;
    }    
    k = Math.max(k, currRun/2);
    k = Math.max(k,Math.min(currRun, prevRun));
    }
    return k;
    }
}