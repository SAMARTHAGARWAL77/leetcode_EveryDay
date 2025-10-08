📅 Date: 2025-10-08

📌 Problem Description

This Java class solves the “Successful Pairs of Spells and Potions” problem (LeetCode #2300).

You're given two integer arrays spells and potions, and a long integer success. A spell and a potion form a successful pair if the product of their strengths is at least success.

Return an integer array ans of length spells.length where ans[i] is the number of potions that will form a successful pair with spells[i].

🔧 Method Signature

public int[] successfulPairs(int[] spells, int[] potions, long success)


📥 Input

spells: An integer array of length s (1 ≤ s ≤ 10⁵)

potions: An integer array of length p (1 ≤ p ≤ 10⁵)

success: A long integer representing the minimum product threshold

📤 Output

An integer array ans of length s where ans[i] is the number of potions that can pair with spells[i] such that spell * potion ≥ success

🔁 Approach: Sorting + Binary Search

This problem is efficiently solved using sorting and binary search. The core idea:

Sort the potions array

For each spell, calculate the minimum potion strength required to meet or exceed the success threshold

Use binary search to find the first index in potions where the potion strength is ≥ required strength

All potions from that index onward form a valid pair with the current spell

🔢 Step-by-step Logic

Sort the potions array in ascending order

Iterate through each spell:

Calculate the minimum required potion strength using Math.ceil((double) success / spell)

Perform a binary search on the sorted potions array to find the first valid index

Subtract that index from total potions length to get the number of successful pairs

Store the count in the result array

⚙️ Code Breakdown

Arrays.sort(potions); // Sort potions for binary search
for (int i = 0; i < spells.length; i++) {
    long requiredPotion = (long) Math.ceil((double) success / spells[i]);
    int index = binarySearch(potions, requiredPotion);
    ans[i] = potions.length - index; // All potions from index onward are valid
}


🧠 Binary Search Helper Function

private int binarySearch(int[] potions, long threshold) {
    int low = 0, high = potions.length - 1, ans = potions.length;
    while (low <= high) {
        int mid = low + (high - low) / 2;
        if (potions[mid] >= threshold) {
            ans = mid;
            high = mid - 1;
        } else {
            low = mid + 1;
        }
    }
    return ans;
}


📦 Data Structures Used

int[] ans: Stores the result for each spell

int[] potions: Sorted to allow binary search

No extra complex data structures used — memory efficient

📊 Time & Space Complexity

Complexity	Description

-> 🕒 Time	O(p log p + s log p) — where p is potions.length, s is spells.length
-> 💾 Space	O(s) — to store the output array ans