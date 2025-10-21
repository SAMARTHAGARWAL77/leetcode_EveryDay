📅 Date: 2025-10-21

📌 Problem Description

You are given:

An integer array nums

Two integers: k (range flexibility) and numOperations (maximum number of changes allowed)

Each element in nums can be adjusted up or down within a range of ±k, but the total number of adjusted elements cannot exceed numOperations.

The goal is to maximize the frequency of any single number in the array after performing at most numOperations.

🔧 Method Signature
int maxFrequency(int[] nums, int k, int numOperations)

🛠 Core Concepts Used

Frequency Counting

Prefix Sum Array

Range-based Optimization

Greedy Decision Making for maximizing frequency under constraints

🔢 Step-by-Step Breakdown
✅ Step 1: Determine Range (min/max)

Find the minimum and maximum values in the array to establish the bounds for processing.

int max = 0, min = Integer.MAX_VALUE;
for (int i : nums) {
    max = Math.max(max, i);
    min = Math.min(min, i);
}

✅ Step 2: Build Frequency and Prefix Arrays

Count the frequency of each number

Construct a prefix sum array for quick range sum queries

int[] freq = new int[max + 1];
int[] prefix = new int[max + 1];

for (int i : nums) {
    freq[i]++;
}
for (int i = min; i <= max; i++) {
    prefix[i] = prefix[i - 1] + freq[i];
}

✅ Step 3: Iterate and Compute Max Frequency

For each value i in the range:

Define a window from i - k to i + k

Calculate how many numbers within that window could potentially be changed to i

Compute how many operations it would take to do this

Use only up to numOperations allowed

for (int i = min; i <= max; i++) {
    int low = (i - k - 1 > 0) ? prefix[i - k - 1] : 0;
    int high = (i + k <= max) ? prefix[i + k] : prefix[max];

    int toChange = high - low - freq[i]; // exclude current freq[i] to avoid double counting

    ans = Math.max(ans, freq[i] + Math.min(toChange, numOperations));
}

📊 Time and Space Complexity

-> 🕒 Time Complexity: O(n + r)
Where n is the number of elements in nums, and r is the range between min and max values

-> 💾 Space Complexity: O(r)
Due to frequency and prefix sum arrays of size max + 1