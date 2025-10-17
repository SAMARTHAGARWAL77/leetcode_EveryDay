📅 Date: 2025-10-17

📌 Problem Description

You are given a string s and an integer k. The task is to partition the string into the maximum number of substrings such that:

Each substring contains at most k distinct characters.

You are allowed to change at most one character in the entire string to any other lowercase English letter (a–z).

The goal is to compute the maximum number of such valid substrings after optionally changing one character.

🔧 Method Signature
int maxPartitionsAfterOperations(string s, int k);

🛠 Core Concepts Used

Bitmasking to track unique characters

Dynamic Programming with memoization

Recursive exploration with branching

State compression using bit manipulation

🔢 Step-by-Step Breakdown
✅ Step 1: Understand the Constraints

Each substring must have ≤ k distinct letters.

At most one character change is allowed across the string.

Try to greedily maximize partitions based on valid groups.

✅ Step 2: Recursive State Representation

The recursive solve function is defined by the state:

i: current index in string s

mask: bitmask representing unique characters in current substring

change: whether a character change has been used (0 or 1)

k: maximum allowed unique characters

Memoization with a compressed key:

currState = (i << 27) | (mask << 1) | change

✅ Step 3: Base and Recursive Cases

Base Case: If i == s.size(), a valid end is reached. Return 1.

Recursive Case:

If adding current character exceeds k distinct characters:

Start a new partition and recurse.

Else:

Continue with current partition.

If change == 0: Try all possible substitutions at this index (simulate 1 character change) and compute maximum.

✅ Step 4: Memoization

Use an unordered_map<long long, int> to memoize previously computed states for efficiency.

This avoids recomputation across overlapping subproblems.

📊 Time and Space Complexity

-> 🕒 Time	O(n * 2^k * 26) (approximation due to bitmask and branching)
-> 💾 Space	O(n * 2^k) (for memoization map)