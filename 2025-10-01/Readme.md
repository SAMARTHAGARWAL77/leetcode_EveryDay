📅 Date: 2025-10-01

📌 Class Description

The Solution class provides a method to calculate the total number of water bottles one can drink given an initial number of full bottles and a rule that allows exchanging empty bottles for new full ones. This problem simulates a greedy consumption-exchange loop, where you continue drinking and exchanging as long as possible.

This models scenarios like recycling or reward systems, where used items (empty bottles) can be turned in for new items (full bottles) at a fixed exchange rate.

🔧 Method Signature

public int numWaterBottles(int numBottles, int numExchange)


🧠 Internal Logic Summary

📥 Input

numBottles (1 ≤ numBottles ≤ 100)

The initial number of full water bottles.

numExchange (2 ≤ numExchange ≤ 100)

The number of empty bottles required to get one full bottle in exchange.

📤 Output

Returns a single integer representing the total number of bottles drunk, including those obtained via exchange.

🔁 Approach: Greedy Simulation of Exchange Process

The solution continuously drinks and exchanges bottles in a loop:

Drink all full bottles → this contributes to the count.

Exchange empty bottles for as many full ones as possible.

Repeat the process until not enough empty bottles remain for an exchange.

🔢 Step-by-step Logic

Initialize count as numBottles (you start by drinking all of them).

While numBottles is greater than or equal to numExchange:

Compute how many new full bottles can be obtained via exchange.

Add the number of exchanged bottles to count.

Update numBottles:

Remaining empty bottles (numBottles % numExchange)

Plus the newly obtained full bottles.

Return count as the final total of bottles drunk.

📦 Data Structures Used

Simple integer variables – no complex data structures are required.

📊 Time Complexity

O(log(numBottles))
Each iteration significantly reduces the number of bottles, so the loop runs approximately log-scale with respect to numBottles.

💾 Space Complexity

O(1) – Constant space used; no extra memory allocations