🧮 Spreadsheet System

📅 Date:
2025-09-19

📌 Problem Description

You're building a simple Spreadsheet system that supports basic functionalities:

Store integer values in spreadsheet cells (e.g., A1, B2, etc.).

Reset a specific cell (remove its value).

Evaluate simple formulas consisting of two operands added together.

Handle both literal integers and references to other cells in formulas.

🧪 Example
Spreadsheet sheet = new Spreadsheet(5);

sheet.setCell("A1", 10);
sheet.setCell("B2", 20);

int result = sheet.getValue("=A1+B2");  // returns 30

sheet.resetCell("A1");

result = sheet.getValue("=A1+B2");      // returns 20 (A1 is now 0)

🚀 Approach

The Spreadsheet class uses a HashMap<String, Integer> to store the values of non-empty cells, allowing O(1) access for retrieval and updates.

The formula parser currently supports a single addition of two terms, which can be either:

A cell reference (e.g., A1, B2)

A literal integer (e.g., 5, 100)

🔧 Data Structures Used

HashMap<String, Integer> cells:
Stores values of each non-empty cell. Key is cell name ("A1"), value is integer content.

Integer rows:
Represents the number of rows in the spreadsheet (currently unused but could be extended).

🔄 Core Methods
✅ Constructor
Spreadsheet(int rows)


Initializes the spreadsheet with a given number of rows.

➕ setCell(String cell, int value)

Sets or updates the value of a given cell.

❌ resetCell(String cell)

Removes the specified cell from the map, treating it as empty.
Future references to this cell will default to 0.

🧮 getValue(String formula) -> int

Evaluates a basic formula starting with '=', assuming exactly two operands separated by '+'.

If an operand is a number → used as-is.

If it's a cell reference → its value is fetched (defaults to 0 if not found).

Example input: =A1+5 or =B2+C3

🔍 private int get(String s)

Helper function that:

Parses a string as integer if possible.

Otherwise, fetches the cell value from cells map.

Defaults to 0 if the cell is empty.

📊 Time Complexity

-> setCell O(1)
-> resetCell O(1)
-> getValue	O(1)

🧠 Key Concepts

-> Graceful fallbacks: Empty or missing cells are treated as having value 0.
-> Simple formula parsing: Only supports a single + operation with two operands.
-> Robust parsing: Handles both numeric literals and cell references safely.

🛠️ Limitations & Future Enhancements

-> Only handles formulas of the form: =X+Y (no subtraction, multiplication, chaining, or parentheses).
-> Does not validate cell names ("A1", "Z9", etc.) beyond using them as strings.
-> Row count (rows) is currently unused; could be integrated for bounds checking or range functions