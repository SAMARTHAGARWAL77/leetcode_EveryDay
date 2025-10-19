📅 Date: 2025-10-18
📌 Problem Description

You are given a string s consisting of digits and two integers a and b. The goal is to find the lexicographically smallest string that can be obtained by performing any combination of two operations:

Add Operation: For each odd-indexed digit, increase its value by a (mod 10).

Rotate Operation: Rotate the string s by b positions to the right.

You must perform these operations as many times as necessary, but only once at a time for each operation.

The task is to determine the lexicographically smallest string that can be generated after applying any combination of the operations.

🔧 Method Signature
public String findLexSmallestString(String s, int a, int b);

🛠 Core Concepts Used

Breadth-First Search (BFS): To explore all possible strings generated from s using the given operations.

Queue: Used to maintain a list of strings that can be processed.

Set: To track visited strings and prevent unnecessary recalculations.

String Manipulation: Modifying the string's digits and rotating the string based on the operations.

🔢 Step-by-Step Breakdown
✅ Step 1: Initialize the BFS Queue and Visited Set

Start with the string s and initialize a queue to explore all possible states (generated strings).

Create a HashSet to track visited strings and avoid cycles.

Queue<String> q = new LinkedList<>();
Set<String> vis = new HashSet<>();
String ans = s;

✅ Step 2: Perform BFS to Generate All Possible Strings

While the queue is not empty, process the current string.

For each string, apply the following operations:

Add Operation: Modify every odd-indexed digit by adding a (mod 10).

Rotate Operation: Rotate the string by b positions to the right.

For both operations, check if the new string has already been visited. If not, add it to the queue and mark it as visited.

String addOp = applyAddOperation(curr, a);
if (vis.add(addOp)) q.offer(addOp);

String rotateOp = applyRotateOperation(curr, b);
if (vis.add(rotateOp)) q.offer(rotateOp);

✅ Step 3: Track the Lexicographically Smallest String

During the BFS process, compare the current string with the smallest string found so far and update if necessary.

if (curr.compareTo(ans) < 0) ans = curr;

✅ Step 4: Return the Lexicographically Smallest String

Once all possibilities have been explored, return the lexicographically smallest string.

return ans;

📊 Time and Space Complexity

-> Time Complexity: O(N * M), where N is the number of unique strings explored, and M is the length of the string s. Each operation (add and rotate) takes O(M) time to process.

-> Space Complexity: O(N * M) due to the queue and the visited set storing all possible strings.