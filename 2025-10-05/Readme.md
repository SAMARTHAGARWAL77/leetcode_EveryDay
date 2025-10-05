📅 Date: 2025-10-05

📌 Class Description

The Solution class provides a method to solve the Pacific Atlantic Water Flow problem. Given an m x n matrix of heights, it determines which grid cells can allow water to flow to both the Pacific and Atlantic oceans. Water can flow from a cell to another if the next cell has an equal or lower height and is directly adjacent (up, down, left, or right).

This problem is a classic graph traversal challenge with reverse flow simulation using Depth-First Search (DFS).

🔧 Method Signature
public List<List<Integer>> pacificAtlantic(int[][] heights)

🧠 Internal Logic Summary
📥 Input

A 2D matrix heights of size m x n representing the elevation at each cell.

Constraints:

1 <= m, n <= 200

0 <= heights[i][j] <= 10⁵

📤 Output

A list of coordinate pairs (as [row, col]) representing all cells from which water can flow to both the Pacific and Atlantic oceans.

🔁 Approach: DFS Reverse Flow Simulation

Instead of simulating water flow from every cell outward, we reverse the flow direction: we simulate water coming in from both oceans and mark reachable cells.

Pacific touches the top and left edges.

Atlantic touches the bottom and right edges.

We use DFS traversal starting from the borders of each ocean to determine which cells can be reached by each. The intersection of these reachable sets gives the final answer.

🔢 Step-by-step Logic

Initialize two boolean matrices pacific and atlantic of the same size as heights to track visited cells.

Run DFS from all Pacific-bordering cells (first row and first column).

Run DFS from all Atlantic-bordering cells (last row and last column).

After filling the reachable maps for both oceans, collect the coordinates where both pacific[i][j] and atlantic[i][j] are true.

⚙️ DFS Helper Method
public void dfs(int[][] heights, int i, int j, int prevHeight, boolean[][] ocean)


Base Cases:

Out of bounds.

Height drops (not non-increasing).

Already visited.

Recursive Case:

Mark current cell as visited.

Visit all 4 neighboring directions.

📦 Data Structures Used

boolean[][] pacific and boolean[][] atlantic: track reachability.

int[][] dirs: represents 4-directional movement (up, down, left, right).

List<List<Integer>> res: stores result coordinates.

-> 📊 Time Complexity

O(m × n):

Each cell is visited at most twice (once per ocean).

DFS runs in linear time relative to matrix size.

-> 💾 Space Complexity

O(m × n):

For the two visited matrices (pacific and atlantic).

Plus recursion stack space in worst case (can go up to O(m × n) depth in skewed matrices).