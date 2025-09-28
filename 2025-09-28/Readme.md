📅 Date: 2025-09-28
📌 Class Description

The Solution class provides a method to determine the largest perimeter of a triangle that can be formed from any three integers in a given array, where the integers represent side lengths.

The core idea is based on the Triangle Inequality Theorem — the sum of the lengths of any two sides of a triangle must be greater than the length of the third side. The method checks from the largest possible side combinations (after sorting) and returns the maximum valid perimeter found.

🔧 Method Signature

public int largestPerimeter(int[] nums)


🧠 Internal Logic Summary

📥 Input
An integer array nums where each element represents a potential triangle side length.

📤 Output
An integer value representing the largest perimeter of a triangle that can be formed. Returns 0 if no valid triangle can be formed.

🛠 Approach: Greedy + Triangle Inequality

🔢 Step-by-step Logic

Sort the array in non-decreasing order to make it easier to apply the triangle inequality rule on the largest sides.

Iterate backwards from the third-last element to the beginning:

At each step, check if the current element plus the next one is greater than the next-next one (i.e., nums[i] + nums[i+1] > nums[i+2]).

If true, these three elements can form a triangle, and their sum is the maximum perimeter possible due to sorting.

Return 0 if no such triplet is found.

📦 Data Structures Used

int[] nums: The input array storing potential side lengths.

Basic integer variables for indexing and storing the result.

📊 Time and Space Complexity

-> 🕒 Time Complexity: O(n log n) due to the sorting step.
-> 🧠 Space Complexity: O(1) (in-place operations except for sorting).