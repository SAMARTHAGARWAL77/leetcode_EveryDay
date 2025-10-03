📅 Date: 2025-10-03

📌 Class Description

The Solution class implements an algorithm to calculate how much water can be trapped on a 2D height map after raining. This is an advanced version of the 1D "Trapping Rain Water" problem, extended to a grid where water can be trapped from all four directions.

A custom cell class is used to represent each cell in the grid, containing its height and position. It also supports comparison to simulate a min-heap behavior using C++'s default max-heap priority_queue.

🔧 Method Signature
int trapRainWater(vector<vector<int>>& heightMap);

📥 Input

heightMap: A 2D vector (rows x cols) where each entry heightMap[i][j] represents the elevation at position (i, j).

📤 Output

Returns an int representing the total units of water trapped after rainfall.

🧠 Algorithm Overview: Min Heap + BFS Flood Fill

The algorithm follows a flood-fill approach from the boundary inward, always processing the lowest-height boundary first, similar to Dijkstra’s algorithm for shortest paths.

🧱 Key Observations

Water can only be trapped if it's surrounded by higher boundaries.

The outermost cells form the initial boundary (they can’t trap water themselves).

By always expanding from the lowest current boundary cell, we ensure that trapped water is bounded correctly.

🔢 Step-by-step Logic

Initialize the Min Heap (Priority Queue):

Push all the border cells (edges of the grid) into a min-heap (priority_queue<cell>).

Mark these border cells as visited (to avoid revisiting).

Perform Flood Fill:

While the heap is not empty:

Pop the cell with the lowest height.

Check its 4 neighbors (up, down, left, right).

If a neighbor hasn’t been visited:

Water can be trapped if the neighbor is lower than the current cell.

The amount of water is max(0, curr.height - neighbor.height).

Push the neighbor into the heap with an effective height of max(curr.height, neighbor.height) to simulate the updated boundary.

Accumulate the Water:

Sum all units of water trapped in each valid lower neighbor cell.

🧱 Data Structures Used

priority_queue<cell> — Min-heap to process the cell with the lowest boundary height first.

vector<vector<bool>> visited — Tracks which cells have already been processed.

vector<vector<int>> — The original height map grid.

⏱️ Time Complexity

-> O(m * n * log(mn)) - Each cell is visited once & Each heap operation takes log(mn) time.

💾 Space Complexity

-> O(m * n) - For the visited matrix and the heap storing up to m * n cells