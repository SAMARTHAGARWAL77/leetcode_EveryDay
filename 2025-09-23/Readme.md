📅 Date:
2025-09-23

📌 Class Description
The Solution class provides a method to compare two version numbers represented as strings. Version numbers are sequences of integers separated by dots (.), such as "1.01" or "1.0.3".

This method is particularly useful in software version management, where updates and releases are identified by version numbers, and it's necessary to determine which version is newer, older, or if they are equal.

🔧 Method Signature

public int compareVersion(String version1, String version2)


🧠 Internal Logic Summary

Split by Delimiter
Both version strings are split into parts using "." as the delimiter.
For example: "1.0.1" becomes ["1", "0", "1"].

Normalize Length
To ensure fair comparison, the method loops up to the longer of the two version arrays. Missing parts are treated as 0.
This handles cases like "1.0" vs "1.0.0" correctly.

Compare Parts
Each corresponding part is converted to an integer and compared:

If v1[i] < v2[i], return -1

If v1[i] > v2[i], return 1

Continue if equal

Final Result
If all parts are equal, return 0 (versions are the same).

📦 Data Structures Used

String[]: To store the split version parts.

Primitive int: To convert and compare version segments.

📊 Time and Space Complexity

-> 🕒 Time	O(max(n, m))
-> 🧠 Space	O(n + m)

Where:

n is the number of segments in version1
m is the number of segments in version2