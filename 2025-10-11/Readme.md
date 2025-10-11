📅 Date: 2025-10-11

📌 Problem Description

This C++ class Solution solves a problem of maximizing total damage based on selecting powers from a given list. The constraint is that if you pick a power value x, you cannot pick any powers within x + 1 or x + 2. The goal is to maximize the total damage dealt, calculated as the sum of (power_value * frequency) of chosen powers.

Given an integer array power, where each element represents a power level, the task is to select powers such that no two selected powers differ by less than 3, and the total damage is maximized.

🔧 Method Signature

long long maximumTotalDamage(vector<int>& power);


📥 Input

power: A vector of integers representing the power levels.

Constraints:

1 <= power.size() <= 10^5

Power values are positive integers.

📤 Output

A long long integer representing the maximum total damage that can be achieved by selecting powers according to the problem constraints.

🔁 Approach: Dynamic Programming with Frequency Mapping and Binary Search

The core approach involves:

Counting the frequency of each unique power value.

Sorting the unique powers.

Using recursion with memoization (dp) to decide for each unique power whether to pick it or skip it.

When picking a power, jump to the next power that is at least 3 greater to maintain the problem's constraints.

Use binary search (lower_bound) to find the next valid power index quickly.

Take the maximum damage between picking or skipping the current power.

✅ Strategy:

Map each power to its frequency.

Extract unique powers and sort them.

Use a recursive function with memoization to explore picking vs skipping each power.

Use binary search to efficiently find the next eligible power to pick after the current.

🔢 Step-by-step Logic

Count frequencies of all powers using a map.

Extract and sort unique power values.

Initialize a memoization vector dp with -1 to store intermediate results.

Define a recursive solve function:

If current index i exceeds unique powers, return 0.

If dp[i] is computed, return it.

Use binary search to find the next index where the power is at least uniquePower[i] + 3.

Calculate:

pick: current power damage + recursive solve from the next valid index.

skip: recursive solve for the next index.

Store and return the max of pick and skip.

Return the result from solve(0, ...).

⚙️ Code Breakdown

long long solve(int i, vector<int>& power, map<int,int>& mp, vector<long long>& dp) {
    if (i >= power.size()) return 0;
    if (dp[i] != -1) return dp[i];

    auto it = lower_bound(power.begin(), power.end(), power[i] + 3);
    int index = it - power.begin();

    long long pick = 1LL * power[i] * mp[power[i]] + solve(index, power, mp, dp);
    long long skip = solve(i + 1, power, mp, dp);

    return dp[i] = max(pick, skip);
}


mp[power[i]] gives the frequency of the current power.

lower_bound efficiently jumps to the next valid power index.

dp stores computed results to avoid recomputation.

📦 Data Structures Used

map<int,int>: To count frequencies.

vector<int>: For unique sorted power values.

vector<long long>: For memoization (dp).

📊 Time & Space Complexity

Resource Complexity

-> 🕒 Time	O(n log n) — Sorting + binary searches for each unique power
-> 💾 Space	O(n) — For frequency map, unique powers, and dp array