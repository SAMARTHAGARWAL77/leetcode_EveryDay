class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
    int s = spells.length;
    int p = potions.length;
    Arrays.sort(potions);
    int []ans = new int[s];
    for(int i = 0; i < s; i++)
    {
        int spell = spells[i];
        long requiredPortion = (long)Math.ceil((double)success/spell);
        int index = binarySearch(potions, requiredPortion);
        ans[i] = p - index;
    }
    return ans;
    }
    private int binarySearch(int []portions, long success){
        int low = 0,high = portions.length - 1, ans = portions.length;
        while(low <= high)
        {
            int mid = low + (high - low) / 2;
            if(portions[mid] >= success)
            {
                ans = mid;
                high = mid - 1;
            }
            else
            low = mid + 1;
        }
        return ans;
    }
}