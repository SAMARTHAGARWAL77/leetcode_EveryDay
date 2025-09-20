📡 Class: Router

📅 Date:
2025-09-20

📌 Class Description:

The Router class simulates a simple memory-limited packet router that:

Accepts packets with a (timestamp, source, destination).

Tracks recent packets up to a specified memory limit.

Prevents duplicate packets with the same (source, destination) arriving in the same timestamp batch.

Supports forwarding packets in FIFO order.

Provides count of packets sent to a destination within a time window.

This class is useful for network simulation, event streaming, or memory-bounded packet processing systems.

🔧 Constructor:
Router(size_t memoryLimit)


memoryLimit: The maximum number of packets the router can hold at any time.

📦 Data Structures Used:

deque<int3> q: Stores packets in the form (timestamp, source, destination).

unordered_map<int, deque<int>> byDest: Maps each destination to a queue of timestamps, for efficient time-range queries.

unordered_set<long long> seen: Keeps track of unique (source, destination) pairs for each timestamp batch to detect duplicates.

🚀 Core Methods:
1. bool addPacket(int source, int destination, int timestamp)

Description:
Adds a packet to the router if it's not a duplicate within the same timestamp and there's room in memory.

Returns:

true: Packet added successfully.

false: Packet was a duplicate for the current timestamp and was discarded.

Behavior:

Clears the seen set when a new timestamp batch starts.

Evicts the oldest packet if memory limit is reached.

2. vector<int> forwardPacket()

Description:
Forwards (removes and returns) the oldest packet in the queue.

Returns:

A vector {source, destination, timestamp} of the forwarded packet.

Empty vector {} if no packet is available.

Side Effects:

Updates internal structures (q, byDest, and seen) accordingly.

3. int getCount(int destination, int startTime, int endTime)

Description:
Counts how many packets have been sent to the given destination in the time window [startTime, endTime].

Returns:

An integer count using binary search over sorted timestamps.

🧠 Internal Helper:
long long pack(int source, int destination)

Purpose:
Packs a (source, destination) pair into a long long for uniqueness tracking in seen.

Bitwise Logic:

return ((long long)source << 32) | destination;

📊 Complexity Analysis:

-> addPacket	O(1) (amortized)	O(N)
-> forwardPacket	O(1)	O(N)
-> getCount	O(log N)	O(1)

Where N = memoryLimit, the maximum number of stored packets.