📅 Date: 2025-10-15

📌 Problem Description

Given a list of integers nums, the task is to find the maximum possible value of k such that there exist two adjacent subarrays of length k that are strictly increasing.

A subarray is strictly increasing if every element is less than the next element.

These subarrays must be adjacent and non-overlapping, meaning if the first subarray starts at index i, the second one must start at index i + k.

🔧 Method Signature
public int maxIncreasingSubarrays(List<Integer> nums);

🛠 Core Concepts Used

Greedy Approach

Run Length Tracking (Detecting consecutive strictly increasing runs)

Adjacent Subarray Pairing

Math (min & max) for determining valid k

🔢 Step-by-Step Breakdown
✅ Step 1: Track Length of Strictly Increasing Runs

Iterate through the list once.

Maintain two variables:

currRun: current length of the ongoing increasing sequence.

prevRun: length of the previous increasing run before the current one.

✅ Step 2: Check for Adjacent Increasing Sequences

When the sequence breaks (nums[i] <= nums[i-1]):

Check whether prevRun and currRun can form two adjacent increasing subarrays.

A valid k is the minimum of the two run lengths.

Update the maximum k found so far.

✅ Step 3: Handle the Final Run

After the loop ends, a final check is done in case the array ends with an increasing sequence.

📊 Time and Space Complexity

-> 🕒 Time	O(n)
-> 💾 Space	O(1)