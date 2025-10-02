class Solution {
    public int maxBottlesDrunk(int numBottles, int numExchange) {
    int count = numBottles;
    int empty = numBottles;
    while(empty >= numExchange)
    {
        empty = empty - numExchange;
        numExchange++;
        empty++;
        count++;
    }    
    return count;
    }
}