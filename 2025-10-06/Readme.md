📅 Date: 2025-10-06

📌 Problem Description

This Java class provides an implementation of the "Swim in Rising Water" problem (LeetCode #778).

You're given an n x n integer grid where grid[i][j] represents the elevation at point (i, j). You start at the top-left cell (0, 0), and your goal is to reach the bottom-right cell (n-1, n-1) as quickly as possible.

At time t, you can swim into any cell with elevation ≤ t. You can move in 4 directions (up, down, left, right), and can only move to a square once its elevation is ≤ the current time.

The goal is to find the minimum time t such that you can reach the bottom-right cell.

🔧 Method Signature
public int swimInWater(int[][] grid)

📥 Input

A 2D square matrix grid of size n x n representing elevations.

Constraints:

1 <= n <= 50

0 <= grid[i][j] < n²

All values in grid are distinct

📤 Output

An integer representing the minimum time t to reach the bottom-right corner from the top-left corner.

🔁 Approach: Modified Dijkstra's Algorithm with Min-Heap (PriorityQueue)

This problem can be modeled as a pathfinding problem on a weighted grid, where the cost to step into a cell is its elevation.

✅ Strategy:

Use a PriorityQueue (min-heap) to always expand the cell with the lowest elevation that is currently reachable.

Keep track of visited cells to avoid revisiting.

Track the maximum elevation seen along the current path — this represents the minimum "time" required to reach the current cell.

Stop when we reach the bottom-right corner.

🔢 Step-by-step Logic

Initialize:

A min-heap PriorityQueue that stores (elevation, x, y) triplets.

A visited boolean matrix.

Movement directions: up, down, left, right.

Start from (0,0):

Add it to the heap.

Mark as visited.

While the heap is not empty:

Pop the cell with the lowest elevation.

Update the maxElevation (time so far).

If the target (n-1, n-1) is reached, return maxElevation.

Add all valid, unvisited neighbors to the heap.

⚙️ Code Breakdown
PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
pq.offer(new int[]{grid[0][0], 0, 0});


Min-heap to always expand the lowest elevation cell.

int[][] dirs = {{0,-1}, {0,1}, {-1,0}, {1,0}};


Direction vectors for grid movement.

maxElevation = Math.max(maxElevation, elevation);


Tracks the time needed so far (the highest elevation along the path).

📦 Data Structures Used

PriorityQueue<int[]>: for greedy traversal by elevation.

boolean[][] visited: to avoid revisiting.

int[][] dirs: for directional movement.

📊 Time & Space Complexity

-> 🕒 Time	O(n² * log n)
-> 💾 Space	O(n²)