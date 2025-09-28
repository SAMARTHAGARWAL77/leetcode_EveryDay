class Solution{
    public int largestPaerimeter(int [] nums){
        Arrays.sort(nums); // This will take NlogN
        for(int i = nums.length - 3 ; i >= 0; --i)
            if(nums[i] + nums[i+1] > nums[i+2])
            return nums[i] + nums[i+1] + nums[i+2];
        return 0;
    }
}