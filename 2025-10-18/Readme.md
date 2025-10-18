📅 Date: 2025-10-18

📌 Problem Description

You are given an integer array nums and an integer k. The task is to compute the maximum number of distinct elements that can be selected from the array such that:

Each selected number can differ from a previously selected number by at least k + 1.

You may adjust each number by up to k in either direction (i.e., choose a number in the range [num - k, num + k]).

The goal is to maximize the number of distinct adjusted elements under the constraint that no two selected values are equal.

🔧 Method Signature

int maxDistinctElements(int[] nums, int k);


🛠 Core Concepts Used

Greedy Approach for assigning values close to original numbers

Sorting to process elements in increasing order

Sliding window of feasible values via range [num - k, num + k]

Greedy Interval Assignment to maximize distinct placements

🔢 Step-by-Step Breakdown

✅ Step 1: Sort the Array

To make greedy selection optimal, the array is sorted. This ensures that adjustments happen in an orderly fashion and we always know the previously used number.

Arrays.sort(nums);


✅ Step 2: Iterate and Place Adjusted Numbers

For each number in the sorted array, the algorithm:

Computes a valid adjusted number in the range [num - k, num + k] that is also greater than the last used number (prev).

Chooses the minimum such number to keep the future options open (greedy).

If such a number exists, it's used and the count is incremented.

int curr = Math.min(Math.max(num - k, prev + 1), num + k);
if (curr > prev) {
    count++;
    prev = curr;
}


✅ Step 3: Return the Count

At the end, count holds the number of distinct adjusted elements that can be placed.

📊 Time and Space Complexity

-> 🕒 Time: O(n log n)
-> 💾 Space: O(1)
