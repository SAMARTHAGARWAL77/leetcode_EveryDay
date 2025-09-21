🎬 Class: MovieRentingSystem

📅 Date:
2025-09-21

📌 Class Description

The MovieRentingSystem simulates a movie rental service where:

Multiple shops offer movies at different prices.

Users can search for the cheapest shop offering a movie.

Users can rent a movie, making it unavailable until returned.

Users can drop (return) a rented movie.

The system can report the top 5 currently rented movies sorted by price, shop, and movie.

This class is ideal for problems involving dynamic availability, search ranking, and state transitions between availability and rentals.

🔧 Constructor
MovieRentingSystem(int n, vector<vector<int>>& entries)


n: Total number of shops (not directly used, but indicates the scale).

entries: Each entry is a vector [shop, movie, price].

Initializes internal data structures and populates the available inventory.

📦 Data Structures Used

map<int, set<pair<int, int>>> available_movies:
Maps a movie ID to a sorted set of {price, shop} pairs, for quick lookup of cheapest shops.

set<tuple<int, int, int>> rented_movies:
Maintains a sorted list of rented movies as {price, shop, movie} tuples for easy reporting.

map<pair<int, int>, int> prices:
Maps a {shop, movie} pair to its price, allowing quick access during rental and drop operations.

🚀 Core Methods
1. vector<int> search(int movie)

🔍 Description:
Returns up to 5 cheapest shops currently offering the given movie.

🛠️ Behavior:

Results are sorted by price and then by shop ID.

Only considers currently available movies (not rented ones).

📤 Returns:
A vector of shop IDs.

2. void rent(int shop, int movie)

🎟️ Description:
Marks a movie as rented from a specific shop.

🛠️ Behavior:

Removes the {price, shop} pair from available_movies.

Adds the {price, shop, movie} to rented_movies.

3. void drop(int shop, int movie)

📦 Description:
Returns a rented movie back to the shop.

🛠️ Behavior:

Removes the tuple from rented_movies.

Re-inserts the movie back into available_movies.

4. vector<vector<int>> report()

📊 Description:
Reports up to 5 currently rented movies, sorted by:

Price

Shop ID

Movie ID

📤 Returns:
A vector of [shop, movie] pairs.

🧠 Internal Logic Summary

The system ensures:

Fast lookup and ranking for available movies.

Sorted tracking of rented movies.

Accurate transitions between availability and rental states.

📊 Complexity Analysis

-> search()	O(log S + 5) per movie ID
-> rent()	O(log S)
-> drop()	O(log S)
-> report()	O(5) from sorted set

Where S is the number of shops with the given movie or number of rented movies (whichever applies).