📅 Date: 2025-10-07

📌 Problem Description

This Java class provides an implementation of the "Avoid Flood in The City" problem (LeetCode #1488).

You're given an array rains, where rains[i] > 0 means it rains over lake rains[i] on day i, and rains[i] == 0 means it's a dry day where you can choose to dry any lake.

The goal is to avoid any lake from flooding. A lake floods if it rains on it when it's already full and hasn't been dried yet.

You need to return an array ans of length n:

If it rains on day i, set ans[i] = -1

If it's a dry day, set ans[i] to the lake number you chose to dry

If it's not possible to avoid a flood, return an empty array.

🔧 Method Signature
public int[] avoidFlood(int[] rains)

📥 Input

An array of integers rains of length n:

rains[i] > 0: it rains on lake rains[i] on day i

rains[i] == 0: a dry day — you may choose one lake to dry

Constraints:

1 <= rains.length <= 10^5

0 <= rains[i] <= 10^9

📤 Output

An integer array ans of length n:

-1 for rainy days

The lake number to dry for dry days

Return [] if it’s impossible to prevent a flood

🔁 Approach: Greedy + TreeSet + HashMap

This problem is solved using a greedy approach. The key idea is:

Keep track of the last day each lake was filled using a HashMap.

Use a TreeSet to store available dry days.

When a lake is about to be filled again, use the earliest available dry day after its last fill to dry it before it floods.

🔢 Step-by-step Logic

Initialize:

lakeMap: stores last day a lake was rained on

drylake: a TreeSet of indices of dry days

ans: result array

Iterate through rains[]:

If rains[i] == 0:

Add index i to drylake

Set ans[i] = 1 by default (will update later if needed)

If rains[i] > 0:

Set ans[i] = -1

If the lake already exists in lakeMap (i.e., already full):

Look for the earliest dry day after its last rain day using drylake.higher(lastRainDay)

If none exists → return [] (flood can't be avoided)

Else:

Set that dry day to dry this lake

Remove that day from drylake

Update lakeMap with the current day for this lake

⚙️ Code Breakdown
HashMap<Integer,Integer> lakeMap = new HashMap<>();
TreeSet<Integer> drylake = new TreeSet<>();


lakeMap: tracks last day each lake was filled

drylake: keeps track of available dry days in sorted order

if (rains[i] == 0) {
    drylake.add(i);
    ans[i] = 1;
}


Default value 1 for dry days (arbitrary — will change if needed)

if (lakeMap.containsKey(lake)) {
    int lastRainDay = lakeMap.get(lake);
    Integer dryday = drylake.higher(lastRainDay);
    if (dryday == null)
        return new int[0]; // Can't prevent flood
    ans[dryday] = lake;
    drylake.remove(dryday);
}
lakeMap.put(lake, i);


Greedily use the earliest dry day after last rain to prevent flood

📦 Data Structures Used

HashMap<Integer, Integer>: Tracks the last rain day for each lake

TreeSet<Integer>: Stores dry days to efficiently find the next available dry day

int[] ans: Final output array

📊 Time & Space Complexity

-> 🕒 Time	O(n log n)
-> 💾 Space	O(n)