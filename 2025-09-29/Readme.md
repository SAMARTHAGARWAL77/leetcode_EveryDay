📅 Date: 2025-09-29
📌 Class Description

The Solution class provides a method to determine the minimum score of triangulating a convex polygon, where each vertex has an associated integer value. The score of a triangle is the product of the values of its three vertices, and the total triangulation score is the sum of all triangle scores formed.

The core concept is derived from Dynamic Programming with Memoization — solving smaller subproblems (sub-polygons) and combining their results to solve the larger problem optimally.

🔧 Method Signature

public int minScoreTriangulation(int[] values)


🧠 Internal Logic Summary

📥 Input
An integer array values of length n (with n ≥ 3), where each element represents the value at a vertex of a convex polygon.

📤 Output
An integer representing the minimum possible total score of triangulating the polygon.

🛠 Approach: Recursive DP with Memoization

This solution uses top-down dynamic programming to avoid redundant recalculations. It defines a recursive helper function helper(i, j) that computes the minimum triangulation score for the sub-polygon from vertex i to vertex j.

🔢 Step-by-step Logic

Base Case
If the sub-polygon has fewer than 3 vertices (j - i + 1 < 3), it cannot form a triangle, so the score is 0.

Memoization Check
If the value for memo[i][j] is already computed, return it to avoid recomputation.

Recursive Triangulation
For each possible vertex k between i and j, calculate:

Score of triangle (i, k, j) → values[i] * values[k] * values[j]

Plus recursively computed scores for the left and right sub-polygons:
helper(i, k) and helper(k, j)

Take the minimum among all possible triangulation paths and store it in memo[i][j].

Return the final result from helper(0, n-1).

📦 Data Structures Used

int[][] memo: 2D array for memoization of subproblem results.

Recursive stack for function calls (implicit space).

📊 Time and Space Complexity

🕒 Time Complexity:

-> O(n³) — There are O(n²) subproblems (i and j pairs), and each may iterate through up to O(n) values of k.

-> O(n²) for the memoization table, plus O(n) recursion depth on the call stack.