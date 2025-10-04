📅 Date:
2025-10-04

📌 Class Description

The Solution class provides an efficient algorithm to solve the Container With Most Water problem from LeetCode.

Given an array of non-negative integers where each integer represents the height of a vertical line on the x-axis, the goal is to find two lines that, together with the x-axis, form a container that holds the maximum amount of water.

This problem leverages the two-pointer technique to achieve optimal performance, eliminating the need for a brute-force O(n²) approach.

🔧 Method Signature
public int maxArea(int[] height);

🧠 Internal Logic Summary
📥 Input

An array of integers, height[], where each element represents the height of a vertical line drawn at that index.

🎯 Output

An integer representing the maximum amount of water that can be contained between any two lines.

🛠 Approach: Two Pointers
🔢 Step-by-Step Logic

Initialize Pointers

left pointer starts at the beginning of the array

right pointer starts at the end of the array

Loop until the pointers meet

Compute the area using:

Math.min(height[left], height[right]) * (right - left)


Update the maximum water if the current area is larger.

Move the pointer pointing to the shorter line

This is because the limiting factor for the area is the shorter height; moving it inward might lead to a taller line and possibly a bigger area.

Repeat until the pointers cross.

✅ Example
Input: height = [1,8,6,2,5,4,8,3,7]
Output: 49


In this case, the lines at index 1 and 8 (heights 8 and 7) form the container with the largest possible area:
min(8,7) * (8 - 1) = 7 * 7 = 49

📦 Data Structures Used

int[] height: Array of integers as input

Integer variables: left, right, water used for two-pointer traversal and tracking max area

📊 Time and Space Complexity

-> 🕒 Time	O(n) — Single pass with two pointers
-> 🧠 Space	O(1) — Constant extra space

The algorithm is optimal for this problem, as it avoids nested loops and leverages linear time traversal.