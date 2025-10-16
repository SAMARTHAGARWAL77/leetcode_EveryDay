📅 Date: 2025-10-16

📌 Problem Description

Given an array of integers nums and an integer value, the task is to find the minimum non-negative integer (mex, or Minimum EXcluded number) that is not present in the array after adjusting each number by its modulo value and counting how many times each residue class appears.

You are allowed to remove an occurrence of a number from the set if that residue class has already appeared enough times. The goal is to simulate filling up numbers from 0 upwards using available modulo classes.

🔧 Method Signature

public int findSmallestInteger(int[] nums, int value);


🛠 Core Concepts Used

Modular Arithmetic

Counting Frequency Buckets

Greedy Simulation of MEX

Mathematical Normalization of Negative Modulo

🔢 Step-by-Step Breakdown

✅ Step 1: Normalize Modulo Values

For each number in nums, compute its normalized modulo:

mod = ((num % value) + value) % value;


This handles negative numbers correctly so that the modulo is always between 0 and value - 1.

Store counts in a count[] array of size value.

✅ Step 2: Simulate MEX Greedily

Start from mex = 0.

While a number with modulo mex % value still exists (i.e., count[mod] > 0), consume one occurrence and move to the next number.

Stop when a required modulo count is zero — meaning mex cannot be formed with the given numbers.

✅ Step 3: Return the Result

Return the smallest integer that couldn't be formed, i.e., the final value of mex.

📊 Time and Space Complexity

Metric	Complexity

-> 🕒 Time	O(n) — where n is the length of nums
-> 💾 Space	O(value) — for the frequency count array