📅 Date: 2025-10-14

📌 Problem Description

Given a list of integers nums and an integer k, determine whether there exist two non-overlapping subarrays of length k that are strictly increasing.

A subarray is strictly increasing if every consecutive pair of elements satisfies the condition:
nums[i] < nums[i + 1].

🔧 Method Signature
public boolean hasIncreasingSubarrays(List<Integer> nums, int k);

🛠 Core Concepts Used

Sliding Window Technique

Strictly Increasing Sequence Check

Boolean Caching (precomputation)

Non-overlapping Constraint

🔢 Step-by-Step Breakdown
✅ Step 1: Identify Increasing Subarrays

Iterate over the array to check every subarray of length k.

For each starting index i, check if the subarray nums[i..i+k-1] is strictly increasing.

Store the result (true or false) in an auxiliary array isIncreasingStart[i].

✅ Step 2: Search for Two Non-Overlapping Increasing Subarrays

Iterate again and check for any two increasing subarrays of length k that are k indices apart.

This ensures the subarrays do not overlap.

If such a pair exists, return true.

❌ Otherwise

If no such pair is found, return false.

📊 Time and Space Complexity

-> 🕒 Time	O(n * k)
-> 💾 Space	O(n) (for boolean cache)

-> n: length of the input list nums
-> k: length of the subarrays to check