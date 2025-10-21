📅 Date: 2025-10-21

📌 Problem Description

You are given a string array operations where each element is one of the following:

"++X"

"X++"

"--X"

"X--"

Each operation increments or decrements a variable x starting at 0.

"++X" and "X++" increment the value of x by 1.

"--X" and "X--" decrement the value of x by 1.

The task is to evaluate the final value of x after performing all operations in sequence.

🔧 Method Signature
int finalValueAfterOperations(String[] operations)

🛠 Core Concepts Used

Basic String Comparison

Simple Looping and Conditional Logic

Understanding of Increment/Decrement Operations

🔢 Step-by-Step Breakdown
✅ Step 1: Initialize Variable

Start by initializing an integer x to 0, which represents the initial value before any operations.

int x = 0;

✅ Step 2: Iterate Through Each Operation

Loop through each string in the input array operations. For each operation:

If it is "++X" or "X++" → increment x.

Otherwise (i.e., "--X" or "X--") → decrement x.

for (String op : operations) {
    if ("X++".equals(op) || "++X".equals(op)) {
        x++;
    } else {
        x--;
    }
}


This works because the four valid strings only differ in order, not in meaning.

✅ Step 3: Return Final Value

After all operations have been processed, return the resulting value of x.

return x;

📊 Time and Space Complexity

-> 🕒 Time Complexity: O(n)
Where n is the number of operations. Each operation is checked and processed in constant time.

-> 💾 Space Complexity: O(1)
No additional space is used apart from a counter.