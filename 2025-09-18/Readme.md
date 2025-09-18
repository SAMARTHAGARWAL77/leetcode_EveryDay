✅ Task Manager System

📅 Date:
2025-09-18

📌 Problem Description

You are tasked with implementing a Task Manager System that can:

Add new tasks for users with priorities.

Edit the priority of existing tasks.

Remove tasks from the system.

Execute the highest priority task, returning the userId of the task owner.

In the case of a tie in priority, the task with the larger taskId is preferred.

🧪 Example
vector<vector<int>> tasks = {
    {1, 101, 5},
    {2, 102, 10},
    {3, 103, 8}
};

TaskManager* obj = new TaskManager(tasks);
obj->add(4, 104, 10);           // Add new task with priority 10
obj->edit(101, 12);             // Edit task 101's priority to 12
obj->rmv(102);                  // Remove task 102
int userId = obj->execTop();    // Executes highest priority task (task 101), returns userId 1

🚀 Approach

The TaskManager class uses C++ STL containers to efficiently manage tasks based on their priority and identifiers.

🔧 Data Structures Used

map<int, int> taskToUser:
Maps each taskId to its associated userId.

map<int, int> taskToPriority:
Stores the current priority for each taskId.

set<pair<int, int>> task:
Maintains a sorted set of {priority, taskId} pairs.

Sorted first by ascending priority.

For equal priorities, tasks with larger taskId appear later.

This allows execTop() to retrieve the task with highest priority and largest taskId efficiently.

🔄 Core Methods
✅ Constructor
TaskManager(vector<vector<int>>& tasks)


Initializes the task manager with a list of existing tasks. Each task is a triplet [userId, taskId, priority].

➕ add(int userId, int taskId, int priority)

Adds a new task to the system.

✏️ edit(int taskId, int newPriority)

Updates the priority of an existing task.

❌ rmv(int taskId)

Removes a task from the system entirely.

▶️ execTop() -> int

Executes the task with the highest priority, removes it from the system, and returns its associated userId.

If no tasks are available, returns -1.

📊 Time Complexity

Constructor	O(N log N)
add	O(log N)
edit	O(log N)
rmv	O(log N)
execTop	O(log N)

Where N is the number of tasks currently stored.

🧠 Key Concepts

-> Efficient log-time insertions and deletions using std::set.
-> Mapping relationships between tasks and users via map.
-> Custom sorting behavior derived from pair ordering in set.

🛠️ Note

-> Task priorities are assumed to be unique per taskId.
-> If execTop() is called when there are no tasks, it returns -1.
