🧠 Problem Name: Replace Non-Coprimes in Array

📅 Date:
2025-09-16

📌 Problem Description:

Given an integer array nums, repeatedly combine adjacent elements if they are not coprime (i.e., their GCD > 1). The combination of two such numbers is defined as their Least Common Multiple (LCM).
Continue this process until no further replacements are possible, and return the resulting array.

🧮 Example:

Input:  nums = [6, 4, 3, 2, 7, 6, 2]
Output: [12, 7, 6]
Explanation:

- 6 and 4 → not coprime → replace with LCM(6, 4) = 12 → [12, 3, 2, 7, 6, 2]
- 3 and 2 → coprime → no change
- 2 and 7 → coprime → no change
- 7 and 6 → coprime → no change
- 6 and 2 → not coprime → replace with LCM(6, 2) = 6 → [12, 3, 2, 7, 6]
- Process continues until no adjacent non-coprime pairs remain

🚀 Approach:

We use a stack-based approach to simulate the process of reducing adjacent non-coprime numbers:

Iterate over each number in the array.

While the top of the stack is not coprime with the current number:

Pop the top number.

Replace the current number with their LCM.

Push the updated number onto the stack.

Return the stack as the result.

This greedy approach ensures that we always reduce adjacent non-coprimes as early as possible, and the use of a stack helps handle nested merges efficiently.

📎 Helper Method:

gcd(a, b) using Euclidean algorithm.

📎 LCM formula:

LCM(a, b) = (a / gcd(a, b)) * b

📊 Complexity Analysis:

🕒 Time Complexity	O(N log A) where N is the number of elements in nums, and A is the maximum value in the array (due to GCD computation).
🧠 Space Complexity	O(N) — for the stack that stores the result.