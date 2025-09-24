📅 Date:
2025-09-24

📌 Class Description
The Solution class provides a method to convert a fraction (given as a numerator and denominator) into its decimal string representation. If the decimal part is repeating, the recurring portion is enclosed in parentheses.

This method is particularly useful in mathematical computations, display formatting, and systems that require precise decimal representations of rational numbers, including recurring decimal detection.

🔧 Method Signature

public String fractionToDecimal(int numerator, int denominator)


🧠 Internal Logic Summary

Handle Zero Numerator

If the numerator is 0, the result is always "0" regardless of the denominator.

Sign Handling

If the fraction is negative (only one of numerator or denominator is negative), prepend "-" to the result.

Conversion to Long for Overflow Safety

Convert numerator and denominator to long before using Math.abs() to safely handle edge cases like Integer.MIN_VALUE.

Integer Part Extraction

Perform integer division (num / den) to get the whole number part and append it to the result.

Fractional Part Start

Calculate the initial remainder (num % den).

If there’s no remainder, the result is a terminating decimal — return the result as is.

Handling Repeating Decimals

Use a HashMap<Long, Integer> to track each remainder and its corresponding index in the result string.

Multiply the remainder by 10 in each step to simulate long division.

If a remainder repeats (found in the map), a repeating decimal cycle is detected.

Insert '(' at the index where this remainder was first seen.

Append ')' at the end and break out of the loop.

📦 Data Structures Used

StringBuilder: Efficiently constructs the resulting string.

Map<Long, Integer>: Tracks remainders and their positions to detect repeating cycles.

📊 Time and Space Complexity

-> 🕒 Time: O(n)
Where n is the length of the repeating cycle or the number of digits in the decimal part.
-> 🧠 Space: O(n)
For the map storing remainders and their corresponding indices