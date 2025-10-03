class cell {
public:
    int height;
    int row, col;

    cell(int h, int r, int c) : height(h), row(r), col(c) {}

    int getHeight() const { return height; }
    int getRow() const { return row; }
    int getCol() const { return col; }

    bool operator<(const cell& other) const {
        return height > other.height;
    }
};

class Solution {
public:
    int trapRainWater(vector<vector<int>>& heightMap) {
        int rows = heightMap.size(), cols = heightMap[0].size();
        if (rows == 0 || cols == 0) return 0;

        int water = 0;
        vector<vector<bool>> visited(rows, vector<bool>(cols, false));
        priority_queue<cell> pq;

        // Initialize the boundary cells
        for (int i = 0; i < rows; ++i) {
            pq.push(cell(heightMap[i][0], i, 0));
            pq.push(cell(heightMap[i][cols - 1], i, cols - 1));
            visited[i][0] = visited[i][cols - 1] = true;
        }
        for (int j = 0; j < cols; ++j) {
            pq.push(cell(heightMap[0][j], 0, j));
            pq.push(cell(heightMap[rows - 1][j], rows - 1, j));
            visited[0][j] = visited[rows - 1][j] = true;
        }

        // Directions for moving up, down, left, right
        int dR[4] = {0, 0, -1, 1};
        int dC[4] = {-1, 1, 0, 0};

        // Process the cells
        while (!pq.empty()) {
            cell curr = pq.top();
            pq.pop();

            for (int d = 0; d < 4; ++d) {
                int r = curr.getRow() + dR[d];
                int c = curr.getCol() + dC[d];

                if (r >= 0 && r < rows && c >= 0 && c < cols && !visited[r][c]) {
                    visited[r][c] = true;
                    water += max(0, curr.getHeight() - heightMap[r][c]);
                    // curr.getHeight() is the current cell you are in is greater/equal than the heightMap[r][c] 
                    // your neighbouring cell then we substract else we will store zero
                    pq.push(cell(max(curr.getHeight(), heightMap[r][c]), r, c));
                }
            }
        }

        return water;
    }
};