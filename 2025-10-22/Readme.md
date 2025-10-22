📅 Date: 2025-10-22

📌 Problem Description

You're given:

An integer array nums

Two integers:

k: the range flexibility (i.e., how much a number can be adjusted up/down)

numOperations: the maximum number of elements you can change

Each number in the array can be increased or decreased by at most k, but you can only change up to numOperations elements.

🔍 Goal: Maximize the frequency of any single number in the array after these changes.

🧰 Method Signature
public int maxFrequency(int[] nums, int k, int numOperations)

🛠 Core Concepts Used

Binary Search (lowerBound, upperBound)

Sorting

Greedy Strategy: check optimal frequencies around ±k range

Range-based counting

🔢 Step-by-Step Breakdown
✅ Step 1: Sort the Array

The input array nums is sorted to make binary search efficient:

Arrays.sort(nums);


This allows you to use binary search techniques to quickly find how many elements fall in specific ranges.

✅ Step 2: Check Feasible Frequencies Around Target Values

The check function is the core logic. For a given target number n, it calculates:

How many numbers in the array could be changed to n using at most numOperations changes and a ±k range constraint.

int res = (hh - h) + (l - ll); // Elements that can be adjusted into range
return Math.min(m, res) + (h - l); // m = numOperations

📌 Key Definitions:

nL = target value as long

tL = k as long

[n-k, n+k] is the allowed range to turn into n

lowerBound() and upperBound() help find how many numbers fall within/outside this window efficiently

✅ Step 3: Try Each Number as a Potential Target

For each number in the array (except the last), the algorithm considers:

The number itself (nums[i])

Its neighbors within the ±k range (nums[i] - k, nums[i] + k)

for (int i = 0; i < nums.length - 1; i++) {
    ans = Math.max(ans, check(nums, nums[i], k, m));
    ans = Math.max(ans, check(nums, nums[i] - k, k, m));
    ans = Math.max(ans, check(nums, nums[i] + k, k, m));
}


This increases the chances of catching an optimal frequency.

-> 🕒 Time Complexity:
O(n log n)
Sorting the array: O(n log n)
Binary search within check() runs in O(log n) per call
Called 3 * (n - 1) times in worst case

👉 Total: O(n log n) – efficient for up to 10⁵ elements

-> 💾 Space Complexity:
 O(1) (excluding input)
No extra space used other than a few variables
Purely in-place and stateless