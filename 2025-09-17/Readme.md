🍽️ Problem Name: Food Ratings System

📅 Date:
2025-09-17

📌 Problem Description:

You are given information about a collection of food items, their associated cuisines, and their initial ratings. You need to design a system that:

Allows updating the rating of a food item.

Allows retrieving the highest-rated food item for a specific cuisine.

In the case of a tie in rating, the food with the lexicographically smaller name is preferred.

🧪 Example:
FoodRatings obj = new FoodRatings(
    new String[]{"kimchi", "miso", "sushi", "moussaka", "ramen", "bulgogi"},
    new String[]{"korean", "japanese", "japanese", "greek", "japanese", "korean"},
    new int[]{9, 12, 8, 15, 14, 7}
);

obj.highestRated("korean"); // returns "kimchi"
obj.changeRating("sushi", 16);
obj.highestRated("japanese"); // returns "sushi"

🚀 Approach:

The FoodRatings class is implemented using three main HashMaps and a custom-sorted TreeSet:

🔧 Data Structures Used:

foodToCuisine: Maps each food to its cuisine.

foodToRating: Stores the current rating for each food.

cuisineToSet: Maps each cuisine to a TreeSet of foods, sorted by:

Descending rating

Lexicographical order (for ties)

🔄 Core Methods:

✅ Constructor:
Initializes the data structures and sets up a custom comparator to sort the TreeSet for each cuisine.

🔄 changeRating(String food, int newRating):
Updates the rating of a food.
Re-inserts the food into the sorted TreeSet to maintain order.

🌟 highestRated(String cuisine):
Returns the name of the highest-rated food in a given cuisine.

📊 Complexity Analysis:

-> Constructor	O(N log N)
-> changeRating()	O(log N)
-> highestRated()	O(1)

Where N is the number of food items.

🧠 Key Concepts:

-> Custom sorting using a comparator.
-> Efficient lookups and updates using HashMaps.
-> Balanced binary search tree (TreeSet) for fast retrieval of max elements.