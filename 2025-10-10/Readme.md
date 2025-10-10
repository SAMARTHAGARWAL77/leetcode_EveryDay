📅 Date: 2025-10-10

📌 Problem Description

This Java class provides an implementation of a custom problem involving energy accumulation with fixed-step backward traversal.

Given an integer array energy and an integer k, you are allowed to start from any of the last k positions in the array and move backwards in steps of k, summing the values along the way. The goal is to find the maximum energy that can be accumulated using this approach.

🔧 Method Signature

public int maximumEnergy(int[] energy, int k)


📥 Input

energy: An integer array representing energy values at each position.

k: An integer step size for backward movement.

Constraints:

1 <= energy.length <= 10^5

-10^4 <= energy[i] <= 10^4

1 <= k <= energy.length

📤 Output

An integer representing the maximum total energy that can be collected by starting from any of the last k positions and moving backwards in steps of size k.

🔁 Approach: Reverse Step-wise Accumulation

The core idea is to simulate backward jumps from the last k positions of the array and calculate the accumulated energy along each such path. The algorithm selects the path that results in the highest total energy.

✅ Strategy:

Loop over all valid starting positions: the last k indices in the array.

For each starting position, move backwards in steps of size k, summing energy values.

Track the maximum energy accumulated from all such paths.

🔢 Step-by-step Logic

Initialize maxEnergy to Integer.MIN_VALUE.

For i = 0 to k - 1:

Start a running sum currentSum = 0.

Traverse from the last index n - 1 to the front, stepping by -k each time, adjusting for offset i.

At each step, add the energy value at the corresponding index.

Update maxEnergy with the highest sum seen so far.

Return maxEnergy.

⚙️ Code Breakdown

for (int i = 0; i < k; i++) {
    int currentSum = 0;
    for (int j = n - 1; j - i >= 0; j -= k) {
        currentSum += energy[j - i];
        maxEnergy = Math.max(maxEnergy, currentSum);
    }
}


i determines the offset from the end to start collecting energy.

j - i adjusts the actual index to access from the array.

currentSum accumulates energy along the current backward path.

maxEnergy keeps track of the best result among all paths.

📦 Data Structures Used

Primitive variables only (int): For performance and simplicity.

No extra memory structures needed—constant space complexity.

📊 Time & Space Complexity

Resource	Complexity
-> 🕒 Time	O(n) — each element is visited at most once
-> 💾 Space	O(1) — no additional space used apart from variables