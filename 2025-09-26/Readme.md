📅 Date:
2025-09-26

📌 Class Description

The Solution class provides an efficient method to solve the Valid Triangle Number problem. Given an array of non-negative integers representing the side lengths of triangles, the method counts how many triplets can form a valid triangle.

A triplet (i, j, k) forms a valid triangle if and only if the sum of any two sides is greater than the third side.

This problem is a classic example of a two-pointer technique combined with sorting, optimizing brute-force triple-loop solutions to near-quadratic time complexity.

🔧 Method Signature
int triangleNumber(vector<int>& nums);

🧠 Internal Logic Summary
📥 Input

A vector<int> containing side lengths of potential triangles.

🛠 Approach: Sorting + Two Pointers
🔢 Step-by-step Logic

Sort the array

This allows us to check the triangle inequality efficiently.

sort(nums.begin(), nums.end());


Fix the largest side (nums[k])

Iterate from the end of the array down to index 2.

Use Two Pointers (i and j)

Initialize i = 0, j = k - 1.

While i < j:

If nums[i] + nums[j] > nums[k], then all values from i to j-1 form valid triangles with j and k.

Increment count by (j - i), and move j leftward.

Else, move i rightward to try larger values.

📦 Data Structures Used

vector<int>: To store the input side lengths.

Simple integer variables for counting and indexing.

📊 Time and Space Complexity

-> 🕒 Time	O(n²) (due to nested two-pointer traversal)
-> 🧠 Space	O(1) (in-place sorting and constant extra space)

Sorting takes O(n log n), but the dominant two-pointer loop is O(n²), making total time complexity O(n²)