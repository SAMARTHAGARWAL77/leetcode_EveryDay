📅 Date: 2025-09-30

📌 Class Description

The Solution class provides a method to compute the triangular sum of an array. Starting from the original array, we repeatedly form a new array where each element is the sum of adjacent elements modulo 10, until only one element remains. That final single-digit number is the triangular sum.

This process resembles creating a number triangle (similar to Pascal’s triangle with mod 10 arithmetic) and reducing it row by row.

🔧 Method Signature
public int triangularSum(int[] nums)

🧠 Internal Logic Summary
📥 Input

An integer array nums of length n (1 ≤ n ≤ 1000), where each element is a single-digit integer (0 ≤ nums[i] ≤ 9).

📤 Output

Returns a single integer representing the triangular sum of the input array.

🔁 Approach: Iterative Reduction with Modulo Arithmetic

The solution uses iterative array reduction — forming a new array by summing adjacent elements modulo 10 until one element remains. This result is returned.

🔢 Step-by-step Logic

Initialize a list current with the input array.

While the list size is greater than 1:

Create a new list newNums.

For each index i, calculate (current[i] + current[i+1]) % 10.

Add the result to newNums.

Set current = newNums.

Return the single remaining element in current.

📦 Data Structures Used

List<Integer> – for mutable list operations during each iteration.

📊 Time Complexity


-> O(n²) – Each iteration reduces the list size by 1, leading to a total of n-1 iterations. Each iteration takes O(n) in the worst case.

-> Total operations: O(n + (n-1) + (n-2) + ... + 1) = O(n²)

💾 Space Complexity

O(n) – New lists are created in each iteration, but at most O(n) space is used at any time.