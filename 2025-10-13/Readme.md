📅 Date: 2025-10-13

📌 Problem Description

You are given an array of strings words, where each element is a lowercase string.

Your task is to remove consecutive anagrams, keeping only the first occurrence in each group of anagrams that appear consecutively.

An anagram is a word formed by rearranging the letters of another, such as "listen" and "silent".

🔧 Method Signature
public List<String> removeAnagrams(String[] words)

🛠 Core Concepts Used

✅ String Manipulation

✅ Sorting Characters of a String

✅ Comparing Arrays

✅ Basic List Operations

🔢 Step-by-Step Breakdown

Initialization:
Create an empty list res to store the resulting non-anagram words. Add the first word in the input array to res.

Iterate through the words:
For each subsequent word in the array, compare it with the last word added to the result list.

Check for Anagram:
Use a helper method isAnagram(String a, String b) to determine if the current word is an anagram of the previous one:

Convert both words to character arrays

Sort both arrays

Compare using Arrays.equals

Filter Non-Anagrams:
If the current word is not an anagram of the last word added, append it to res.

Return the Final List.

📊 Time and Space Complexity

-> 🕒 Time	O(n * k log k)
    Where n = number of words, k = average length of each word (due to sorting)
-> 💾 Space	O(n * k)
    For storing the result list and temporary character arrays