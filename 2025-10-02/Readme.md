📅 Date: 2025-10-02

📌 Class Description

The `Solution` class provides a method to calculate the total number of bottles that can be drunk, starting with a certain number of full bottles and an initial exchange rate. Unlike the typical fixed-rate exchange, this version models a **dynamic exchange rate** where the number of bottles needed for an exchange increases after each exchange.

This simulates scenarios where the "cost" of obtaining new resources increases over time, perhaps due to inflation, scarcity, or changing rules.

🔧 Method Signature

public int maxBottlesDrunk(int numBottles, int numExchange)

🧠 Internal Logic Summary

📥 Input

- `numBottles` (1 ≤ numBottles ≤ 100):  
  The initial number of full bottles available to drink.

- `numExchange` (1 ≤ numExchange ≤ 100):  
  The initial number of empty bottles required to exchange for one new full bottle.  
  After each successful exchange, the number required increases by 1.

📤 Output

Returns an integer representing the total number of bottles drunk, including those obtained via the dynamic exchange process.

🔁 Approach: Greedy Simulation with Increasing Exchange Rate

This approach simulates the process:

1. Drink all available bottles.
2. Try to exchange empty bottles for new full ones if enough are available.
3. After each exchange, increase the number of empty bottles needed for the next exchange (`numExchange++`).
4. Repeat until not enough empty bottles are left to exchange.

🔢 Step-by-step Logic

- Initialize `count` as `numBottles` to represent all bottles initially drunk.
- Set `empty` as `numBottles` since every full bottle results in one empty bottle.
- While the number of empty bottles is greater than or equal to the current `numExchange`:
  - Subtract `numExchange` from `empty` to simulate the exchange.
  - Increase `numExchange` by 1 (each future exchange costs more).
  - Add one empty bottle for the new bottle just drunk (`empty++`).
  - Increment `count`.

📦 Data Structures Used

- Only simple integer variables (`count`, `empty`, `numExchange`).
- No additional data structures are used.

📊 Time Complexity

-> O(numBottles) – In the worst case, we could go through each bottle one-by-one, especially when `numExchange` starts low and increases slowly.

💾 Space Complexity

-> O(1) – Constant space used regardless of input size.
