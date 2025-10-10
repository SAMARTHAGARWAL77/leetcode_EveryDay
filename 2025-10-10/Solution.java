class Solution {
    public int maximumEnergy(int[] energy, int k) {
        if (energy == null || energy.length == 0) {
            return 0;
        }

        int maxEnergy = Integer.MIN_VALUE;
        int n = energy.length;

        for (int i = 0; i < k; i++) {
            int currentSum = 0;
            for (int j = n - 1; j - i >= 0; j -= k) {
                currentSum += energy[j - i];
                maxEnergy = Math.max(maxEnergy, currentSum);
            }
        }
        return maxEnergy;
    }
}
