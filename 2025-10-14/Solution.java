class Solution {
    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        int n = nums.size();
        boolean[] isIncreasingStart = new boolean[n];

        // Step 1: Check each subarray of length k to see if it's strictly increasing
        for (int i = 0; i + k <= n; i++) {
            boolean isIncreasing = true;
            for (int j = i + 1; j < i + k; j++) {
                if (nums.get(j) <= nums.get(j - 1)) {
                    isIncreasing = false;
                    break;
                }
            }
            isIncreasingStart[i] = isIncreasing;
        }

        // Step 2: Look for two non-overlapping increasing subarrays of length k
        for (int i = 0; i + 2 * k <= n; i++) {
            if (isIncreasingStart[i] && isIncreasingStart[i + k]) {
                return true;
            }
        }

        return false;
    }
}
