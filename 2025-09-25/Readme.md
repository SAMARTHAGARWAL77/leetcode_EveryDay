📅 Date:
2025-09-25

📌 Class Description

The Solution class contains a method to solve the Triangle Minimum Path Sum problem. Given a triangle represented as a list of lists of integers, the method computes the minimum path sum from the top to the bottom. At each step, you may move to adjacent numbers on the row below.

This method is frequently encountered in dynamic programming challenges and is valuable in optimization scenarios that involve hierarchical or staged decision-making.

🔧 Method Signature
public int minimumTotal(List<List<Integer>> triangle)

🧠 Internal Logic Summary
📥 Input

A List<List<Integer>> representing a triangle structure.

Each list within the triangle represents a row of the triangle.

🛠 Approach: Bottom-Up Dynamic Programming

Initialization
Create a 2D dp array with dimensions n x n, where n is the number of rows in the triangle.
Fill the last row of the dp table with values from the last row of the triangle.

Bottom-Up Transition
Iterate from the second-last row upwards. For each element at position (i, j), calculate the minimum path sum by adding the current value to the minimum of the two adjacent values in the row below:

dp[i][j] = triangle[i][j] + min(dp[i+1][j], dp[i+1][j+1])


Result
The minimum total path sum is stored at dp[0][0] after the loop finishes.

📦 Data Structures Used

int[][] dp: A 2D array to store intermediate minimum path sums for subproblems.

# List<List<Integer>>: To represent the triangle input.

📊 Time and Space Complexity

-> 🕒 Time	O(n²)
-> 🧠 Space	O(n²)